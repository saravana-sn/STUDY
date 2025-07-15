public class OOP {
   public static void main(String[] args) {

        //classes & objects!
        Car car1 = new Car();
        Car car2 = new Car("cyber truck","tesla",2020);
        Car car3 = new Car(2024);
        Car car4 = new Car(car2);
        if(car2.year == car4.year) System.out.println("copy constructor copied.");
        else System.out.println("something is wrong.");

        Vehicle bike = new Car();
        bike.start();

        // Inheritance!

        Child2 child2 = new Child2();

        //upcast to parent
        Parent fakeParent = child2;

        //downcast to child2(only possible on same child lol which previously upcasted)
        Child2 child21 = (Child2) fakeParent;
        System.out.println(child2.pName);

        //Method Overriding (same method present on Parent but child method gets called.)
        child2.setpName("RubbEr");
        System.out.println(child2.pName);

        Child1 child1 = new Child1();
        child1.setpName("pIkaChu");
        System.out.println(child1.pName);
        System.out.println(child2.pName);// a new pName copy is made on each subclass instance

        Parent parent = new Parent();
        System.out.println(parent.pName);

        System.out.println("[ parent.pName: " + parent.pName +", child1.pName: "+ child1.pName+ ", child2.pName:"+ child2.pName+ " ]");

        //instanceof can be used to check if an reference is an instance of a class.
        boolean isChild2 = fakeParent instanceof Child1;
        System.out.println(isChild2);

        //Abstract keyword!

        Animal animal = new Animal(){  // class Animal extends (anonymous) {}
            @Override
            void eat(){
                System.out.println("Anonymous animal eating..");
            }
        };
        animal.eat();

        AbstractCarImpl abstractcar = new AbstractCarImpl();
        abstractcar.car();

        //Interfaces!
        MyInterfaceImpl myInterface = new MyInterfaceImpl();
        myInterface.sayHello();
        myInterface.sayBye();
        //acessing default method from interface
        myInterface.saySing();
        myInterface.saySmt();
        //acessing static method from interface
        MyInterface2.sayJoke();

        MyInterfaceFakeImpl myInterfaceFakeImpl = new MyInterfaceFakeImpl();
        myInterfaceFakeImpl.sayBye(); 
    }
}

class Car extends Vehicle{
    String model;
    String manufacturer;
    int year;

    // Default Constructor
    public Car(){
        System.out.println("Default Constructor was called.");
    }

    //parameterised Constructor
    public Car(String model, String manufacturer, int year){
        //constructor chaining
        this(year);
        System.out.println("Parameterized Constructor was called.");
        this.model = model;
        this.manufacturer = manufacturer;
    }

    //copy constructor
    public Car(Car obj){
        System.out.println("Copy Constructor was called.");
        this.model = obj.model;
        this.manufacturer = obj.manufacturer;
        this.year = obj.year;
    }
    
    //constructor overloading
    public Car(int year){
        System.out.println("Overloaded year parameterized Constructor was called.");
        this.year = year;
    }
    public Car(String model){
        System.out.println("Overloaded model parameterized Constructor was called.");
        this.model = model;
    }
    void start(){
        System.out.println("starting a car...");
    }
}

class Vehicle{
    void start(){
        System.out.println("starting a generic vehicle...");
    }
}

class Bike extends Vehicle{
    @Override
    void start(){
        System.out.println("Starting a bike...");
    }
}

//Inheritance
class Child1 extends Parent{
    String cName = "Sabun";
    void setpName(String pName){
        super.setpName(pName);
    }
}
class Child2 extends Parent{
    protected String cName = "Lazy";
    @Override
    void setpName(String pName){
        this.pName = pName.toLowerCase();
    }
}
class Parent{
    void setpName(String pName){
        this.pName = pName;
    }
    protected String pName = "Fat";
}

abstract class Animal{
    void eat(){
        System.out.println("animal is eating..");
    }
}