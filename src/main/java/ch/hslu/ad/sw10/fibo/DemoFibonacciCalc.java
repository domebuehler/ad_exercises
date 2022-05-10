/*
 * Copyright 2022 Hochschule Luzern Informatik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.hslu.ad.sw10.fibo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ForkJoinPool;

/**
 * Codevorlage für die Verwendung von RecursiveTask mit einem Fork-Join-Pool.
 */
public final class DemoFibonacciCalc {

    private static final Logger LOG = LogManager.getLogger(DemoFibonacciCalc.class);

    /**
     * Privater Konstruktor.
     */
    private DemoFibonacciCalc() {
    }

    /**
     * Berechnet den Fibonacci Wert für n.
     *
     * @param n für die Fibonacci Berechnung.
     * @return Resultat der Fibonacci Berechnung.
     */
    public static long fiboIterative(final int n) {
        long f = 0;
        long g = 1;
        for (int i = 1; i <= n; i++) {
            f = f + g;
            g = f - g;
        }
        return f;
    }

    /**
     * Berechnet den Fibonacci Wert für n.
     *
     * @param n für die Fibonacci Berechnung.
     * @return Resultat der Fibonacci Berechnung.
     */
    public static long fiboRecursive(final int n) {
        return n > 1 ? fiboRecursive(n - 1) + fiboRecursive(n - 2) : n;
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        final int n = 42;
        final FibonacciTask commonTask = new FibonacciTask(n);
        final FibonacciTask poolTask = new FibonacciTask(n);
        final ForkJoinPool pool = new ForkJoinPool();
        LOG.info("fibo({}) start...", n);

        long start = System.currentTimeMillis();
        long result = commonTask.invoke();
        long duration = System.currentTimeMillis() - start;
        LOG.info("Common Pool = {}", result);
        LOG.info("Common Pool : {} ms", duration);

        start = System.currentTimeMillis();
        result = pool.invoke(poolTask);
        duration = System.currentTimeMillis() - start;
        LOG.info("ForkJoinPool = {}", result);
        LOG.info("ForkJoinPool : {} ms", duration);

        start = System.currentTimeMillis();
        result = fiboIterative(n);
        duration = System.currentTimeMillis() - start;
        LOG.info("serial iterative = {}", result);
        LOG.info("serial iterative : {} ms", duration);

        start = System.currentTimeMillis();
        result = fiboRecursive(n);
        duration = System.currentTimeMillis() - start;
        LOG.info("serial recursive = {}", result);
        LOG.info("serial recursive : {} ms", duration);
    }
}
