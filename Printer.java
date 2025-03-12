//4. Implement a generic class Printer with a method printCollection. 
//The class has a generic type parameter <T>.  
//Implement a method printCollection that takes a Collection<T> as an argument and prints each element in the collection (like List, Set, Queue).
import java.util.Collection;

public class Printer<T> {
    
    // Method to print all elements in the collection
    public void printCollection(Collection<T> collection) {
        for (T item : collection) {
            System.out.println(item);
        }
    }
    
    public static void main(String[] args) {
        // Example usage with a List
        Printer<String> stringPrinter = new Printer<>();
        Collection<String> stringList = java.util.Arrays.asList("Hello", "World", "Generic", "Printer");
        stringPrinter.printCollection(stringList);

    }
}
