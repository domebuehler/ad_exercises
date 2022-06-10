package ch.hslu.ad.sw05.exercise.n1.joinAndSleep;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class DemoJoinAndSleep {

    private static final Logger LOG = LogManager.getLogger(DemoJoinAndSleep.class);

    public static void main(String[] args) throws InterruptedException {
        JoinAndSleep thread3 = new JoinAndSleep(null,4000,  "thread 3");
        JoinAndSleep thread2 = new JoinAndSleep(thread3, 3000, "thread 2");
        JoinAndSleep thread1 = new JoinAndSleep(thread2, 2000, "thead 1");

        thread3.start();
        thread2.start();
        thread1.start();

        Thread.sleep(2000);
        thread3.stop();

        thread1.join();
        LOG.info("demo terminated");
    }
}
