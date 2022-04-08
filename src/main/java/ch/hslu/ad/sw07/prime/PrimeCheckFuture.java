package ch.hslu.ad.sw07.prime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigInteger;
import java.util.List;

public final class PrimeCheckFuture {

    private static final Logger LOG = LogManager.getLogger(PrimeCheckFuture.class);

    private static final int NUMBER_OF_PRIMES = 100;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        List<BigInteger> primes = BigPrimeList.generateBigPrimeList(NUMBER_OF_PRIMES);
        long runtime = System.currentTimeMillis() - start;
        for (BigInteger prime : primes) {
            LOG.info(primes.indexOf(prime) + " - " + prime.toString().substring(0, 20) + "...");
        }
        LOG.info("time to generate {} primes: {} ms", NUMBER_OF_PRIMES, runtime); //~ 6.5s & 100 % Auslastung
    }
}
