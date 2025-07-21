import java.util.Scanner;

/*
      *
    * *
  * * *
* * * *
*/


public class Pattern17 {
    public static void main(String[] args) {
        int n = 0;
        System.out.print("Enter the number of rows: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <= n ; j++) {
                while (i+j <= n){
                    System.out.print(" " + " ");
                    j++;
                }
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
