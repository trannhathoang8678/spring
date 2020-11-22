package lesson1;

public class Activity11 {
    public static void main(String[] args) {
        for (int i = 1; i <= 50; i++) {
            showThreadID showThreadID1 = new showThreadID();
            showThreadID1.start();
        }
    }
}

class showThreadID extends Thread {
    @Override
    public void run() {
        System.out.println(getId());
        while (true)
            System.out.println(getId());
    }
}