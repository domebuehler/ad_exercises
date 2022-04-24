package ch.hslu.ad.sw08.testData;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ArrayCreatorTest {

    private static final Logger LOG = LogManager.getLogger(ArrayCreatorTest.class);

    @Test
    void testNewRandomArray() {
        int[] intArray = ArrayCreator.newRandomIntArray(10);
        LOG.info("Random: " + Arrays.toString(intArray));
        assertThat(intArray.length).isEqualTo(10);
    }

    @Test
    void testNewSortedArray() {
        int[] intArray = ArrayCreator.newRandomSortedIntArray(10);
        LOG.info("Sorted: " + Arrays.toString(intArray));
        assertThat(intArray.length).isEqualTo(10);
    }

    @Test
    void testNewReverseSortedArray() {
        int[] intArray = ArrayCreator.newRandomReverseSortedIntArray(10);
        LOG.info("Reversed: " + Arrays.toString(intArray));
        assertThat(intArray.length).isEqualTo(10);
    }
}