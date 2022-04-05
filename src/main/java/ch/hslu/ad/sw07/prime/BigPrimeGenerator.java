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
    private ExecutorService executorService;
    private long end;
    private long start;

    public BigPrimeGenerator(int numberOfPrimes) {
        this.targetValueNumberOfPrimes = numberOfPrimes;
    }

    @Override
    public void run() {
        while (!isDone()) {
            BigInteger bi = new BigInteger(1024, new Random());
            if (bi.isProbablePrime(Integer.MAX_VALUE)) {
                increment();
                LOG.info("ThreadName: " + Thread.currentThread().getName() + " N°: " + getNumberOfPrimes() + ": "
                        + bi.toString().substring(0, 20) + "...");
                return;
            }
        }
        shutdownExecutor();
    }

    private void shutdownExecutor() {
        this.end = System.currentTimeMillis();
        LOG.info("Shutdown after {} primes in {} ms", this.numberOfPrimes, this.end - this.start);
        this.executorService.shutdown();
    }

    public void generate() {
        this.start = System.currentTimeMillis();
        this.numberOfPrimes = 0;
        giveTasksToExecutor();
    }

    private void giveTasksToExecutor() {
        this.executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);
        for (int i = 0; i <= this.targetValueNumberOfPrimes; i++) {
            this.executorService.execute(() -> this.run());
        }
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
