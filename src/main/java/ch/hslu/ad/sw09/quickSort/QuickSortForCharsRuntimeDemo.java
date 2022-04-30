package ch.hslu.ad.sw09.quickSort;

import ch.hslu.ad.sw09.testData.ArrayCreator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class QuickSortForCharsRuntimeDemo {

    private static ArrayCreator arrayCreator = new ArrayCreator();
    private static final int SIZE = 500_000;
    private static final int ITER = 10;
    private static final double NANO_DIVIDEND = 1_000_000;
    private static double[] runtimes = new double[ITER * 2];

    private static long start;
    private static double durationInMilliseconds;
    private static double averageRuntime;

    private static final Logger LOG = LogManager.getLogger(QuickSortForCharsRuntimeDemo.class);

    public static void main(String[] args) {
        arrayCreator.createNewMasterCharArray(SIZE);
        LOG.info("--- Quicksort: Size = {}\tIter = {} ---", SIZE, ITER);
        executeNormalQuickSortRuns();
        calculateAverageForNormalQuickSortRuns();
        LOG.info("--- Quicksort with exchanging equals to: Size = {}\tIter = {} ---", SIZE, ITER);
        executeExchangingEqualsQuickSortRuns();
        calculateAverageForExchangingEqualsQuickSortRuns();
    }

    private static void executeNormalQuickSortRuns() {
        for (int i = 0; i < ITER; i++) {
            start = System.nanoTime();
            QuickSort.quickSortForChars(arrayCreator.getMasterCharArray());
            durationInMilliseconds = (System.nanoTime() - start) / NANO_DIVIDEND;
            LOG.info("{}. run: {} ms", i + 1, durationInMilliseconds);
            runtimes[i] = durationInMilliseconds;
        }
    }

    private static void calculateAverageForNormalQuickSortRuns() {
        averageRuntime = 0d;
        for (double runtime : runtimes) {
            averageRuntime += runtime;
        }
        averageRuntime /= ITER;
        LOG.info("average over all runs: {} ms", averageRuntime);
    }

    private static void executeExchangingEqualsQuickSortRuns() {
        for (int i = 0; i < ITER; i++) {
            start = System.nanoTime();
            QuickSort.quickSortForCharsExchangingEqualsTo(arrayCreator.getMasterCharArray());
            durationInMilliseconds = (System.nanoTime() - start) / NANO_DIVIDEND;
            LOG.info("{}. run: {} ms", i + 1, durationInMilliseconds);
            runtimes[ITER + i] = durationInMilliseconds;
        }
    }

    private static void calculateAverageForExchangingEqualsQuickSortRuns() {
        averageRuntime = 0d;
        for (int i = ITER; i < ITER * 2; i++) {
            averageRuntime += runtimes[i];
        }
        averageRuntime /= ITER;
        LOG.info("average over all runs: {} ms", averageRuntime);
    }
}
