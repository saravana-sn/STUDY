import java.util.Scanner;

class BasicMath {
    public static void main(String []args){
        while(true){
            System.out.println("Basic Math:\n1. Count Digits\n2. Reverse a number\n3. Check Palindrome\n4. LCM and GCD\n5. Amstrong Number\n6. Print all divisors\n7. Check for prime\n0. Exit");
            System.out.println("Enter your choice: ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            BasicMath obj = new BasicMath();
            switch (choice) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("Executing Count Digits..............");
                    System.out.print("Enter a number: ");
                    int n = sc.nextInt();
                    System.out.println("You entered a " + obj.countDigits(n) + " digit number.");
                    System.out.println(obj.countDivisorDigits(n) + " digits in this number can divide this number");
                    break;
                case 2:
                    System.out.println("Executing Reverse a number............");
                    System.out.print("Enter a number: ");
                    int num = sc.nextInt();
                    System.out.println("Reversed number: " + obj.reverseNumber(num));
                    break;
                case 3:
                    System.out.println("Executing Check Palindrome............");
                    System.out.print("Enter a number: ");
                    int x = sc.nextInt();
                    System.out.println(obj.checkPalindrome(x));
                    break;
                case 4:
                    System.out.println("Executing LCM and GCD.................");
                    System.out.println("Enter two numbers to find their LCM and GCD:");
                    int a = sc.nextInt();
                    int b = sc.nextInt();
                    int [] res = new int[2];
                    res = obj.gcdAndLcm(a,b);
                    System.out.println("The lcm is "+ res[0] +"\nThe gcd is "+ res[1]);
                    break;
                case 5:
                    System.out.println("Executing Amstrong Number.............");
                    System.out.print("Enter a number: ");
                    int y = sc .nextInt();
                    System.out.println(obj.isAmstrongNumber(y));
                    break;
                case 6:
                    System.out.println("Executing Print all divisors..........");
                    System.out.print("Enter a number: ");
                    int z = sc.nextInt();
                    System.out.println(obj.sumOfDivisors(z));
                    break;
                case 7:
                    System.out.println("Executing Check for prime.............");
                    System.out.print("Enter a number: ");
                    int l = sc.nextInt();
                    System.out.println(obj.isPrime(l));
                    break;
                default:
                    System.out.println("Number not in range of 0 to 7.");
            }
            sc.close();
        }
    }
    //1. Count Digits
    int countDigits(int a){
        int temp = a;
        //Brute force
        int res = 0;
        while(a!=0){
            res++;
            a /= 10;
        }
        System.out.println("Brute force approach: "+ res );
        return (int) Math.log10(temp) + 1;
    }
    int countDivisorDigits(int a){
        int res = 0;
        int num = a;
        while (num!=0){
            int tmp =  num%10;
            if(tmp != 0 && a%tmp==0) res++;
            num /= 10;
        }
        return res;
    }
    //2. Reverse a number
    //Extract last digit, put it on result, check the overflow condition by removing last digit and checking if its equal as result (it will not be equal if the overflow occured), remove last digit on x and continue the loop.
    int reverseNumber(int num){
        int res = 0;
        while(num!=0){
            int tail = num % 10;
            int tmpResult = res *10 + tail;
            if((tmpResult-tail)/10 != res) return 0;//checking overflow condition
            res = tmpResult;
            num /= 10;
        }
        return res;
    }
    //3. Check Palindrome
    boolean checkPalindrome(int n){
        if(n<0) return false;
        int res = 0, num = n;
        while(n!=0){
            int tail = n % 10;
            int tmpResult = res *10 + tail;
            if((tmpResult-tail)/10 != res) return false;//checking overflow condition
            res = tmpResult;
            n /= 10;
        }
        return (res==num);
    }
    //4. LCM and GCD
    int [] gcdAndLcm(int a, int b){
        int A = a, B=b;
        while(A>0 && B>0){
            if(A>B) A %= B;
            else B %= A;
        }
        int gcd = (A==0)? B:A;
        return new int[]{(a*b)/gcd,gcd};
    }
    //5. Amstrong number
    boolean isAmstrongNumber(int n){
        int sum = 0, num = n;
        int digit = (int) Math.log10(n) + 1;
        while(num!=0){
            int tail = num%10;
            int pow = 1;
            for(int i = digit; i>0; i--) pow *= tail;
            sum += pow;
            num /= 10;
        }
        return n == sum;
    }
    //6. sum of divisors
    int sumOfDivisors(int n) {
        int res = 0;
        for (int i= 1; i<=n; i++){
            int sum = 0;
            for (int j = 1; j<=i; j++){
                if(i%j == 0) sum += j;
            }
            res += sum;
        }
        return res;
    }
    //7. Check prime
    boolean isPrime(int n){
        int divisor = 0;
        for(int i=1; i<=(int)Math.sqrt(n);i++){
            if(n%i==0){
                divisor++;
                if(n/i != i) divisor++;
            } 
        }
        return (divisor==2);
    }
    //8.Factorial (Basic Reursion)
    long factorial(int n){
        if (n==1) return 1;
        long res = factorial(n-1) * n;
        return res;
    }
}