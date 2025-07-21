import java.util.Scanner;

/*
A
B B
C C C
*/

public class Pattern13 {
    public static void main(String[] args) {
        int n = 0;
        System.out.print("Enter the number of rows: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= i ; j++) {
                char temp = (char) ('A' + i - 1 );
                System.out.print( temp + " ");
            }
            System.out.println();
        }
    }
}
