// Create a Java class Employee with a field salary of type int. Convert this int to Integer using a wrapper class. 
// Write a method that accepts an Integer and returns its string representation.
import java.util.*;
public class Main6{
    public static void main(String[] args) {
        System.out.println("PLEASE ENTER THE SALARY");
        Scanner input=new Scanner(System.in);
        int sal= input.nextInt();
        Employee emp = new Employee(sal);
  
        Integer salaryAsInteger = emp.getSalaryAsInteger();
        System.out.println("Salary as Integer: " + salaryAsInteger);
        System.out.println(" Salary  Type: " + salaryAsInteger.getClass().getName());
  
        String salaryAsString = emp.integerToString(salaryAsInteger);
        System.out.println("Salary as String: " + salaryAsString);
        System.out.println("Salary Type: " + salaryAsString.getClass().getName());
    }
}
class Employee {

    
  private int salary;

  public Employee(int salary) {
      this.salary = salary;
  }

  public Integer getSalaryAsInteger() {
      return Integer.valueOf(salary); 
  }

  public String integerToString(Integer value) {
      return value.toString();
  }

 
}
