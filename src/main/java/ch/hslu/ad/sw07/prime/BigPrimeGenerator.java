package ch.hslu.ad.sw07.prime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigInteger;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

