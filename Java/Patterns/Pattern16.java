import java.util.Scanner;

/*
D
C D
B C D
A B C D
*/

public class Pattern16 {
    public static void main(String[] args) {
        int n = 0;
        System.out.print("Enter the number of rows: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i ; j++) {
                char temp = (char) ('A' + (n-(i-j+1)+1) - 1);
                System.out.print( temp + " ");
            }
            System.out.println();
        }
    }
}
