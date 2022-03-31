package ch.hslu.ad.sw01_intro;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class AllocationTest {

    @Test
    void testEqualsContract() {
        EqualsVerifier.forClass(Allocation.class).verify();
    }

    @Test
    void testIfCompareToThrowsException() {
        Allocation allocation = new Allocation(10, 0);
        assertThatThrownBy(() -> allocation.compareTo(null)).isInstanceOf(NullPointerException.class);
    }

    @Test
    void testCompareToIfEquals() {
        Allocation allocation = new Allocation(10, 0);
        assertThat(allocation.compareTo(allocation)).isEqualTo(0);
    }

    @Test
    void testCompareToFirstIsBigger() {
        Allocation allocationBigger = new Allocation(10, 10);
        Allocation allocationSmaller = new Allocation(10, 0);
        assertThat(allocationBigger.compareTo(allocationSmaller)).isEqualTo(1);
    }

    @Test
    void testCompareToFirstIsSmaller() {
        Allocation allocationBigger = new Allocation(10, 10);
        Allocation allocationSmaller = new Allocation(10, 0);
        assertThat(allocationSmaller.compareTo(allocationBigger)).isEqualTo(-1);
    }
}