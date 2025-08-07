package my_fileio_proj.src;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ReadFileExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the file name you want to read");
        Path path = Paths.get(sc.nextLine());
        try{
            String content = Files.readString(path);
            System.out.println(content);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
