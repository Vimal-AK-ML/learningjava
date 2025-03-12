//4. Create a class of your choice. Write a program to create an object using this class, set its fields and print the object's details.
// Explore static and final keywords.

public class Main4 {

  public static void main(String[] args) {
    Car car = new Car("Toyota", "Innova", 2022);
    car.displayDetails();
    Car car1 = new Car("Toyota", "Fortuner", 2022);
    car1.displayDetails();
  }
}
class Car {
  String brand;
  String model;
  int year;

  
  static int totalCars = 0;

  final int wheels = 4;

  // Constructor to initialize object
  public Car(String brand, String model, int year) {
      this.brand = brand;
      this.model = model;
      this.year = year;
      totalCars++; 
  }

  public void displayDetails() {
      System.out.println("----------------------------------");
      System.out.println("Brand: " + brand);
      System.out.println("Model: " + model);
      System.out.println("Year: " + year);
      System.out.println("Wheels: " + wheels); 
      System.out.println("Total Cars Created: " + totalCars);
      System.out.println("----------------------------------");
  }
}

