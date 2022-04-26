package ch.hslu.ad.sw08.bubbleSort;

import ch.hslu.ad.sw08.testData.ArrayCreator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class BubbleSortDemo {

    private static final Logger LOG = LogManager.getLogger(BubbleSortDemo.class);
    private static final int SIZE = 20_000;
    private static final int ITER = 10;

    private static long start = 0;
    private static long duration = 0;

    public static void main(String[] args) {
        int[] masterRandomIntArray = ArrayCreator.newRandomIntArray(SIZE);
        int[] masterReverseSortedIntArray = ArrayCreator.newReverseSortedIntArray(SIZE);
        int[] masterSortedIntArray = ArrayCreator.newSortedIntArray(SIZE);

        start = System.currentTimeMillis();
        for (int i = 0; i < ITER; i++) {
            Sort.bubbleSort(masterRandomIntArray.clone());
        }
        duration = System.currentTimeMillis() - start;
        LOG.info("random array - normal bubbleSort:\tsorted {} elements in {} ms", SIZE, duration / ITER);

        start = System.currentTimeMillis();
        for (int i = 0; i < ITER; i++) {
            Sort.bubbleSort(masterReverseSortedIntArray.clone());
        }
        duration = System.currentTimeMillis() - start;
        LOG.info("reversed array - normal bubbleSort:\tsorted {} elements in {} ms", SIZE, duration / ITER);

        start = System.currentTimeMillis();
        for (int i = 0; i < ITER; i++) {
            Sort.bubbleSort(masterSortedIntArray.clone());
        }
        duration = System.currentTimeMillis() - start;
        LOG.info("sorted array - normal bubbleSort:\tsorted {} elements in {} ms", SIZE, duration / ITER);

        start = System.currentTimeMillis();
        for (int i = 0; i < ITER; i++) {
            Sort.bubbleSortOptimized(masterRandomIntArray.clone());
        }
        duration = System.currentTimeMillis() - start;
        LOG.info("random array - optimized bubbleSort:\tsorted {} elements in {} ms", SIZE, duration / ITER);

        start = System.currentTimeMillis();
        for (int i = 0; i < ITER; i++) {
            Sort.bubbleSortOptimized(masterReverseSortedIntArray.clone());
        }
        duration = System.currentTimeMillis() - start;
        LOG.info("reversed array - optimized bubbleSort:\tsorted {} elements in {} ms", SIZE, duration / ITER);

        start = System.currentTimeMillis();
        for (int i = 0; i < ITER; i++) {
            Sort.bubbleSortOptimized(masterSortedIntArray.clone());
        }
        duration = System.currentTimeMillis() - start;
        LOG.info("sorted array - optimized bubbleSort:\t sorted {} elements in {} ms", SIZE, duration / ITER);
    }
}
