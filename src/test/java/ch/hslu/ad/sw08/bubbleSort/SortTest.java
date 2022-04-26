package ch.hslu.ad.sw08.bubbleSort;

import ch.hslu.ad.sw08.testData.ArrayCreator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class SortTest {

    private static final Logger LOG = LogManager.getLogger(SortTest.class);

    private static final int SMALL_SIZE = 10;
    private static final int BIG_SIZE = 100_000;

    @Test
    void testBubbleSortSameElementsAfterSortingWithSmallArray() {
        int[] toBeSorted = ArrayCreator.newSortedIntArray(SMALL_SIZE);
        int sumExpected = 0;
        for (int i : toBeSorted) {
            sumExpected += i;
        }
        Sort.bubbleSort(toBeSorted);
        int sumActual = 0;
        for (int i : toBeSorted) {
            sumActual += i;
        }
        assertThat(sumActual).isEqualTo(sumExpected);
    }

    @Test
    void testBubbleSortSameElementsAfterSortingWithBigArray() {
        int[] toBeSorted = ArrayCreator.newSortedIntArray(BIG_SIZE);
        int sumExpected = 0;
        for (int i : toBeSorted) {
            sumExpected += i;
        }
        Sort.bubbleSort(toBeSorted);
        int sumActual = 0;
        for (int i : toBeSorted) {
            sumActual += i;
        }
        assertThat(sumActual).isEqualTo(sumExpected);
    }

    @Test
    void testBubbleSortWithRandomSmallArray() {
        int[] toBeSorted = ArrayCreator.newRandomIntArray(SMALL_SIZE);
        LOG.debug("before: " + Arrays.toString(toBeSorted));
        Sort.bubbleSort(toBeSorted);
        LOG.debug("after: " + Arrays.toString(toBeSorted));
        assertThat(toBeSorted).isSorted();
    }

    @Test
    void testBubbleSortWithRandomBigArray() {
        int[] toBeSorted = ArrayCreator.newRandomIntArray(BIG_SIZE);
        Sort.bubbleSort(toBeSorted);
        assertThat(toBeSorted).isSorted();
    }

    @Test
    void testBubbleSortWithSortedSmallArray() {
        int[] toBeSorted = ArrayCreator.newSortedIntArray(SMALL_SIZE);
        LOG.debug("before: " + Arrays.toString(toBeSorted));
        Sort.bubbleSort(toBeSorted);
        LOG.debug("after: " + Arrays.toString(toBeSorted));
        assertThat(toBeSorted).isSorted();
    }

    @Test
    void testBubbleSortWithReverseSmallArray() {
        int[] toBeSorted = ArrayCreator.newReverseSortedIntArray(SMALL_SIZE);
        LOG.debug("before: " + Arrays.toString(toBeSorted));
        Sort.bubbleSort(toBeSorted);
        LOG.debug("after: " + Arrays.toString(toBeSorted));
        assertThat(toBeSorted).isSorted();
    }
}