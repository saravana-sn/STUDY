import java.util.Scanner;

/*
      1
    1 2 1
  1 2 3 2 1
1 2 3 4 3 2 1
*/

public class Pattern20 {
    public static void main(String[] args) {
        int n = 0;
        System.out.print("Enter the number of rows: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 1; i <=n ; i++) {
            int k = 1;
            for (int j = 1; j <=n ; j++) {
                while(i+j <= n){
                    System.out.print(" "+ " ");
                    j++;
                }
                if (j <= n){
                    System.out.print(k++ + " ");
                }
            }
            int l = k;
            l -= 2;
            while(l > 0){
                System.out.print(l-- + " ");
            }
            System.out.println();
        }
    }
}
