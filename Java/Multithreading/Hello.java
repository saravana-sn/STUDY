package Multithreading;

public class Hello {
    public static void main(String[] args) {
        World world = new World();
        Thread t0 = new Thread(world);
        t0.start();

        for (int i = 0; i <10 ; i++) {
            System.out.println("Hello");
            System.out.println(Thread.currentThread().getName());
        }
    }
}
