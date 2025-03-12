//2. Write a Java program that uses a switch statement to print the day of the week based on an integer input 
//(1 for Monday, 2 for Tuesday, etc.).
import java.util.Scanner;
class Main2{
  public static void main(String[] args){
    System.out.println("PLEASE ENTER THE DAY IN NUMBER");
    Scanner input=new Scanner(System.in);
    int day= input.nextInt();
    switch (day){
      case 1:
      System.out.println("Monday");
      break;
      case 2:
      System.out.println("Tuesday");
      break;
      case 3:
      System.out.println("Wednesday");
      break;
      case 4:
      System.out.println("Thursday");
      break;
      case 5:
      System.out.println("Friday");
      break;
      case 6:
      System.out.println("Saturday");
      break;
      case 7:
      System.out.println("Sunday");
      break;
      default:
      System.out.println("WRONG DAY NUMBER ENTERED");
    }
  }
}