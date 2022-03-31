package ch.hslu.ad.sw01.palindrom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class PalindromChecker {

    private static final Logger LOG = LogManager.getLogger(PalindromChecker.class);

    public static boolean isPalindrom(int digits, int numberToCheck) {
        Integer number = numberToCheck;
        String numberAsString = number.toString();
        String numberAsStringReversed = "";
        for (int i = 0; i < digits; i++) {
            numberAsStringReversed += numberAsString.charAt(digits - 1 - i);
        }
        LOG.info("Number: {}", numberAsString);
        LOG.info("Number reversed: {}", numberAsStringReversed);
        if (numberAsString.equals(numberAsStringReversed)) {
            return true;
        } else {
            return false;
        }
    }

    public static int getNearestPalindrom(int digits, int number) {
        while (!isPalindrom(digits, number)) {
            number++;
        }
        return number;
    }
}
