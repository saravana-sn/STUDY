public interface MyInterface {
    public String hello = "Hello";

    public void sayHello();
}

interface MyInterface2{
    public String bolo = "Bye.";

    void sayBye();
    void sayHello();

    //default method
    default void saySing(){
        System.out.println("singing");
    }
    default void saySmt(){
        System.out.println("say smt.");
    }

    //static method
    static void sayJoke(){
        System.out.println("saying a joke haha xD");
    }

}

class MyInterfaceImpl implements MyInterface, MyInterface2{
    @Override
    public void sayHello(){
        System.out.println(MyInterface.hello);
    }
    @Override
    public void sayBye(){
        System.out.println(MyInterface2.bolo);
    }
    @Override
    public void saySmt(){
        System.out.println("shut up!!!");
    }
}

class MyInterfaceFakeImpl implements MyInterface2{
    public void sayHello(){
        System.out.println("fake hello");
    }
    public void sayBye(){
        System.out.println("fake bye");
    }
    
}
