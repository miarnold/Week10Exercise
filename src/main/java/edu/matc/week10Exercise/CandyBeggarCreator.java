package edu.matc.week10Exercise;

import java.util.Date;
import java.util.concurrent.TimeUnit;


class CandyBeggarCreator implements Runnable {
    private HalloweenNight halloweenNight;

    CandyBeggarCreator(HalloweenNight halloweenNight)
    {
        this.halloweenNight = halloweenNight;
    }

    public void run()
    {
        System.out.println("Starting the thread in CandyBeggarCreator.");
        while(true)
        {
            System.out.println("thread in 'while true' of CandyBeggarCreator.");
            CandyBeggar candyBeggar = new CandyBeggar(halloweenNight);
            candyBeggar.setInTime(new Date());
            System.out.print("will it continue");
System.out.println("code reaches here.");
            Thread threadCandyBeggar = new Thread(candyBeggar);
            //System.out.print(threadCandyBeggar);
System.out.println("code won't get here.");
            candyBeggar.setName("CandyBeggar Thread "+threadCandyBeggar.getId());
            threadCandyBeggar.start();


            try
            {
                TimeUnit.SECONDS.sleep((long)3000);
            }
            catch(InterruptedException iex)
            {
                iex.printStackTrace();
            }
        }
    }

}