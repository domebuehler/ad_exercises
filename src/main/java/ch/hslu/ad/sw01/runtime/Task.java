package ch.hslu.ad.sw01.runtime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Task {

    private static final Logger LOG = LogManager.getLogger(Task.class);

    private int executionsTask1 = 0;
    private int executionsTask2 = 0;
    private int executionsTask3 = 0;
    private final List<RuntimeDataStorage> dataStorageList = new ArrayList<>();

    public void createRunTimeStatistic(final int... ints) {
        for (int i : ints) {
            task(i);
        }
        printStats();
    }

    public void task(final int n) {
        executionsTask1 = 0;
        executionsTask2 = 0;
        executionsTask3 = 0;
        task1();
        task1();
        task1();
        task1();
        for (int i = 0; i < n; i++) {
            task2();
            task2();
            task2();
            for (int j = 0; j < n; j++) {
                task3();
                task3();
            }
        }
        this.dataStorageList.add(new RuntimeDataStorage(n, this.executionsTask1, this.executionsTask2, this.executionsTask3));
    }

    private void printStats() {
        for (RuntimeDataStorage dataStorage : this.dataStorageList) {
            LOG.info(dataStorage);
        }
    }

    private void task1() {
        executionsTask1++;
    }

    private void task2() {
        executionsTask2++;
    }

    private void task3() {
        executionsTask3++;
    }
}
