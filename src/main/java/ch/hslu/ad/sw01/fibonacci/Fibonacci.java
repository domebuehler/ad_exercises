package ch.hslu.ad.sw01.fibonacci;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Fibonacci {

    private static final Logger LOG = LogManager.getLogger(Fibonacci.class);

    private static long[] fibonacciNumbers = new long[100];

    public static long getFibonacciNumberRecursive(final int grade) {
        if (grade == 0) { //Rekursiv-Basis
            return 0;
        } else if (grade == 1) { //Rekursiv-Basis
            return 1;
        } else { //Rekursiv-Vorschrift
            return getFibonacciNumberRecursive(grade - 2) +
                    getFibonacciNumberRecursive(grade - 1);
        }
    }

    public static long getFibonacciNumberRecursive2(final int grade) {
        if (fibonacciNumbers[grade] > 0) {
            return fibonacciNumbers[grade];
        } else if (grade == 0) { //Rekursiv-Basis
            return 0;
        } else if (grade == 1) { //Rekursiv-Basis
            return 1;
        } else { //Rekursiv-Vorschrift
            fibonacciNumbers[grade] = getFibonacciNumberRecursive2(grade - 2) +
                    getFibonacciNumberRecursive2(grade - 1);
            return fibonacciNumbers[grade];
        }
    }

    public static void clearCacheArray() {
        fibonacciNumbers = new long[100];
    }

    public static long getFibonacciNumberIterative(final int grade) {
        long minusTwo = 0;
        long minusOne = 1;
        long current = 0;
        if (grade == 0) {
            return 0;
        } else if (grade == 1) {
            return 1;
        }
        for (int i = 2; i <= grade; i++) {
            current = minusTwo + minusOne;
            minusTwo = minusOne;
            minusOne = current;
        }
        return current;
    }
}
