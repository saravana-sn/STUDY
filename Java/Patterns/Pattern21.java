import java.util.Scanner;

/*
       *
     *   *
   *       *
 * * * * * * *
 */

public class Pattern21 {
    public static void main(String[] args) {
        int n = 0;
        System.out.print("Enter the number of rows: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n - i ; j++) {
                System.out.print(" "+ " ");
            }
            for (int k = 1; k < i*2 ; k++) {
                if(k==1 || k== i*2-1) System.out.print("* ");
                else if (i == n) System.out.print("* ");
                else System.out.print("  ");
            }
            System.out.println();
        }
    }
}
