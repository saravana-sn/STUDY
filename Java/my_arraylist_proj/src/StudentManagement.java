package my_arraylist_proj.src;

import java.util.*;

public class StudentManagement {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(
                "Press 1 to add a student, " +
                "\n2 to view all the students " +
                "\n3 to change major of student " +
                "\n4 to delete a student " +
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
                studentList.add(new Student(name, age, major));
                System.out.println("The student has been added successfully.");
            } else if (userAction.equals("2")) {
                studentList.forEach(System.out::println);
            } else if (userAction.equals("3")) {
                System.out.println("Enter the index of the student you want to change major: ");
                int index = Integer.parseInt(sc.nextLine());
                System.out.println("Enter the major of the student you want to change: ");
                String major = sc.nextLine();
                studentList.get(index).setMajor(major);
                System.out.println("The student has been changed successfully.");
            } else if (userAction.equals("4")) {
                System.out.println("Enter the index of the student you want to delete the student: ");
                int index = Integer.parseInt(sc.nextLine());
                studentList.remove(index);
                System.out.println("The student has been deleted successfully.");
            } else if (userAction.equals("5")) {
                studentList.sort(new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return Integer.compare(o1.getAge(), o2.getAge());
                    }
                });
                studentList.forEach(System.out::println);
            }else{
                break;
            }
        }
    }
}
