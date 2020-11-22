package lesson1;

import java.util.Random;

public class Activity13 {
    public static void main(String[] args) {
        CreateRandomYear createRandomYear = new CreateRandomYear();
        Thread checkLeapYear = new Thread() {
            @Override
            public void run() {
                while (true) {
                    int currentYear = createRandomYear.randomYear;
                    if (currentYear % 4 == 0)
                        System.out.println(currentYear + " is a leap year");
                    else
                        System.out.println(currentYear + " is not a leap year");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        createRandomYear.start();
        checkLeapYear.start();
    }
}

class CreateRandomYear extends Thread {
    Random randomInt = new Random(9999);
    public int randomYear = 1;

    @Override
    public void run() {
        while (true) {
            randomYear = 1 + randomInt.nextInt(9999);
            try {
                Thread.sleep(2000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

