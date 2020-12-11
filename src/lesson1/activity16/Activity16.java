package lesson1.activity16;

import java.util.LinkedList;

public class Activity16 {


    public static void main(String[] args) {
        Prime.getPrime().createPrimeList(500000);
        Prime.getPrime().addNumber(500000);
        ThreadCal threadCal1 = new ThreadCal();
        ThreadCal threadCal2 = new ThreadCal();

        threadCal1.start();
      //  threadCal2.start();

    }
}

class ThreadCal extends Thread {
    @Override
    public void run() {
        long currentTime = System.currentTimeMillis();
    while(Prime.getPrime().calResult())
    {
    }
    Prime.getPrime().printResult();
        System.out.println(System.currentTimeMillis()-currentTime);
    }
}
