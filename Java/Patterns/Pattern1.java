import java.util.Scanner;

/*
1 2 3 4
1 2 3 4
1 2 3 4
1 2 3 4
*/

public class Pattern1 {
    public static void main(String[] args) {
        int n = 0;
        System.out.print("Enter the number of rows: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}