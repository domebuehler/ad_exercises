package ch.hslu.ad.sw07.prime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrimeCheckConcurrent {

    private static final Logger LOG = LogManager.getLogger(PrimeCheckConcurrent.class);

    /**
     * Privater Konstruktor.
     */
    public PrimeCheckConcurrent() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(String[] args) {

        LOG.info(Runtime.getRuntime().availableProcessors());
        final ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);
        BigPrimeGenerator generator = new BigPrimeGenerator(100);
        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> generator.run());
        }
    }
}
