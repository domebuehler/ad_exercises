package ch.hslu.ad.sw09.quickSort;

import ch.hslu.ad.sw09.testData.ArrayCreator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class QuickSortTest {

    private final static Logger LOG = LogManager.getLogger(QuickSortTest.class);
    private final static int SMALL_SIZE = 10;
    private final static int BIG_SIZE = 100_000;
    private final ArrayCreator arrayCreator = new ArrayCreator();

    @Test
    void testQuickSortSmallRandomArray() {
        this.arrayCreator.createNewMasterCharArray(SMALL_SIZE);
        final char[] toBeSorted = arrayCreator.getMasterCharArray();
        QuickSort.quickSortForChars(toBeSorted, 0, toBeSorted.length - 1);
        assertThat(toBeSorted).isSorted();
    }

    @Test
    void testQuickSortBigRandomArray() {
        this.arrayCreator.createNewMasterCharArray(BIG_SIZE);
        final char[] toBeSorted = arrayCreator.getMasterCharArray();
        QuickSort.quickSortForChars(toBeSorted, 0, toBeSorted.length - 1);
        assertThat(toBeSorted).isSorted();
    }

    @Test
    void testOverRiddenQuickSortSmallRandomArray() {
        this.arrayCreator.createNewMasterCharArray(SMALL_SIZE);
        final char[] toBeSorted = arrayCreator.getMasterCharArray();
        QuickSort.quickSortForChars(toBeSorted);
        assertThat(toBeSorted).isSorted();
    }

    @Test
    void testOverRiddenQuickSortBigRandomArray() {
        this.arrayCreator.createNewMasterCharArray(BIG_SIZE);
        final char[] toBeSorted = arrayCreator.getMasterCharArray();
        QuickSort.quickSortForChars(toBeSorted);
        assertThat(toBeSorted).isSorted();
    }

    @Test
    void testQuickSortExchangingEqualsToSmallRandomArray() {
        this.arrayCreator.createNewMasterCharArray(SMALL_SIZE);
        final char[] toBeSorted = arrayCreator.getMasterCharArray();
        QuickSort.quickSortForCharsExchangingEqualsTo(toBeSorted);
        assertThat(toBeSorted).isSorted();
    }

    @Test
    void testQuickSortExchangingEqualsToBigRandomArray() {
        this.arrayCreator.createNewMasterCharArray(BIG_SIZE);
        final char[] toBeSorted = arrayCreator.getMasterCharArray();
        QuickSort.quickSortForCharsExchangingEqualsTo(toBeSorted);
        assertThat(toBeSorted).isSorted();
    }

    @Test
    void testQuickSortForIntsWithSmallRandomArray() {
        this.arrayCreator.createNewMasterIntArray(SMALL_SIZE);
        final int[] toBeSorted = arrayCreator.getMasterIntArray();
        QuickSort.quickSortForInts(toBeSorted);
        assertThat(toBeSorted).isSorted();
    }

    @Test
    void testQuickSortForIntsWithBigRandomArray() {
        this.arrayCreator.createNewMasterIntArray(BIG_SIZE);
        final int[] toBeSorted = arrayCreator.getMasterIntArray();
        QuickSort.quickSortForInts(toBeSorted);
        assertThat(toBeSorted).isSorted();
    }
}