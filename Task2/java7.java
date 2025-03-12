//7. Create a HashSet to store a collection of unique strings. 
//Perform operations to add new strings, check if a string exists and remove a string from the set. 
// How does HashSet handle null values? How can we get lexicographically smallest and largest strings using Set?

import java.util.*;
public class java7 {
  public static void main(String[] args) {
    Set<String> countries=new HashSet<>();
    countries.add("India");
    countries.add("USA");
    countries.add("Japan");
    countries.add("Germany");
    countries.add("Canada");
    countries.add("Australia");
    countries.add("France");
    countries.add("Brazil");
    countries.add("Russia");
    countries.add("China");
    countries.add("United Kingdom");
    countries.add("Italy");
    countries.add("Japan");
    countries.add("Germany");
    countries.add(null);
    System.out.println("Countries"+countries);
    HashSet<String> countries1=new HashSet<>();
    countries1.add("India");
    countries1.add("USA");
    countries1.add("Japan");
    countries1.add("Iran");
    System.out.println("Is element removed "+countries.removeAll(countries1));
    System.out.println("Countries"+countries);
    countries.remove(null);//TreeSet does not allow null
    SortedSet<String> sortcountry=new TreeSet<>(countries);
    Iterator<String> item=sortcountry.iterator();
    System.out.println("Sorted Country");
    while(item.hasNext()){
      System.out.println(item.next());
    }
  }
}
