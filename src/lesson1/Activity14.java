package lesson1;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Activity14 {
    private  Map<String, String> dayOfWeek = new HashMap<>();
     private String thisDay;
    Random random = new Random(9999);
    public static void main(String[] args) {
        Activity14 activity14 = new Activity14();


        activity14.dayOfWeek.put("Monday","Thứ 2");
        activity14.dayOfWeek.put("Tuesday","Thứ 3");
        activity14.dayOfWeek.put("Wednesday","Thứ 4");
        activity14.dayOfWeek.put("Thursday","Thứ 5");
        activity14.dayOfWeek.put("Friday","Thứ 6");
        activity14.dayOfWeek.put("Saturday","Thứ 7");
        activity14.dayOfWeek.put("Sunday","Chủ Nhật");
        Thread getEnglishDay = new Thread(){
            @Override
            public void run()
            {
                while(true)
                {
                   // System.out.println(activity14.thisDay);
                System.out.println(activity14.day());
                try{
                Thread.sleep(2000);}
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                }
            }
        };
        Thread getVietnameseDay = new Thread(){
            @Override
            public void run()
            {
                while (true) {
                    System.out.println(activity14.dayOfWeek.get(activity14.day()));
                    activity14.setThisDay(null);
                    try {
                        Thread.sleep(2000);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        };
        getEnglishDay.start();
        getVietnameseDay.start();
    }

    public void setThisDay(String thisDay) {
        this.thisDay = thisDay;
    }

    private synchronized String day() {
        if(thisDay == null)
        {
        int i = random.nextInt(7);
        for(String day : dayOfWeek.keySet())
        {
           // System.out.println(i);
            thisDay =day;
            if(i<=0) break;
            i--;
        }
        }
        return thisDay;
    }


}
