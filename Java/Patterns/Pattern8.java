import java.util.Scanner;

/*
1
2 1
3 2 1
4 3 2 1
*/

public class Pattern8 {
    public static void main(String[] args) {
        int n = 0;
        System.out.print("Enter the number of rows: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= i ; j++) {
                System.out.print(i-j+1 + " ");
            }
            System.out.println();
        }
    }
}
