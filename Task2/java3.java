//3. Create an interface Shape with a calculateArea() method. 
//Write a program to create objects of Circle and Rectangle classes that implement Shape, set their dimensions, 
//calculate and print their areas. 
public class java3 {
  public static void main(String[] args){
    Rectangle r1=new Rectangle();
    r1.getarea(5,6);
    Circle c1=new Circle();
    c1.getarea(10);
  
  }  
  }
interface Allarea{
  default void getarea(int r){
    System.out.println("Area of Circle   "+Math.PI*(r*r));
  };
}
class Rectangle implements Allarea{
  public void getarea(int l,int b){
    System.out.println("Area of Rectangle    "+(l*b));
  }
}
class Circle implements Allarea{
}
