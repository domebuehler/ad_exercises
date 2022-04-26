package ch.hslu.ad.sw08.selectionSort;

import ch.hslu.ad.sw08.testData.ArrayCreator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class SelectionSortDemo {

    private static final Logger LOG = LogManager.getLogger(SelectionSortDemo.class);

    private static final int SIZE = 100_000;

    public static void main(String[] args) {
        int[] worst = ArrayCreator.newReverseSortedIntArray(SIZE);
        int[] best = ArrayCreator.newSortedIntArray(SIZE);

        long start = System.currentTimeMillis();
        Sort.selectionSort(worst);
        long duration = System.currentTimeMillis() - start;
        LOG.info("\"worst case\":\t sorted {} elements in {} ms", SIZE, duration);

        start = System.currentTimeMillis();
        Sort.selectionSort(best);
        duration = System.currentTimeMillis() - start;
        LOG.info("\"best case\":\t sorted {} elements in {} ms", SIZE, duration);
    }
}
