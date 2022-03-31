package ch.hslu.ad.sw01.fibonacci;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class FibonacciRuntimeMeasurement {

    private static final Logger LOG = LogManager.getLogger(FibonacciRuntimeMeasurement.class);

    private static final int ITER = 1000000;
    private static final int GRADE = 42;

    public static void main(String[] args) {

        long start = System.nanoTime();
        Fibonacci.getFibonacciNumberRecursive(GRADE);
        long end = System.nanoTime();
        LOG.info("Rekursive Lösung: Laufzeit = {} ms für Grade = {} ", (end - start) / 1000000, GRADE);

        start = System.nanoTime();
        for (int i = 0; i < ITER; i++) {
            Fibonacci.getFibonacciNumberRecursive2(GRADE);
            Fibonacci.clearCacheArray();
        }
        end = System.nanoTime();
        LOG.info("Rekursive Lösung mit Cache: Laufzeit = {} ns für Grade = {} ", (end - start )/ ITER, GRADE);

        start = System.nanoTime();
        for (int i = 0; i < ITER; i++) {
            Fibonacci.getFibonacciNumberIterative(GRADE);
        }
        end = System.nanoTime();
        LOG.info("Iterative Lösung: Laufzeit = {} ns für Grade = {} ", (end - start )/ ITER, GRADE);
    }
}
