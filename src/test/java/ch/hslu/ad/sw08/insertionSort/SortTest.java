package ch.hslu.ad.sw08.insertionSort;

import ch.hslu.ad.sw08.testData.ArrayCreator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class SortTest {
    private static final int SMALL_SIZE = 10;
    private static final int BIG_SIZE = 100_000;

    private static final Logger LOG = LogManager.getLogger(SortTest.class);



    @Test
    void testInsertionSortSameElementsAfterSortWithSmallRandomArray() {
        int[] toBeSorted = ArrayCreator.newRandomIntArray(SMALL_SIZE);
        int sumBefore = 0;
        for (int i = 0; i < toBeSorted.length; i++) {
            sumBefore += toBeSorted[i];
        }
        Sort.insertionSort(toBeSorted);
        int sumAfter = 0;
        for (int i = 0; i < toBeSorted.length; i++) {
            sumAfter += toBeSorted[i];
        }
        assertThat(sumAfter).isEqualTo(sumBefore);
    }

    @Test
    void testInsertionSortWithSmallRandomArray() {
        int[] toBeSorted = ArrayCreator.newRandomIntArray(SMALL_SIZE);
        LOG.debug(Arrays.toString(toBeSorted));
        toBeSorted = Sort.insertionSort(toBeSorted);
        LOG.debug(Arrays.toString(toBeSorted));
        assertThat(toBeSorted).isSorted();
    }

    @Test
    void testInsertionSortWithSmallReversedArray() {
        int[] toBeSorted = ArrayCreator.newReverseSortedIntArray(SMALL_SIZE);
        toBeSorted = Sort.insertionSort(toBeSorted);
        LOG.debug(Arrays.toString(toBeSorted));
    }

    @Test
    void testInsertionSortWithSmallSortedArray() {
        int[] toBeSorted = ArrayCreator.newReverseSortedIntArray(SMALL_SIZE);
        toBeSorted = Sort.insertionSort(toBeSorted);
        assertThat(toBeSorted).isSorted();
    }
}