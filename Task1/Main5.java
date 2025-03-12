//5. Write a class Person with fields name, age, and address. Implement multiple constructors to initialize these fields in different ways (e.g., only name, name and age, all three fields). 
// Create instances of the Person class using different constructors and display their details.
public class Main5 {
  public static void main(String[] args) {
      Person p1=new Person("A");
      Person p2=new Person("B",18);
      Person p3=new Person("C",20,"Coimbatore");
    p3.print();
    p2.print();
    p1.print();
  }
}
class Person{
  String name,address;
  int age;

  Person(String name){
    this.name=name;
  }
  Person(String name,int age){
    this.name=name;
    this.age=age;
  }
  Person(String name,int age,String address){
    this.name=name;
    this.age=age;
    this.address=address;
  }
  public void print(){
    System.out.println("-------------------------------------");
    if(name!=null){
      System.out.println("Name "+name);
    }
    if(age!=0){
      System.out.println("Age "+age);
    }
    if(address!=null){
      System.out.println("Address "+address);
    }
    System.out.println("-------------------------------------");
  }
}
