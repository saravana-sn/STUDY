package my_fileio_proj.src;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class ReadFileExampleWithScanner {
    public static void main(String[] args) {
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the filename you want to read");
            Scanner fileScanner = new Scanner(new FileReader(sc.nextLine()));
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
            fileScanner.close();
        }catch (Exception e){
            System.err.println("Error reading file: "+e.getMessage());
        }
    }
}
