package ch.hslu.ad.sw12;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OptimizedSearchAutomateTest {

    @Test
    void stateSearchANANAS1() {
        int index = OptimizedSearchAutomate.stateSearchANANAS("ANANAS");
        assertThat(index).isEqualTo(0);
    }

    @Test
    void stateSearchANANAS2() {
        int index = OptimizedSearchAutomate.stateSearchANANAS("AAAAAANANAS");
        assertThat(index).isEqualTo(5);
    }

    @Test
    void stateSearchANANAS3() {
        int index = OptimizedSearchAutomate.stateSearchANANAS("SANANAS");
        assertThat(index).isEqualTo(1);
    }

    @Test
    void stateSearchANANAS4() {
        int index = OptimizedSearchAutomate.stateSearchANANAS("BSSANBSBSANANASSSSSS");
        assertThat(index).isEqualTo(9);
    }

    @Test
    void stateSearchANANAS5() {
        int index = OptimizedSearchAutomate.stateSearchANANAS("NNNNNNAAANNSSNANSNNS");
        assertThat(index).isEqualTo(-1);
    }

    @Test
    void stateSearchANANAS6() {
        int index = OptimizedSearchAutomate.stateSearchANANAS("SANASANASNASNNASNS");
        assertThat(index).isEqualTo(-1);
    }

    @Test
    void stateSearchANANAS7() {
        int index = OptimizedSearchAutomate.stateSearchANANAS("AAAAAAAAAAAAAAAAAAAA");
        assertThat(index).isEqualTo(-1);
    }

    @Test
    void stateSearchANANAS8() {
        int index = OptimizedSearchAutomate.stateSearchANANAS("ANANA");
        assertThat(index).isEqualTo(-1);
    }

    @Test
    void stateSearchANANASNull() {
        int index = OptimizedSearchAutomate.stateSearchANANAS(null);
        assertThat(index).isEqualTo(-1);
    }
}