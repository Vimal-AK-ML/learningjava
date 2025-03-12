//3. Write a Java program to get the first n even numbers using a for loop. What's the role of while and do-while?

import java.util.Scanner;
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter the number of even numbers to display: ");
        int n = scanner.nextInt();

        System.out.println("First " + n + " even numbers:");

        for (int i = 1; i <= n; i++) {
            System.out.print((2 * i) + " ");
        }

        scanner.close();
    }
}


