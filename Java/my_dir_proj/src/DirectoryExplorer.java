package my_dir_proj.src;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DirectoryExplorer {
    private static void directoryList(File dirObj) {
        // Print a message indicating that the directory is being listed recursively
        System.out.println("Printing " + dirObj + " recursively");
        // Get a list of files and subdirectories in the directory
        File files[] = dirObj.listFiles();
        // Iterate over the list of files and subdirectories
        for (int i = 0; i < files.length; i++) {
            // Check if the current item is a file
            if (files[i].isFile()) {
                // Print the absolute path of the file
                System.out.println(files[i]);
            } else {
                // If the current item is a subdirectory, recursively list its contents
                directoryList(files[i]);
            }
        }
    }

    private static void fileManagement(File f){
        System.out.println("\nPress 1 to rename the file," +
                "\nPress 2 to delete the file," +
                "\nAny other key to exit");

        Scanner fileScanner = new Scanner(System.in);
        String choice = fileScanner.nextLine();
        switch (choice) {
            case "1":
                System.out.println("Enter the new name for file "+ f.getName());
                String newFileName = fileScanner.nextLine();
                boolean renamed = f.renameTo(new File(f.getParent(), newFileName));
                if (renamed) {
                    System.out.println("The file has been successfully renamed.");
                }else  {
                    System.out.println("Rename failed.");
                }
                break;
            case "2":
                boolean deleted = f.delete();
                if (deleted) {
                    System.out.println("The file has been successfully deleted.");
                }else   {
                    System.out.println("Delete failed.");
                }
                break;
            default:
                System.out.println("Wrong choice.");
                break;
        }
    }

    private  static void directoryManagement(File d){
        System.out.println("\nPress 1 to list the directory," +
                "\nPress 2 to rename the directory," +
                "\nPress 3 to delete the directory," +
                "\nAny other key to exit");

        Scanner fileScanner = new Scanner(System.in);
        String choice = fileScanner.nextLine();
        if(choice.equals("1")){
            String[] fileNames = d.list();
            if(fileNames.length==0){
                System.out.println("Empty Directory");
            }else{
                for (int i = 0; i < fileNames.length; i++) {
                    System.out.println(fileNames[i]);
                }
            }
            directoryList(d);
        } else if (choice.equals("2")) {
            System.out.println("Enter the new name for the directory " + d.getName());
            String newDirName = fileScanner.nextLine();
            boolean changed = d.renameTo(new File(d.getParent(), newDirName));
            if (changed) {
                System.out.println("Directory name successfully changed");
            } else {
                System.out.println("Directory name couldn't be changed!");
            }
        }else if (choice.equals("3")) {
            boolean deleted = d.delete();
            if (deleted) {
                System.out.println("Directory successfully deleted");
            } else {
                System.out.println("Directory couldn't be deleted! It might not be empty");
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\nPress 1 for file management\n Any other key to exit");
            String userAction = sc.nextLine();
            if (userAction.equals("1")){
                System.out.println("Enter the fileName with its path: ");
                String fileName = sc.nextLine();
                File file = new File(fileName);
                if(file.exists()){
                    if(file.isDirectory()){
                        System.out.println("Directory Exists");
                        directoryManagement(file);
                    }else{
                        System.out.println("File Exists");
                        fileManagement(file);
                    }
                }else {
                    System.out.println("File Does Not Exist");
                    System.out.println("To create a file with given name press 1\n"
                            + "To create a directory with given name press 2\n"
                            + "To do nothing and continue, press any other key");
                    String createChoice = sc.nextLine();
                    if(createChoice.equals("1")){
                        String ParentDirStr = file.getParent();
                        File parentDir = new File(ParentDirStr);
                        if(!parentDir.exists()){
                            boolean created = parentDir.mkdirs();
                            if(!created){
                                System.out.println("Directory Creation Failed");
                                continue;
                            }
                        }
                        try{
                            file.createNewFile();
                            System.out.println("File Created Successfully");
                        }catch(IOException e){
                            System.out.println("File Creation Failed" + e);
                        }
                        System.out.println("Enter the fileName with its path: ");
                    } else if (createChoice.equals("2")) {
                        boolean created = file.mkdirs();
                        if(created){
                            System.out.println("Directory Created Successfully");
                        }else {
                            System.out.println("Directory Creation Failed");
                        }
                    }else {
                        System.out.println("Bye!");
                        break;
                    }
                }
            }
        }

    }
}
