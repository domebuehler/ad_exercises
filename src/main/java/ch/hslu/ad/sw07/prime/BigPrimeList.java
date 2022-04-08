package ch.hslu.ad.sw07.prime;

import ch.hslu.ad.sw01.runtime.Task;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigInteger;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public final class BigPrimeList {

    private static final Logger LOG = LogManager.getLogger(BigPrimeList.class);

    private static final List<BigInteger> primes = new LinkedList<>();
    private static int targetValueOfPrimes;
    private static final List<FutureTask<BigInteger>> tasks = new LinkedList<>();
    private static ExecutorService executorService;

    public static List<BigInteger> generateBigPrimeList(int listSize) {
        targetValueOfPrimes = listSize;
        generatePrimes();
        return primes;
    }

    private static void generatePrimes() {
        startExecutor();
        addResultsToList();
        executorService.shutdown();
    }

    private static void startExecutor() {
        executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);
        BigPrimeGenerator bigPrimeGenerator = new BigPrimeGenerator();

        for (int i = 0; i < targetValueOfPrimes; i++) {
            FutureTask<BigInteger> task = new FutureTask<>(bigPrimeGenerator);
            tasks.add(task);
            executorService.submit(task);
        }
    }

    private static void addResultsToList() {
        for (FutureTask<BigInteger> task : tasks) {
            try {
                primes.add(task.get());
            } catch (InterruptedException | ExecutionException e) {
                LOG.debug("can't get the result because of: " + e);
            }
        }
    }
}
