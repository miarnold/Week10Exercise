package edu.matc.week10Exercise;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

class HalloweenNight {
    private int placeInLine;
    private List<CandyBeggar> listOfCandyBeggars;

    public HalloweenNight() {
        placeInLine = 10;
        listOfCandyBeggars = new LinkedList<CandyBeggar>();
        System.out.println("Created a Halloween Night with " + placeInLine + " places in line available.");
    }

    public void giveCandy() {
        CandyBeggar candyBeggar;
        System.out.println("Riley waiting for lock.");
        synchronized (listOfCandyBeggars) {

            while (listOfCandyBeggars.size() == 0) {
                System.out.println("Riley is waiting for candyBeggar.");
                try {
                    listOfCandyBeggars.wait();
                } catch (InterruptedException iex) {
                    iex.printStackTrace();
                }
            }
            System.out.println("Riley found a candyBeggar in line.");
            candyBeggar = (CandyBeggar) ((LinkedList<?>) listOfCandyBeggars).poll();
        }
        long duration = 0;
        try {
            System.out.println("Giving candy to  : " + candyBeggar.getName());
            duration = (long) (Math.random() * 10);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException iex) {
            iex.printStackTrace();
        }
        System.out.println("Completed candy delivery for : " + candyBeggar.getName() + " in " + duration + " seconds.");
    }

    public void add(CandyBeggar candyBeggar) {
        System.out.println("CandyBeggar : " + candyBeggar.getName() + " entering the halloweenNight at " + candyBeggar.getInTime());

        synchronized (listOfCandyBeggars) {
            if (listOfCandyBeggars.size() == placeInLine) {
                System.out.println("No more room for Kids to trick or Treat " + candyBeggar.getName());
                System.out.println("Child " + candyBeggar.getName() + "Exists...");
                return;
            }

            ((LinkedList<CandyBeggar>) listOfCandyBeggars).offer(candyBeggar);
            System.out.println("child : " + candyBeggar.getName() + " got the candy.");

            if (listOfCandyBeggars.size() == 1)
                listOfCandyBeggars.notify();
        }
    }
}