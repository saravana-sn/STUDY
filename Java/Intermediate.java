import java.util.LinkedList;
import java.util.List;

public class Intermediate {
    public static void main(String[] args) {
        Intermediate intermediate = new Intermediate();
        MethodChaining method = intermediate.new MethodChaining();

        //method chaining
        method.dailogue().dailogue().dailogue().setFunCall(99).dailogue(69).dailogue();

        Student student = new Student();
        student.printAge().setAge(7).printAge().setAge(23).printAge();
    }

    //non-static nested class
    public class MethodChaining{
        int funCall = 0;
        public MethodChaining setFunCall(int funCall) {
            this.funCall = funCall;
            return this;
        }

        public MethodChaining dailogue(){
            this.funCall++;
            //this.funCall DID NOT got shadowed by funCall => no confusion in this scope.
            System.out.println("Hello Method Chaining "+ funCall);
            return this;
        }

        public MethodChaining dailogue(int funCall){
            this.funCall++;
            //this.funCall got shadowed by funCall => confusion between this.funCall and funCall in this scope.
            System.out.println("Hello Method Chaining "+ funCall + "   <- shadowed by parameter/local variable");
            System.out.println("Hello Method Chaining "+ this.funCall + "  <- unshadowed instance variable");
            return this;
        }
        
    }
    //static nested class
    public static class Student{
        private int age = 9;
        int roll = 37;
        private static int present = 0;
        
        public int getAge() {
            return age;
        }
        public Student setAge(int age) {
            this.age = age;
            return this;
        }
        public Student printAge(){
            System.out.println("Age of roll no."+ roll +" is " + age);
            return this;
        }
    }
    public class StaticBlockDemo {
        public static List<String> ranks = new LinkedList<>();

        static {
            ranks.add("Lieutenant");
            ranks.add("Captain");
            ranks.add("Major");
        }
        
        static {
            ranks.add("Colonel");
            ranks.add("General");
        }
    }
}