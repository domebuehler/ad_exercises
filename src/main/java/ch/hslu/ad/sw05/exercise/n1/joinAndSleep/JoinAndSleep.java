package ch.hslu.ad.sw05.exercise.n1.joinAndSleep;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class JoinAndSleep implements Runnable {

    private JoinAndSleep waitingFor;
    private Thread runThread;
    private int waitingTime;
    private String name;

    private static final Logger LOG = LogManager.getLogger(JoinAndSleep.class);

    public JoinAndSleep(JoinAndSleep waitingFor, int waitingTime, String name) {
        this.waitingFor = waitingFor;
        this.waitingTime = waitingTime;
        this.name = name;
    }

    public void start() {
        this.runThread = new Thread(this, this.name);
        this.runThread.start();
    }

    public void stop() {
        this.runThread.interrupt();
    }

    public void join() {
        try {
            this.runThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        if (this.waitingFor != null) {
            this.getWaitingFor().join();
        }
        sleep();
        long end = System.currentTimeMillis();
        LOG.info("{} finished after {} ms", this, end - start);
    }

    private void sleep() {
        try {
            Thread.sleep(this.waitingTime);
        } catch (InterruptedException e) {
            LOG.info("{} interrupted while sleeping", this);
        }
    }

    @Override
    public String toString() {
        return "JoinAndSleep{" +
                "name='" + name + '\'' +
                '}';
    }

    public JoinAndSleep getWaitingFor() {
        return waitingFor;
    }
}
