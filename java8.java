
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

//8. Implement a Node class to represent nodes of a Linked List.
//  After forming a linked list using an ArrayList of integers, implement a method to reverse a linked list using a Stack.


public class java8 {
  public static void main(String[] args) {
      LinkedList<Integer> l1=new LinkedList<>();
      l1.add(1);
      l1.add(2);
      l1.add(3);
      l1.add(4);
      l1.add(5);
      l1.add(6);
      System.out.println(l1);
      Stack<Integer> s=new Stack<>();
      Iterator<Integer> item=l1.iterator();
      while(item.hasNext()){
        s.push(item.next());
      }
      int i=0;
      while(!s.isEmpty()){
         l1.set(i,s.peek());
         i++;
         s.pop();
      }
      System.out.println("After stack Reverseing"+l1);
      
  }
}
