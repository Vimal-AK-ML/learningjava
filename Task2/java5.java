// 5. Given a list of Employee objects containing name, department and salary fields, use the Stream API to perform the following tasks:
// - Filter out employees whose salary is less than Rs. 50,000.
// - Group the remaining employees by their department.
// - Sort each department's employees by their salary in descending order.
//- Collect the result into a Map<String, List<Employee>> where the key is the department name and the value is the list of employees in that department, sorted by salary.

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.*;

public class java5 {
  public static void main(String[] args) {
 ArrayList<Employee> employees = new ArrayList<>();
 employees.add(new Employee("Software", "John", 23000));
employees.add(new Employee("Account", "Doug", 190000));
employees.add(new Employee("HR", "Jack", 200000));
employees.add(new Employee("Software", "Daisy", 2400));
employees.add(new Employee("HR", "William", 220000));
employees.add(new Employee("Marketing", "Emma", 45000));
employees.add(new Employee("Finance", "Sophia", 72000));
employees.add(new Employee("Software", "Liam", 56000));
employees.add(new Employee("Account", "Olivia", 150000));
employees.add(new Employee("HR", "Noah", 180000));
employees.add(new Employee("Marketing", "Ethan", 48000));
employees.add(new Employee("Finance", "Ava", 70000));
employees.add(new Employee("Software", "James", 80000));
employees.add(new Employee("HR", "Lucas", 210000));
employees.add(new Employee("Software", "Mia", 65000));
employees.add(new Employee("Finance", "Amelia", 95000));
employees.add(new Employee("Marketing", "Isabella", 50000));
employees.add(new Employee("HR", "Mason", 170000));
employees.add(new Employee("Software", "Benjamin", 85000));
employees.add(new Employee("Finance", "Elijah", 102000));
employees.add(new Employee("Software", "Daniel", 92000));
employees.add(new Employee("HR", "Charlotte", 195000));
employees.add(new Employee("Account", "Harper", 175000));
employees.add(new Employee("Software", "Evelyn", 74000));
employees.add(new Employee("Marketing", "Logan", 53000));
employees.add(new Employee("HR", "Alexander", 2000));
employees.add(new Employee("Finance", "Henry", 110000));
employees.add(new Employee("Software", "Sebastian", 69000));
employees.add(new Employee("Account", "Scarlett", 160000));
employees.add(new Employee("Marketing", "Ella", 51000));
employees.add(new Employee("Software", "Zoe", 680));
employees.add(new Employee("HR", "Michael", 205000));
employees.add(new Employee("Finance", "Jack", 1000));
employees.add(new Employee("Software", "Victoria", 93000));
employees.add(new Employee("Marketing", "Lucas", 54000));
employees.add(new Employee("HR", "Grace", 18050));
employees.add(new Employee("Software", "Chloe", 72000));

 // - Filter out employees whose salary is less than Rs. 50,000.
 Stream<Employee> emp=employees.stream().filter((Employee item)->item.empSalary<50000);
 List<Employee> output=emp.collect(Collectors.toList());
 System.out.println("Filter out employees whose salary is less than Rs. 50,000."); 
 System.out.println("---------------------------------------------------------------");
 System.out.println("        Department    "+"    Name      "+"    Salary     ");  
 for(Employee details:output){
  System.out.println("        "+details.empDepart+"        "+details.empName+"          "+details.empSalary);  
 }
 System.out.println("---------------------------------------------------------------"); 
 System.out.println("---------------------------------------------------------------"); 
// - Group the remaining employees by their department.
Stream<Employee> emp1=employees.stream().filter((Employee item)->item.empSalary<50000);
List<Employee> outputgroup=emp1.sorted(Comparator.comparing(item->item.empDepart)).collect(Collectors.toList());
System.out.println("Group the remaining employees by their department."); 
System.out.println("---------------------------------------------------------------");
 System.out.println("        Department    "+"    Name      "+"    Salary     ");  
 for(Employee details:outputgroup){
  System.out.println("        "+details.empDepart+"        "+details.empName+"          "+details.empSalary);  
 }
 System.out.println("---------------------------------------------------------------"); 
 System.out.println("---------------------------------------------------------------"); 
// - Sort each department's employees by their salary in descending order.
List<Employee> output1=employees.stream().sorted(Comparator.comparing(item->item.empSalary)).collect(Collectors.toList());
System.out.println("Sort each department's employees by their salary in descending order."); 
System.out.println("---------------------------------------------------------------");
System.out.println("        Department    "+"    Name      "+"    Salary     ");  
for(Employee details:output1){
 System.out.println("        "+details.empDepart+"        "+details.empName+"          "+details.empSalary);  
}
System.out.println("---------------------------------------------------------------"); 
System.out.println("---------------------------------------------------------------"); 
//- Collect the result into a Map<String, List<Employee>> where the key is the department name and the value is the list of employees in that department, 
// sorted by salary.
Map<String, List<Employee>> output2=employees.stream()
.collect(Collectors.groupingBy(
  e -> e.empDepart,
Collectors.collectingAndThen(
  Collectors.toList(),
  list->list.stream()
            .sorted(Comparator.comparing(empl->empl.empSalary))
            .collect(Collectors.toList())
)
));
System.out.println("Collect the result into a Map<String, List<Employee>> where the key is the department name and the value is the list of employees in that department,sorted by salary."); 
System.out.println("---------------------------------------------------------------");
output2.forEach((department, empList) -> {
            System.out.println(department + ":");
            empList.forEach(e -> System.out.println("  " + e.empName + " - " + e.empSalary));
        });
System.out.println("---------------------------------------------------------------"); 
 }
  }
   public class Employee {
    String empDepart;
    String empName;
    long empSalary;
  
    public Employee(String empDepart, String empName, long empSalary) {
        this.empDepart = empDepart;
        this.empName = empName;
        this.empSalary = empSalary;
    }
  }
