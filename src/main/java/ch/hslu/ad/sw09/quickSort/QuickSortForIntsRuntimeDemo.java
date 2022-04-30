package ch.hslu.ad.sw09.quickSort;

import ch.hslu.ad.sw09.testData.ArrayCreator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class QuickSortForIntsRuntimeDemo {

    private static final int SIZE = 1_000_000;
    private static final int ITER = 10;
    private static final int FACTOR = 2;
    private static final ArrayCreator arrayCreator = new ArrayCreator();
    private static final double NANO_DIVIDEND = 1_000_000;
    private static double[] runtimes = new double[ITER * 2];

    private static long start;
    private static double durationInMilliseconds;
    private static double averageRuntimeSingle;
    private static double averageRuntimeDouble;


    private static final Logger LOG = LogManager.getLogger(QuickSortForCharsRuntimeDemo.class);

    public static void main(String[] args) {
        LOG.info("--- Quicksort: Size = {}\tIter = {} ---", SIZE, ITER);
        executeQuickSortRuns();
        LOG.info("--- Quicksort: Size = {}\tIter = {} ---", SIZE * FACTOR, ITER);
        executeQuickSortRunsWithDoubledArray();
        LOG.info("--- Compare runtimes ---");
        compareRuntimes();
    }

    private static void executeQuickSortRuns() {
        arrayCreator.createNewMasterIntArray(SIZE);
        for (int i = 0; i < ITER; i++) {
            start = System.nanoTime();
            QuickSort.quickSortForInts(arrayCreator.getMasterIntArray());
            durationInMilliseconds = (System.nanoTime() - start) / NANO_DIVIDEND;
            runtimes[i] = durationInMilliseconds;
            LOG.info("{}. run: {} ms", i, durationInMilliseconds);
        }
        calculateAverageRuntime();
    }

    private static void calculateAverageRuntime() {
        averageRuntimeSingle = 0d;
        for (double runtime : runtimes) {
            averageRuntimeSingle += runtime;
        }
        averageRuntimeSingle /= ITER;
        LOG.info("average over all runs: {} ms", averageRuntimeSingle);
    }

    private static void executeQuickSortRunsWithDoubledArray() {
        arrayCreator.createNewMasterIntArray(SIZE * FACTOR);
        for (int i = 0; i < ITER; i++) {
            start = System.nanoTime();
            QuickSort.quickSortForInts(arrayCreator.getMasterIntArray());
            durationInMilliseconds = (System.nanoTime() - start) / NANO_DIVIDEND;
            runtimes[ITER + i] = durationInMilliseconds;
            LOG.info("{}. run: {} ms", i, durationInMilliseconds);
        }
        calculateAverageRuntimeDouble();
    }

    private static void calculateAverageRuntimeDouble() {
        averageRuntimeDouble = 0d;
        for (int i = ITER; i < ITER * FACTOR; i++) {
            averageRuntimeDouble += runtimes[i];
        }
        averageRuntimeDouble /= ITER;
        LOG.info("average over all runs: {} ms", averageRuntimeDouble);
    }

    private static void compareRuntimes() {
        LOG.info("runtime for n = {}: {} ms", SIZE, averageRuntimeSingle);
        LOG.info("runtime for n = {}: {} ms", SIZE * FACTOR, averageRuntimeDouble);
        LOG.info("expected O(log(n) * n): {}\tactual: {}", Math.log(FACTOR) * FACTOR,
                averageRuntimeDouble / averageRuntimeSingle);
    }
}
