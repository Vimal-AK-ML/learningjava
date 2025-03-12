//6. Write a program that creates a HashMap to store country names and their capitals. 
// Iterate over the countries and prints them along with their capitals. 
// How can we have a sorted order of countries in a Map?
import java.util.*;

public class java6 {
  public static void main(String[] args) {
    HashMap<String, String> country=new HashMap<>();
    country.put("India", "New Delhi");
    country.put("USA", "Washington, D.C.");
    country.put("Japan", "Tokyo");
    country.put("Germany", "Berlin");
    country.put("France", "Paris");
    for(Map.Entry<String, String> item:country.entrySet()){
    System.out.println("Country   "+item.getKey()+"   "+"Capital   "+item.getValue());
    } 
    SortedMap<String, String> sortcountry=new TreeMap<>(country);
    System.out.println("Sorted Order");

    for(Map.Entry<String, String> item:sortcountry.entrySet()){
      System.out.println("Country   "+item.getKey()+"   "+"Capital   "+item.getValue());
      }
  }

  
}
