package Multithreading;

public class MyThread extends Thread {
    public static void main(String[] args) throws InterruptedException {
        MyThread t0 = new MyThread();
        System.out.println(t0.getState());
        System.out.println(Thread.currentThread().getState());
        System.out.println(Thread.currentThread().getName());
        t0.start();
        System.out.println(t0.getState());
        Thread.sleep(1000);

    }
    @Override
    public void run() {
        try{
            Thread.sleep(1000);
            System.out.println("World");
        }catch (InterruptedException e){
            System.out.println(e);
        }

    }
}
