import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/company"; // Replace 'company' with your DB name
        String user = "root";  // Replace with your MySQL username
        String password = "Arumugam12!";  // Replace with your MySQL password

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to MySQL database successfully!");

            // Create a statement object
            Statement stmt = conn.createStatement();
            
            Scanner scanner=new Scanner(System.in);
            System.out.println("Enter Name");
            String name = scanner.next();
            System.out.println("Enter Age");
            int age = scanner.nextInt();
            System.out.println("Enter Department");
            String department = scanner.next();
            // Print results
            String query = "INSERT INTO employees (name, age, department) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, name);   // Set name
            pstmt.setInt(2, age);       // Set age
            pstmt.setString(3, department); // Set department

            int affectedRows = pstmt.executeUpdate();
            System.out.println(affectedRows + " row(s) inserted.");
            // Execute query to fetch employee data
            query = String.format("INSERT INTO employees VALUES(%s,%d,%s)", name, age, department);
            stmt.executeUpdate(query);
            ResultSet rs = stmt.executeQuery("SELECT * FROM employees");
            System.out.println("Employee List:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                                   ", Name: " + rs.getString("name") +
                                   ", Age: " + rs.getInt("age") +
                                   ", Department: " + rs.getString("department"));
            }

            // Close resources
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
