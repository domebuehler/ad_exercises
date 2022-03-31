package ch.hslu.ad.sw05.exercise.n1.addition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class AdditionTask implements Runnable {

    private Thread runThread;
    private int rangeBegin;
    private int rangeEnd;
    private String threadName;

    private static final Logger LOG = LogManager.getLogger(AdditionTask.class);

    public AdditionTask(int rangeBegin, int rangeEnd, String threadName) {
        this.rangeBegin = rangeBegin;
        this.rangeEnd = rangeEnd;
        this.threadName = threadName;
    }

    public void stopAdditionTask() {
        if (this.runThread != null) {
            this.runThread.interrupt();
        }
    }

    public void startAdditionTask() {
        this.runThread = new Thread(this, this.threadName);
        this.runThread.start();
    }

    @Override
    public void run() {
        long sum = 0;
        int iter = this.rangeBegin;
        while (!this.runThread.isInterrupted() && iter <= this.rangeEnd) {
            sum += iter;
            iter++;
            sleep(1);
        }
        logThread(sum);
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            this.runThread.interrupt();
            LOG.info("{} interrupted while sleeping", this.runThread.getName());
        }
    }

    private void logThread(long sum) {
        if (!isStopped()) {
            LOG.info(runThread.getName() + ": SUM from {} to {} -> " + sum, this.rangeBegin, this.rangeEnd);
        } else {
            LOG.info(runThread.getName() + ": interrupted.");
        }
    }

    private boolean isStopped() {
        return this.runThread.isInterrupted();
    }
}
