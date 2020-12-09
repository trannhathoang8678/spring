package lesson1;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.List;

public class Activity16 {
    public LinkedList<Integer> primeList;
    public int result = 0, maxNumberOfDivisors = 0;

    public void createPrimeList() {
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

    public int numberOfDivisors(int number) {
        int numberDivisors = 1;
        for (int prime : primeList) {
            if (prime > number) break;
            int exponent = 1;
            while (number % prime == 0) {
                number /= prime;
                exponent++;
           //     System.out.println(exponent + " " + number + " " + prime);
                //System.out.println(prime);
            }
            numberDivisors *= exponent;
        }
        return numberDivisors;
    }

    public static void main(String[] args) {
        Activity16 activity16 = new Activity16();
        activity16.createPrimeList();
        long timeForSingleThread = System.currentTimeMillis();
        for (int i = 2; i <= 1000000; i++) {
            int numberDivisors = activity16.numberOfDivisors(i);
            if (activity16.maxNumberOfDivisors < numberDivisors) {
                activity16.result = i;
                activity16.maxNumberOfDivisors = numberDivisors;
            }
        }

        timeForSingleThread -= System.currentTimeMillis();
        timeForSingleThread = -timeForSingleThread;

        System.out.println(activity16.result);
        System.out.println("Time for single thread: " + timeForSingleThread);
        ThreadCal thread1 = new ThreadCal(activity16, 2, 50000);
        ThreadCal thread2 = new ThreadCal(activity16, 500001, 1000000);
        long timeForDoubleThread = System.currentTimeMillis();
        thread1.start();
        thread2.start();
        if(thread1.getMaxNumberOfDivisors()>thread2.getMaxNumberOfDivisors())
        {
            System.out.println(thread1.getResult());
        }
        else
        {
            System.out.println(thread2.getResult());
        }
        timeForDoubleThread -= System.currentTimeMillis();
        timeForDoubleThread = -timeForDoubleThread;
        System.out.println("Time for double thread: " + timeForDoubleThread);
    }
}

class ThreadCal extends Thread {
    Activity16 activity16;
    int start, end;

    public ThreadCal(Activity16 activity16, int start, int end) {
        this.activity16 = activity16;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            int numberDivisors = activity16.numberOfDivisors(i);
            if (activity16.maxNumberOfDivisors < numberDivisors) {
                activity16.result = i;
                activity16.maxNumberOfDivisors = numberDivisors;
            }
        }
    }

    public int getMaxNumberOfDivisors() {
        return activity16.maxNumberOfDivisors;
    }
    public int getResult() {
        return activity16.result;
    }
}
