package my_hashmap_proj.src;

import java.util.*;

public class StudentManagement {
    public static void main(String[] args) {
        
        HashMap <String,Student> studentHashMap = new HashMap();
        
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(
                "Press 1 to add a student, " +
                "\n2 to view all the students " +
                "\n3 to change major of student " +
                "\n4 to delete a student " +
                "\n5 to sort students by age " +
                "\nAny other key to exit"
            );
            String userAction = sc.nextLine();
            if (userAction.equals("1")) {
                System.out.println("Enter the name of the student you want to add: ");
                String name = sc.nextLine();
                System.out.println("Enter the major of the student you want to change: ");
                String major = sc.nextLine();
                System.out.println("Enter age of the student you want to change: ");
                int age = Integer.parseInt(sc.nextLine());
                studentHashMap.put(name, new Student(name, age, major));
                System.out.println("The student has been added successfully.");
            } else if (userAction.equals("2")) {
                for(String name : studentHashMap.keySet()) {
                    System.out.println(name+" : "+ studentHashMap.get(name));
                }
            } else if (userAction.equals("3")) {
                System.out.println("Enter the name of the student you want to change major: ");
                String name = sc.nextLine();
                System.out.println("Enter the major of the student you want to change: ");
                String major = sc.nextLine();
                
                // Get the existing student object
                Student student = studentHashMap.get(name);
                if (student != null) {
                    // Update the major
                    student.setMajor(major);
                    // Put the updated student back into the HashMap
                    studentHashMap.put(name, student);
                    System.out.println("The student's major has been changed successfully.");
                } else {
                    System.out.println("Student not found with name: " + name);
                }
            } else if (userAction.equals("4")) {
                System.out.println("Enter the name of the student you want to delete: ");
                String name = sc.nextLine();
                Student removedStudent = studentHashMap.remove(name);
                if (removedStudent != null) {
                    System.out.println("The student has been deleted successfully.");
                } else {
                    System.out.println("Student not found with name: " + name);
                }
            } else if (userAction.equals("5")) {
                System.out.println("Sorting students by age:");
                // Convert HashMap values to a List
                List<Student> studentList = new ArrayList<>(studentHashMap.values());
                // Sort the list by age
                studentList.sort(new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return Integer.compare(o1.getAge(), o2.getAge());
                    }
                });
                // Display the sorted list
                for (Student student : studentList) {
                    System.out.println(student);
                }
            }else{
                break;
            }
        }
    }
}
