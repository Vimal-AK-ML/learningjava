//9. Define an enum named Day that represents the days of the week. 
// Add a method to the enum called isWeekend() that returns true if the day is either SATURDAY or SUNDAY, and false otherwise.
//  What's the role of values() and valueOf()?
// values()	Returns an array of all enum constants. Useful for iteration.
// valueOf(String name)	Returns a specific enum constant by name. Throws an exception if the name is incorrect.


public class java9 {
  public static void main(String[] args) {
      Test t1=new Test(Day.SATURDAY);
      t1.isWeekend();
  }
 
 }
 
enum Day{
  MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY;
}
class Test{
  Day current;
  Test(Day current){
    this.current=current;
  }
  public void isWeekend(){
    if(current==Day.SATURDAY || current==Day.SUNDAY){
      System.out.println("True");
    }else{
      System.out.println("False");
    }
  }
}
