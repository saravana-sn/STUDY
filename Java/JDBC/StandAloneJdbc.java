import java.sql.*;

public class StandAloneJdbc {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/MY_DATABASE"; // Change to your database
        String user = "root"; // Your database username
        String password = ""; // Your database password

        try {
            // Establishing connection
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();

            System.out.println("connection successful!");

            // Your JDBC code here
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Students");
            while (resultSet.next()) {
                System.out.println("Student ID: " + resultSet.getInt("StudentID"));
                System.out.println("Name: " + resultSet.getString("Name"));
                System.out.println("Major: " + resultSet.getString("Major"));
            }

            resultSet = statement.executeQuery(
                    "SELECT * FROM Students WHERE Major = 'Computer Science'");

            System.out.println("Students with major of Computer Science");

            while (resultSet.next()) {
                System.out.println("Name: " + resultSet.getString("Name"));
            }

            resultSet = statement.executeQuery(
                    "SELECT * FROM Students ORDER BY GPA DESC");
            System.out.println("Printing students with descending GPAs");

            while (resultSet.next()) {
                System.out.println("Name: " + resultSet.getString("Name"));
                System.out.println("GPA: " + resultSet.getDouble("GPA"));
            }

            resultSet = statement.executeQuery(
                    "SELECT * FROM Students ORDER BY GPA DESC LIMIT 5");
            System.out.println("Limiting resultset to 5");
            while (resultSet.next()) {
                System.out.println("Name: " + resultSet.getString("Name"));
            }

            resultSet = statement.executeQuery(
                    "SELECT Major, COUNT(*) AS StudentCount FROM Students GROUP BY Major");

            System.out.println("Count students by major");

            while (resultSet.next()) {
                System.out.println("Major: " + resultSet.getString("Major"));
                System.out.println("Number of Students: " + resultSet.getInt("StudentCount"));
            }

            resultSet = statement.executeQuery(
                    "SELECT Students.Name, Courses.CourseName " +
                            "FROM Students " +
                            "INNER JOIN Enrollments ON Students.StudentID = Enrollments.StudentID " +
                            "INNER JOIN Courses ON Enrollments.CourseID = Courses.CourseID");

            System.out.println("Retrieve Student Names and Their Courses");

            while (resultSet.next()) {
                System.out.println("Student: " + resultSet.getString("Name"));
                System.out.println("Course: " + resultSet.getString("CourseName"));
            }

            resultSet = statement.executeQuery(
                    "SELECT * FROM Students WHERE Major IS NULL");

            System.out.println("Retrieve Students Without a Declared Major");

            while (resultSet.next()) {
                System.out.println("Name: " + resultSet.getString("Name"));
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed: " + e.getClass().getSimpleName() + " - " + e.getMessage());
            e.printStackTrace();
            System.out.println("Hint: Verify MySQL is running, database 'MY_DATABASE' exists (see mysql.sql), credentials are correct, and the JDBC URL matches your setup.");
        }
    }
}
