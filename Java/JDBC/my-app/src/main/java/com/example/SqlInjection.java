package com.example;

import java.sql.*;
import java.util.Scanner;

public class SqlInjection {
    public static void sqlInjection() {
        System.out.println("SQL Injection test....");
        String url = "jdbc:mysql://localhost:3306/MY_DATABASE"; // Change to your database
        String user = "root"; // Your database username
        String password = ""; // Your database password
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your Major Name:(cheeky? -> a' OR '1'='1)");
        String major = sc.nextLine();

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connection Success");

             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from Students WHERE Major = '" + major + "' ");
            while (resultSet.next()) {
                System.out.print("Student ID: " + resultSet.getInt("StudentID"));
                System.out.print("     |     ");
                System.out.print("Name: " + resultSet.getString("Name"));
                System.out.print("     |     ");
                System.out.println("Major: " + resultSet.getString("Major"));
            }

            System.out.println("Try SQL Injection again :)... prepared Statement for you >,,<");
            System.out.println("Enter your Major Name:(cheeky? -> a' OR '1'='1)");
            major = sc.nextLine();

            PreparedStatement preparedStatement = connection.prepareStatement("select * from Students WHERE Major = ?");
            preparedStatement.setString(1, major);
            ResultSet resultSet2 = preparedStatement.executeQuery();
            while (resultSet2.next()) {
                System.out.print("Student ID: " + resultSet2.getInt("StudentID"));
                System.out.print("     |     ");
                System.out.print("Name: " + resultSet2.getString("Name"));
                System.out.print("     |     ");
                System.out.println("Major: " + resultSet2.getString("Major"));
            }

        } catch (Exception e) {
            System.out.println("Connection Failed: " + e.getClass().getSimpleName() + " - " + e.getMessage());
            e.printStackTrace();
            System.out.println("Hint: Verify MySQL is running, database 'MY_DATABASE' exists, credentials are correct, and the JDBC URL matches your setup.");
        }
    }
}
