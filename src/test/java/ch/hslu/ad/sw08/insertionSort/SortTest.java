package ch.hslu.ad.sw08.insertionSort;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class SortTest {
    int Dummy = Integer.MAX_VALUE;

    private static final Logger LOG = LogManager.getLogger(SortTest.class);

    @Test
    void testInsertionSortDemo() {
        int[] toBeSorted = {Dummy,23,1,4,7,12,2};
        LOG.debug(Arrays.toString(toBeSorted));
        Sort.insertionSort(toBeSorted);
        LOG.debug(Arrays.toString(toBeSorted));
    }

    @Test
    void testInsertionSortSameElementsAfterSort() {
        int[] toBeSorted = {Dummy,23,1,4,7,12,2};
        int sumBefore = 0;
        for (int i = 1; i < toBeSorted.length; i++) {
            sumBefore += toBeSorted[i];
        }
        Sort.insertionSort(toBeSorted);
        int sumAfter = 0;
        for (int i = 1; i < toBeSorted.length; i++) {
            sumAfter += toBeSorted[i];
        }
        assertThat(sumAfter).isEqualTo(sumBefore);
    }

    @Test
    void testInsertionSortWithSixUnsortedElements() {
        int[] toBeSorted = {Dummy,23,1,4,7,12,2};
        int[] expected = {2, 1, 2, 4, 7, 12, 23};

        Sort.insertionSort(toBeSorted);
        assertThat(toBeSorted).isEqualTo(expected);
    }
}