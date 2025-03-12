 // 2. Write a Java class Car where the fields are model, year, and color. 
//Make the model and color fields private and the year field public. How can we provide access for private fields?
//through get set method
public class java2 {
  public static void main(String[] args){
      Car car1=new Car();
      car1.year=2020;
      car1.setmodel("Fortuner");
      car1.setcolor("White");
      System.out.println("Car   "+ car1.year+"    "+ car1.getmodel()+"    "+ car1.getcolor());
  }
}

class Car{

  private String model,color;
  public int year;
  public void setmodel(String model){
    this.model=model;
  }
  public void setcolor(String color){
    this.color=color;
  }
  public String getmodel(){
    return model;
  }
  public String getcolor(){
    return color;
  }

}
