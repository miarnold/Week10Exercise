package edu.matc.week10Exercise;


class Riley implements Runnable {
    private HalloweenNight halloweenNight;

    public Riley(HalloweenNight halloweenNight)
    {
        this.halloweenNight = halloweenNight;
        System.out.println("Created a Riley.");
    }
    public void run() {
        System.out.println("about to run a thread in Riley");
        try
        {
            Thread.sleep(10000);
        }
        catch(InterruptedException iex)
        {
            iex.printStackTrace();
        }
        System.out.println("Riley started . . . ");
        while(true)
        {
            halloweenNight.giveCandy();
        }
    }
}