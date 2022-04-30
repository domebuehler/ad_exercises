package ch.hslu.ad.sw09.heap;

import ch.hslu.ad.sw09.testData.ArrayCreator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HeapSortTest {

    @Test
    void testHeapSortSmallArray() {
        ArrayCreator arrayCreator = new ArrayCreator();
        arrayCreator.createNewMasterIntArray(10);
        int[] sorted = HeapSort.heapSort(arrayCreator.getMasterIntArray());
        assertThat(sorted).isSorted();
    }
}