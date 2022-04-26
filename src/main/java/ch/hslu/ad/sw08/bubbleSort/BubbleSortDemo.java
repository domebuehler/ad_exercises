package ch.hslu.ad.sw08.bubbleSort;

import ch.hslu.ad.sw08.testData.ArrayCreator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class BubbleSortDemo {
    private static final Logger LOG = LogManager.getLogger(BubbleSortDemo.class);
    private static final int SIZE = 10_000;

    public static void main(String[] args) {
        int[] randomIntArray = ArrayCreator.newRandomIntArray(SIZE);
        int[] reverseSortedIntArray = ArrayCreator.newReverseSortedIntArray(SIZE);
        int[] sortedIntArray = ArrayCreator.newSortedIntArray(SIZE);

        long start = System.currentTimeMillis();
        Sort.bubbleSort(randomIntArray);
        long duration = System.currentTimeMillis() - start;
        LOG.info("random array: sorted {} elements in {} ms", SIZE, duration);

        start = System.currentTimeMillis();
        Sort.bubbleSort(reverseSortedIntArray);
        duration = System.currentTimeMillis() - start;
        LOG.info("reversed array: sorted {} elements in {} ms", SIZE, duration);

        start = System.currentTimeMillis();
        Sort.bubbleSort(sortedIntArray);
        duration = System.currentTimeMillis() - start;
        LOG.info("sorted array: sorted {} elements in {} ms", SIZE, duration);
    }
}
