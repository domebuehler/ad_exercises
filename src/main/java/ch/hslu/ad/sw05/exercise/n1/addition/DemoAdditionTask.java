package ch.hslu.ad.sw05.exercise.n1.addition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class DemoAdditionTask {

    private static final Logger LOG = LogManager.getLogger(DemoAdditionTask.class);

    public static void main(String[] args) throws InterruptedException {
        AdditionTask task1 = new AdditionTask(1, 1_00, "thread 1");
        AdditionTask task2 = new AdditionTask(10, 1_000, "thread 2");
        AdditionTask task3 = new AdditionTask(100, 10_000, "thread 3");

        task1.startAdditionTask();
        task2.startAdditionTask();
        task3.startAdditionTask();

        long start = System.currentTimeMillis();
        Thread.sleep(10000);
        long end = System.currentTimeMillis();
        LOG.info("main-thread waited for {} ms", end - start);

        task1.stopAdditionTask();
        task2.stopAdditionTask();
        task3.stopAdditionTask();
    }
}
