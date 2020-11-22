package lesson1;

public class Activity12 {
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread("ABC",3500);
        MyThread myThread2 = new MyThread("DEF",2500);
        myThread1.start();

        myThread2.start();
    }
}

class MyThread extends Thread {
    String note;
    int timeSleep;
    public MyThread(String note,int timeSleep)
    {
        this.note =note;
        this.timeSleep=timeSleep;
    }
    @Override
    public void run() {
        while (true) {
            System.out.println(note);
            try {
                Thread.sleep(timeSleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
