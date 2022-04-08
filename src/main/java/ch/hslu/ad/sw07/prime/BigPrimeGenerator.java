package ch.hslu.ad.sw07.prime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.Callable;

public class BigPrimeGenerator implements Callable<BigInteger> {

    private static final Logger LOG = LogManager.getLogger(BigPrimeGenerator.class);

    @Override
    public BigInteger call() throws Exception {
        while (true) {
            BigInteger bi = new BigInteger(1024, new Random());
            if (bi.isProbablePrime(Integer.MAX_VALUE)) {
                LOG.info("ThreadName: " + Thread.currentThread().getName() + " ---  "
                        + bi.toString().substring(0, 20) + "...");
                return bi;
            }
        }
    }
}

