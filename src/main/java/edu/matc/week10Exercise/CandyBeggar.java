package edu.matc.week10Exercise;
import java.util.Date;

class CandyBeggar implements Runnable
{
    private String name;
    private Date inTime;

    private HalloweenNight halloweenNight;

    public CandyBeggar(HalloweenNight halloweenNight)
    {
        System.out.println("Created a new candyBeggar");
        this.halloweenNight = halloweenNight;
    }

    public String getName() {
        return name;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInTime(Date inTime) {

        this.inTime = inTime;
        System.out.println("A inTime is set for a CandyBeggar.");
    }

    public void run()
    {
        goForCandy();
    }
    private synchronized void goForCandy()
    {
        halloweenNight.add(this);
    }
}