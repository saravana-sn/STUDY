import java.util.Scanner;

/*
A B C
B C D
C D E
*/

public class Pattern12 {
    public static void main(String[] args) {
        int n = 0;
        System.out.print("Enter the number of rows: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n ; j++) {
                char temp = (char) ('A' + (i + j -1) - 1 );
                System.out.print( temp + " ");
            }
            System.out.println();
        }
    }
}
