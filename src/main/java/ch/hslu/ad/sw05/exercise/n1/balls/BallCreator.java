package ch.hslu.ad.sw05.exercise.n1.balls;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public class BallCreator {

    private static final Logger LOG = LogManager.getLogger(BallCreator.class);

    private static final int NUMBER_OF_BALLS = 100;

    public static void main(String[] args) throws InterruptedException {
        Canvas canvas = Canvas.getCanvas();
        List<Thread> threads = new LinkedList<>();

        for (int i = 0; i < NUMBER_OF_BALLS; i++) {
            threads.add(new Thread(new Ball()));
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        LOG.info("ball demo finished");
        System.exit(0);
    }
}
