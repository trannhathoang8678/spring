package lesson1.activity16;

import java.util.LinkedList;

public class Activity16 {


    public static void main(String[] args) {
        Prime.getPrime().createPrimeList(200000);
        Prime.getPrime().addNumber(200000);
        ThreadCal threadCal1 = new ThreadCal();
        ThreadCal threadCal2 = new ThreadCal();

        threadCal1.start();
        threadCal2.start();

    }
}

class ThreadCal extends Thread {
    @Override
    public void run() {
        long currentTime = System.currentTimeMillis();
        while (true) {
            int number = Prime.getPrime().getNumber();
            if (number == -1) break;
            Prime.getPrime().updateResult(number);
        }
        Prime.getPrime().printResult();
        System.out.println(System.currentTimeMillis() - currentTime);
    }
}
