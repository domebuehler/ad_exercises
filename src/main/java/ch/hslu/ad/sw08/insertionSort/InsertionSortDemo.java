package ch.hslu.ad.sw08.insertionSort;

import ch.hslu.ad.sw08.testData.ArrayCreator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class InsertionSortDemo {

    private static final Logger LOG = LogManager.getLogger(InsertionSortDemo.class);

    private static int SIZE = 100_000;

    public static void main(String[] args) {
        int[] randomIntArray = ArrayCreator.newRandomIntArray(SIZE);
        int[] sortedIntArray = ArrayCreator.newSortedIntArray(SIZE);
        int[] reverseSortedIntArray = ArrayCreator.newReverseSortedIntArray(SIZE);

        long start = System.currentTimeMillis();
        Sort.insertionSort(randomIntArray);
        long duration = System.currentTimeMillis() - start;
        LOG.info("average case:\tsorted {} random elements in {} ms", SIZE, duration);

        start = System.currentTimeMillis();
        Sort.insertionSort(sortedIntArray);
        duration = System.currentTimeMillis() - start;
        LOG.info("best case:\tsorted {} sorted elements in {} ms", SIZE, duration);

        start = System.currentTimeMillis();
        Sort.insertionSort(reverseSortedIntArray);
        duration = System.currentTimeMillis() - start;
        LOG.info("worst case:\tsorted {} reverse sorted elements in {} ms", SIZE, duration);
    }
}
