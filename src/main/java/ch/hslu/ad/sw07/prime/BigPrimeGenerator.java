package ch.hslu.ad.sw07.prime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigPrimeGenerator implements Runnable {

    private static final Logger LOG = LogManager.getLogger(BigPrimeGenerator.class);

    private int numberOfPrimes = 0;
    private final int targetValueNumberOfPrimes;

    public BigPrimeGenerator(int numberOfPrimes) {
        this.targetValueNumberOfPrimes = numberOfPrimes;
    }

    @Override
    public void run() {
        while (!isDone()) {
            BigInteger bi = new BigInteger(1024, new Random());
            if (bi.isProbablePrime(Integer.MAX_VALUE)) {
                LOG.info(getNumberOfPrimes() + ": " + bi.toString().substring(0, 20) + "...");
                increment();
                return;
            }
        }

    }

    public void generate() {
        final ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);
    }

    private synchronized int getNumberOfPrimes() {
        return this.numberOfPrimes;
    }

    private synchronized void increment() {
        this.numberOfPrimes++;
    }

    private synchronized boolean isDone() {
        return this.numberOfPrimes == this.targetValueNumberOfPrimes;
    }
}
