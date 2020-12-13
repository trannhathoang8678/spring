package lesson1.activity16;

import java.util.LinkedList;
import java.util.Queue;

public class Prime {
    private Queue<Integer> numbers = new LinkedList<>();
    private LinkedList<Integer> primeList = new LinkedList<>();
    private int result = 0, maxDivisors = 0;
    private static Prime prime = new Prime();

    private Prime() {
    }


    public static Prime getPrime() {
        return prime;
    }

    public void addNumber(int amountNumbers) {
        for (int i = 2; i <= amountNumbers; i++)
            numbers.add(i);
    }

    public void createPrimeList(int amountNumbers) {
        primeList = new LinkedList<Integer>();
        boolean[] isPrime = new boolean[1000100];
        for (int i = 2; i <= 1000000; i++)
            isPrime[i] = true;
        for (int i = 2; i <= 1000000; i++)
            if (isPrime[i]) {
                primeList.add(i);
                for (int j = i * 2; j <= 1000000; j += i)
                    isPrime[i] = false;
            }
    }

    public void updateResult(int number) {
        if (number == -1) return;
        int presentResult = number;
        int numberDivisors = 1;
        for (int prime : primeList) {
            if (prime > number) break;
            int exponent = 1;
            while (number % prime == 0) {
                number /= prime;
                exponent++;
            }
            numberDivisors *= exponent;
        }
        if (numberDivisors > maxDivisors) {
            maxDivisors = numberDivisors;
            result = presentResult;
        }
    }

    public synchronized int getNumber() {
        try {
            int number = numbers.element();
            numbers.remove();
            return number;

        } catch (Exception e) {
            return -1;
        }

    }

    public void printResult() {
        if (result != 0) {
            System.out.println(result + " " + maxDivisors);
            result = 0;
        }
    }

    public int getResult() {
        return result;
    }

    public int getMaxDivisors() {
        return maxDivisors;
    }
}

