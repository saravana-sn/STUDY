public class BitWise {
    public static void main(String[] args) {
        int a = 5, b = 7;
        //System.out.println(Integer.toBinaryString(a));
        //To play with binary use bitwise operators
        //operands -> byte, short, int, long
        // and &
        // or |
        // xor ^
        // not ~
        //left shift <<
        //right shift >>
        // unsigned right shift >>>
        System.out.println(a&b);
        System.out.println(a|b);
        System.out.println(a^b);
        System.out.println(~a);
        System.out.println(a<<b);
        System.out.println(a>>1);

    }
}
