package ch.hslu.ad.sw01.fibonacci;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FibonacciTest {

    private static final Logger LOG = LogManager.getLogger(FibonacciTest.class);

    @Test
    void testGetFibonacci0thGradeRecursive() {
        assertThat(Fibonacci.getFibonacciNumberRecursive(0)).isEqualTo(0);
    }

    @Test
    void testGetFibonacci1thGradeRecursive() {
        assertThat(Fibonacci.getFibonacciNumberRecursive(1)).isEqualTo(1);
    }

    @Test
    void testGetFibonacci6thGradeRecursive() {
        assertThat(Fibonacci.getFibonacciNumberRecursive(6)).isEqualTo(8);
    }

    @Test
    void testGetFibonacci20thGradeRecursive() {
        long start = System.currentTimeMillis();
        assertThat(Fibonacci.getFibonacciNumberRecursive(20)).isEqualTo(6765);
        long end = System.currentTimeMillis();
        LOG.info("First implementation for Grade = 20 took {} milliseconds", end - start);

    }

    @Test
    void testGetFibonacci30thGradeRecursive() {
        long start = System.currentTimeMillis();
        assertThat(Fibonacci.getFibonacciNumberRecursive(30)).isEqualTo(832040);
        long end = System.currentTimeMillis();
        LOG.info("First implementation for Grade = 30 took {} milliseconds", end - start);

    }

    @Test
    void testGetFibonacci40thGradeRecursive() {
        long start = System.currentTimeMillis();
        assertThat(Fibonacci.getFibonacciNumberRecursive(40)).isEqualTo(102334155L);
        long end = System.currentTimeMillis();
        LOG.info("First implementation for Grade = 40 took {} milliseconds", end - start);
    }

    @Test
    void testGetFibonacci0thGradeRecursive2() {
        assertThat(Fibonacci.getFibonacciNumberRecursive2(0)).isEqualTo(0);
    }

    @Test
    void testGetFibonacci1thGradeRecursive2() {
        assertThat(Fibonacci.getFibonacciNumberRecursive2(1)).isEqualTo(1);
    }

    @Test
    void testGetFibonacci6thGradeRecursive2() {
        assertThat(Fibonacci.getFibonacciNumberRecursive2(6)).isEqualTo(8);
    }

    @Test
    void testGetFibonacci20thGradeRecursive2() {
        long start = System.currentTimeMillis();
        assertThat(Fibonacci.getFibonacciNumberRecursive2(20)).isEqualTo(6765);
        long end = System.currentTimeMillis();
        LOG.info("Second implementation for Grade = 20 took {} milliseconds", end - start);
    }

    @Test
    void testGetFibonacci30thGradeRecursive2() {
        long start = System.currentTimeMillis();
        assertThat(Fibonacci.getFibonacciNumberRecursive2(30)).isEqualTo(832040);
        long end = System.currentTimeMillis();
        LOG.info("Second implementation for Grade = 30 took {} milliseconds", end - start);
    }

    @Test
    void testGetFibonacci40thGradeRecursive2() {
        long start = System.currentTimeMillis();
        assertThat(Fibonacci.getFibonacciNumberRecursive2(40)).isEqualTo(102334155L);
        long end = System.currentTimeMillis();
        LOG.info("Second implementation for Grade = 40 took {} milliseconds", end - start);
    }

    @Test
    void testGetFibonacci0thGradeIterative() {
        assertThat(Fibonacci.getFibonacciNumberIterative(0)).isEqualTo(0);
    }

    @Test
    void testGetFibonacci1thGradeIterative() {
        assertThat(Fibonacci.getFibonacciNumberIterative(1)).isEqualTo(1);
    }

    @Test
    void testGetFibonacci20thGradeIterative() {
        assertThat(Fibonacci.getFibonacciNumberIterative(20)).isEqualTo(6765);
    }

    @Test
    void testGetFibonacci30thGradeIterative() {
        long start = System.currentTimeMillis();
        assertThat(Fibonacci.getFibonacciNumberIterative(30)).isEqualTo(832040);
        long end = System.currentTimeMillis();
        LOG.info("Third implementation for Grade = 30 took {} milliseconds", end - start);
    }

    @Test
    void testGetFibonacci40thGradeIterative() {
        long start = System.currentTimeMillis();
        assertThat(Fibonacci.getFibonacciNumberIterative(40)).isEqualTo(102334155L);
        long end = System.currentTimeMillis();
        LOG.info("Third implementation for Grade = 40 took {} milliseconds", end - start);
    }
}