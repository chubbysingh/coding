package Leetcode;

public class Q509_Fibonacci_Number {
    public int fib(int N) {
        if (N <= 1) {
            return N;
        }
        if (N == 2) {
            return 1;
        }

        int current = 0;
        int prev1 = 1;
        int prev2 = 1;

        for (int i = 3; i <= N; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return current;
    }

    public static void main(String[] args) {
        Q509_Fibonacci_Number sol = new Q509_Fibonacci_Number();

        long result = sol.fib(12);
        System.out.println(result);
    }
}
