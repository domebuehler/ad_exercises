package ch.hslu.ad.sw08.selectionSort;

import ch.hslu.ad.sw08.testData.ArrayCreator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SortTest {

    private static final Logger LOG = LogManager.getLogger(SortTest.class);

    @Test
    void testSelectionSortSameElementsAfterSorting() {
        int[] testArray = {12, 43, 5, 1, 9, 54};
        int expectedSum = 0;
        for (int i : testArray) {
            expectedSum += i;
        }
        Sort.selectionSort(testArray);
        int actualSum = 0;
        for (int i : testArray) {
            actualSum += i;
        }

        assertThat(actualSum).isEqualTo(expectedSum);
    }

    @Test
    void testSelectionSortOrderAfterSorting() {
        int[] toBeSorted = {12, 43, 5, 1, 9, 54};
        Sort.selectionSort(toBeSorted);
        assertThat(toBeSorted).isSorted();
    }

    @Test
    void testSelectionSortBigArrayOrderAfterSorting() {
        int[] toBeSorted = ArrayCreator.newRandomIntArray(10_000);
        Sort.selectionSort(toBeSorted);
        assertThat(toBeSorted).isSorted();
    }
}