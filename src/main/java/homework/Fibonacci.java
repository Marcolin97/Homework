package homework;

public class Fibonacci {

    public static void main(String[] args) {
        printFibonacci(20);
    }

    public static void printFibonacci(int n) {
        int first = 0, second = 1;
        for (int i = 0; i < n; i++) {
            int next = first + second;
            first = second;
            second = next;
            System.out.print(first + " ");
        }
    }
}