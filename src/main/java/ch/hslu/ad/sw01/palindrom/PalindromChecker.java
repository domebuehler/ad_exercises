package ch.hslu.ad.sw01.palindrom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class PalindromChecker {

    private static final Logger LOG = LogManager.getLogger(PalindromChecker.class);

    private static Integer numberToCheck;
    private static String numberToCheckAsAString;
    private static String numberToCheckAsAStringReversed = "";

    public static boolean isPalindrom(int digits, int number) {
        numberToCheck = number;
        reverseNumber(digits);
        LOG.info("Number: {}", numberToCheckAsAString);
        LOG.info("Number reversed: {}", numberToCheckAsAStringReversed);
        return numberToCheckAsAString.equals(numberToCheckAsAStringReversed);
    }

    private static void reverseNumber(int digits) {
        numberToCheckAsAString = numberToCheck.toString();
        numberToCheckAsAStringReversed = "";
        for (int i = 0; i < digits; i++) {
            numberToCheckAsAStringReversed += numberToCheckAsAString.charAt(digits - 1 - i);
        }
    }

    public static int getNearestPalindrom(int digits, int number) {
        while (!isPalindrom(digits, number)) {
            number++;
        }
        return number;
    }
}
