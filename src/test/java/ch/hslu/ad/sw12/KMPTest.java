package ch.hslu.ad.sw12;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class KMPTest {

    private static final Logger LOG = LogManager.getLogger(KMPTest.class);

    @Test
    void testKMPSearchEISBEIN1() {
        int index = KMP.kmpSearch("sdffdseEISBEINfasfa", "EISBEIN");
        assertThat(index).isEqualTo(7);
    }

    @Test
    void testKMPSearchEIBEIN2() {
        int index = KMP.kmpSearch("EISBEINfasfa", "EISBEIN");
        assertThat(index).isEqualTo(0);
    }

    @Test
    void testKMPSearchabc() {
        int index = KMP.kmpSearch("abcaaabcacaabcaabaababcabcaaa", "abcaab");
        assertThat(index).isEqualTo(11);
    }

    @Test
    void stateSearchANANAS1() {
        int index = KMP.kmpSearch("ANANAS", "ANANAS");
        assertThat(index).isEqualTo(0);
    }

    @Test
    void stateSearchANANAS2() {
        int index = KMP.kmpSearch("AAAAAANANAS", "ANANAS");
        assertThat(index).isEqualTo(5);
    }

    @Test
    void stateSearchANANAS3() {
        int index = KMP.kmpSearch("SANANAS", "ANANAS");
        assertThat(index).isEqualTo(1);
    }

    @Test
    void stateSearchANANAS4() {
        int index = KMP.kmpSearch("BSSANBSBSANANASSSSSS", "ANANAS");
        assertThat(index).isEqualTo(9);
    }

    @Test
    void stateSearchANANAS5() {
        int index = KMP.kmpSearch("NNNNNNAAANNSSNANSNNS", "ANANAS");
        assertThat(index).isEqualTo(-1);
    }

    @Test
    void stateSearchANANAS6() {
        int index = KMP.kmpSearch("SANASANASNASNNASNS", "ANANAS");
        assertThat(index).isEqualTo(-1);
    }

    @Test
    void stateSearchANANAS7() {
        int index = KMP.kmpSearch("AAAAAAAAAAAAAAAAAAAA", "ANANAS");
        assertThat(index).isEqualTo(-1);
    }

    @Test
    void stateSearchANANAS8() {
        int index = KMP.kmpSearch("ANANA", "ANANAS");
        assertThat(index).isEqualTo(-1);
    }

    @Test
    void testInitNextEISBEIN() {
        int[] actualNext = KMP.initNext("EISBEIN");
        int[] expectedNext = {-1, 0, 0, 0, 0, 1, 2};
        LOG.info("actual: " + Arrays.toString(actualNext));
        LOG.info("expected: " + Arrays.toString(expectedNext));
        assertThat(actualNext).isEqualTo(expectedNext);
    }

    @Test
    void testInitNextANANAS() {
        int[] actualNext = KMP.initNext("ANANAS");
        int[] expectedNext = {-1, 0, 0, 1, 2, 3};
        LOG.info("actual: " + Arrays.toString(actualNext));
        LOG.info("expected: " + Arrays.toString(expectedNext));
        assertThat(actualNext).isEqualTo(expectedNext);
    }
}