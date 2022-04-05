package ch.hslu.ad.sw07.prime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PrimeCheckConcurrent {

    private static final int NUMBER_OF_PRIMES = 100;

    private PrimeCheckConcurrent() {
    }

    public static void main(String[] args) {
        BigPrimeGenerator generator = new BigPrimeGenerator(NUMBER_OF_PRIMES);
        generator.generate(); // ~ 6-7s bei 100 % Auslastung
    }
}
