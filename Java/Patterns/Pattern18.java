import java.util.Scanner;

/*
 * * * *
 * * *
 * *
 *
 */

public class Pattern18 {
    public static void main(String[] args) {
        int n = 0;
        System.out.print("Enter the number of rows: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = n; j >=i ; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
