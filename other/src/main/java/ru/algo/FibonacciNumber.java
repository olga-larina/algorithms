package ru.algo;

/**
 * 509. Fibonacci Number
 *
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each
 * number is the sum of the two preceding ones, starting from 0 and 1. That is,
 * F(0) = 0, F(1) = 1
 * F(n) = F(n - 1) + F(n - 2), for n > 1.
 * Given n, calculate F(n).
 *
 * https://leetcode.com/problems/fibonacci-number/
 */
public class FibonacciNumber {
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int n1 = 0;
        int n2 = 1;
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = n1 + n2;
            n1 = n2;
            n2 = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        FibonacciNumber fibonacciNumber = new FibonacciNumber();
        System.out.println(fibonacciNumber.fib(2));
        System.out.println(fibonacciNumber.fib(3));
        System.out.println(fibonacciNumber.fib(4));
    }
}
