import java.util.Scanner;

/*
1 1 1 1
  2 2 2
    3 3
      4
*/

public class Pattern19 {
    public static void main(String[] args) {
        int n = 0;
        System.out.print("Enter the number of rows: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int k = 0;

        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=n ; j++) {
                if(j < i){
                    System.out.print(" "+ " ");
                }else{
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        }
    }
}
