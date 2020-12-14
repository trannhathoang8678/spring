package lesson1.activity16;



public class Activity16 {


    public static void main(String[] args) {
        Prime.getPrime().createPrimeList(200000);
        Prime.getPrime().addNumber(200000);
        ThreadCal threadCal1 = new ThreadCal();
        ThreadCal threadCal2 = new ThreadCal();

        threadCal1.start();
     //   threadCal2.start();

    }
}

class ThreadCal extends Thread {
    @Override
    public void run() {
        long currentTime = System.currentTimeMillis();
        while (true) {
            Pair result= Prime.getPrime().getNumberAndCal();
            if(!Prime.getPrime().updateResult(result.first,result.second))
                break;
        }
        Prime.getPrime().printResult();
        System.out.println(System.currentTimeMillis() - currentTime);
    }
}
