package ch.hslu.ad.sw01.palindrom;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PalindromCheckerTest {

    @Test
    void testIsPalindrom3DigitsTrue() {
        assertThat(PalindromChecker.isPalindrom(3, 323)).isTrue();
    }

    @Test
    void testIsPalindrom3DigitsFalse() {
        assertThat(PalindromChecker.isPalindrom(3, 123)).isFalse();
    }

    @Test
    void testIsPalindrom4DigitsTrue() {
        assertThat(PalindromChecker.isPalindrom(4, 3223)).isTrue();
    }

    @Test
    void testIsPalindrom4DigitsFalse() {
        assertThat(PalindromChecker.isPalindrom(4, 1235)).isFalse();
    }

    @Test
    void testIsPalindrom5DigitsTrue() {
        assertThat(PalindromChecker.isPalindrom(5, 32523)).isTrue();
    }

    @Test
    void testIsPalindrom5DigitsFalse() {
        assertThat(PalindromChecker.isPalindrom(5, 12358)).isFalse();
    }

    @Test
    void testGetNearestPalindrom() {
        assertThat(PalindromChecker.getNearestPalindrom(3, 193)).isEqualTo(202);
    }

    @Test
    void testGetNearestPalindrom5Digits() {
        assertThat(PalindromChecker.getNearestPalindrom(5, 36476)).isEqualTo(36563);
    }
}