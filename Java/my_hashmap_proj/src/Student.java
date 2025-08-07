package my_hashmap_proj.src;

public class Student {
    private String name;
    private int age;
    private String major;

    public Student(String name, int age, String major) {
        this.setName(name);
        this.setAge(age);
        this.setMajor(major);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", age=" + age + ", major=" + major + '}';
    }
}
