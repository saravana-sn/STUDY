package my_arraylist_proj.src;

public class Task {
    public static int HIGH = 3;
    public static int MEDIUM = 2;
    public static int LOW = 1;

    public static String COMPLETED = "COMPLETED";
    public static String IN_PROGRESS = "IN_PROGRESS";
    public static String NEW = "NEW";

    private String taskName;
    private int priority = LOW;
    private String status = NEW;

    public Task(String taskName) {
        this.taskName = taskName;
    }
    public Task(String taskName, int priority) {
        this.taskName = taskName;
        this.priority = priority;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }
    public String getStatus() {
        return this.status;
    }
    public int getPriority() {
        return this.priority;
    }
    public String toString() {
        return taskName.concat(" ").concat((priority+"")).concat(" ").concat(status);
    }
}
