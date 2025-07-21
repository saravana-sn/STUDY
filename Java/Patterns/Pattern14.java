import java.util.Scanner;

/*
A
B C
D E F
G H I J
*/

public class Pattern14 {
    public static void main(String[] args) {
        int n = 0;
        System.out.print("Enter the number of rows: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int k = 1;

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= i ; j++) {
                char temp = (char) ('A' + k++ - 1 );
                System.out.print( temp + " ");
            }
            System.out.println();
        }
    }
}
