class Calculator{
    int num=5;
    final static float PI = 3.14F;
    public int add(int n1, int n2){
        System.out.println(num);
        return n1+n2;
    }
}

public class Basic{
    public static void main(String args[]){
        System.out.print("Hello world :)\n");
        int data = 10;
		Calculator obj = new Calculator();
		Calculator obj1 = new Calculator();

        // int address = System.identityHashCode(obj); //retuns hashcode of the obj which is derived from its memory address
        // System.err.println("Approx address of obj: 0x" + Integer.toHexString(address)); // to give the feel of a memory address
		int r1 = obj.add(3,4);
		//System.out.println(r1);
		obj.num = 8;
        System.out.println(Calculator.PI* obj1.num * obj1.num);
		
		System.out.println(obj.num);
		System.out.println(obj1.num);
    }
}