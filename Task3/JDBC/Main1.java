import java.sql.*;
import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/lenden"; // Replace 'company' with your DB name
        String user = "root";  // Replace with your MySQL username
        String password = "Arumugam12!";  // Replace with your MySQL password

        Connection conn = null;
        PreparedStatement debitPreparedStatement = null;
        PreparedStatement creditPreparedStatement = null;
        ResultSet rs = null;

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to MySQL database successfully!");

            // Disable auto-commit mode to allow manual transaction control
            conn.setAutoCommit(false);

            // Create PreparedStatement objects for debit and credit operations
            String debitquery = "UPDATE accounts SET balance = balance - ? WHERE account_number = ?";
            String creditquery = "UPDATE accounts SET balance = balance + ? WHERE account_number = ?";
            debitPreparedStatement = conn.prepareStatement(debitquery);
            creditPreparedStatement = conn.prepareStatement(creditquery);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter account_number for debit:");
            int account_number1 = scanner.nextInt();
            System.out.println("Enter account_number for credit:");
            int account_number2 = scanner.nextInt();
            System.out.println("Enter debit amount:");
            Double balance = scanner.nextDouble();
            System.out.println("Enter credit amount:");
            Double balance1 = scanner.nextDouble();

            // Set parameters for the debit and credit operations
            debitPreparedStatement.setDouble(1, balance);
            debitPreparedStatement.setInt(2, account_number1);
            creditPreparedStatement.setDouble(1, balance1);
            creditPreparedStatement.setInt(2, account_number2);

            // Execute debit and credit update operations
            int affectedRows1 = debitPreparedStatement.executeUpdate();
            int affectedRows2 = creditPreparedStatement.executeUpdate();

            System.out.println("Debit rows affected: " + affectedRows1);
            System.out.println("Credit rows affected: " + affectedRows2);

            // Check if the balance is sufficient before committing the transaction
            String query1 = "SELECT balance FROM accounts WHERE account_number = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query1);
            preparedStatement.setInt(1, account_number1);
            ResultSet new1 = preparedStatement.executeQuery();

            if (new1.next()) {
                if (balance < new1.getDouble("balance")) {
                    // Commit the transaction if balance is sufficient
                    conn.commit();
                    System.out.println("Transaction successful. Balance updated.");
                } else {
                    // Rollback the transaction if balance is insufficient
                    conn.rollback();
                    System.out.println("Insufficient balance. Transaction rolled back.");
                }
            } else {
                // Rollback if account not found
                conn.rollback();
                System.out.println("Account not found. Transaction rolled back.");
            }

            // Print all accounts
            rs = preparedStatement.executeQuery("SELECT * FROM accounts");
            System.out.println("Employee List:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", AccountNumber: " + rs.getInt("account_number") +
                        ", Balance: " + rs.getDouble("balance"));
            }

            // Close resources
            scanner.close();
            if (rs != null) rs.close();
            if (preparedStatement != null) preparedStatement.close();
            if (debitPreparedStatement != null) debitPreparedStatement.close();
            if (creditPreparedStatement != null) creditPreparedStatement.close();
            if (conn != null) conn.close();

        } catch (SQLException | ClassNotFoundException e) {
            try {
                if (conn != null) {
                    conn.rollback(); // Rollback transaction if an exception occurs
                    System.out.println("Transaction rolled back due to an error.");
                }
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            // Ensure all resources are closed in case of an exception
            try {
                if (rs != null) rs.close();
                if (debitPreparedStatement != null) debitPreparedStatement.close();
                if (creditPreparedStatement != null) creditPreparedStatement.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
