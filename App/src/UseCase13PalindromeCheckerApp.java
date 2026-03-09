import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

public class UseCase13PalindromeCheckerApp {

    // Method 1: Using String Reversal
    public static boolean isPalindromeReverse(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }

    // Method 2: Using Stack
    public static boolean isPalindromeStack(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            stack.push(c);
        }

        for (char c : str.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    // Method 3: Using Deque
    public static boolean isPalindromeDeque(String str) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : str.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String input = "madam";

        // Reverse Method Timing
        long start1 = System.nanoTime();
        boolean result1 = isPalindromeReverse(input);
        long end1 = System.nanoTime();

        // Stack Method Timing
        long start2 = System.nanoTime();
        boolean result2 = isPalindromeStack(input);
        long end2 = System.nanoTime();

        // Deque Method Timing
        long start3 = System.nanoTime();
        boolean result3 = isPalindromeDeque(input);
        long end3 = System.nanoTime();

        System.out.println("Input String: " + input);

        System.out.println("\nReverse Method Result: " + result1);
        System.out.println("Execution Time: " + (end1 - start1) + " ns");

        System.out.println("\nStack Method Result: " + result2);
        System.out.println("Execution Time: " + (end2 - start2) + " ns");

        System.out.println("\nDeque Method Result: " + result3);
        System.out.println("Execution Time: " + (end3 - start3) + " ns");
    }
}