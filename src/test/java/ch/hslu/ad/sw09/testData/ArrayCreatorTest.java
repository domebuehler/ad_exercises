package ch.hslu.ad.sw09.testData;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ArrayCreatorTest {

    private static final int SMALL_SIZE = 10;
    private static final int BIG_SIZE = 100_000;
    private ArrayCreator arrayCreator = new ArrayCreator();

    @Test
    void testCreateRandomCharsSmall() {
        arrayCreator.createNewMasterCharArray(SMALL_SIZE);
        char[] randomChars = arrayCreator.getMasterCharArray();
        assertThat(randomChars.length).isEqualTo(SMALL_SIZE);
    }

    @Test
    void testCreateRandomCharsBig() {
        arrayCreator.createNewMasterCharArray(BIG_SIZE);
        char[] randomChars = arrayCreator.getMasterCharArray();
        assertThat(randomChars.length).isEqualTo(BIG_SIZE);
    }

    @Test
    void testCreateRandomIntSmall() {
        arrayCreator.createNewMasterIntArray(SMALL_SIZE);
        int[] randomInts = arrayCreator.getMasterIntArray();
        assertThat(randomInts.length).isEqualTo(SMALL_SIZE);
    }

    @Test
    void testCreateRandomIntBig() {
        arrayCreator.createNewMasterIntArray(BIG_SIZE);
        int[] randomInts = arrayCreator.getMasterIntArray();
        assertThat(randomInts.length).isEqualTo(BIG_SIZE);
    }
}