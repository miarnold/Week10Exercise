package edu.matc.week10Exercise;


public class RileyWatchesTv {

    public void startThreads() {
        {
            System.out.println("Created a new RileyWatchesTv . . . about to start some threads");
            HalloweenNight halloweenNight = new HalloweenNight();

            Riley riley = new Riley(halloweenNight);
            CandyBeggarCreator candyBeggarCreator = new CandyBeggarCreator(halloweenNight);

            Thread threadRiley = new Thread(riley);
            Thread threadCandyBeggarCreator = new Thread(candyBeggarCreator);
            threadCandyBeggarCreator.start();
            System.out.println("RileyWatchesTv class has called for a new CandyBeggarThread.");
            threadRiley.start();
            System.out.println("RileyWatchesTv class has called for a new RileyThread.");
        }
    }
}