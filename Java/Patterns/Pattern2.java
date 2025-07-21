import java.util.Scanner;

/*
4 3 2 1
4 3 2 1
4 3 2 1
4 3 2 1
*/

public class Pattern2 {
    public static void main(String[] args) {
        int n = 0;
        System.out.print("Enter the number of rows: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = n; j >= 1; j--) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
