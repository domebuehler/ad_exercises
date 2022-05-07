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
package ch.hslu.ad.sw10.quicksort;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

import ch.hslu.ad.sw10.array.init.RandomInitTask;
import ch.hslu.ad.sw10.array.sum.SumTask;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Vergleich von verschiedenen Quicksort-Implementationen.
 */
public final class DemoQuicksort {

    private static long start;
    private static long duration;

    private static final Logger LOG = LogManager.getLogger(DemoQuicksort.class);

    private DemoQuicksort() {
    }

    public static void main(final String[] args) {
        final int size = 30_000_000;
        final int[] array = new int[size];
        final ForkJoinPool pool = new ForkJoinPool();
        RandomInitTask initTask = new RandomInitTask(array, 100_000);
        pool.invoke(initTask);
        SumTask sumTask = new SumTask(array);
        long result = pool.invoke(sumTask);
        LOG.info("Initial Checksum : {}", result);
        final QuicksortTask sortTask = new QuicksortTask(array);
        start = System.currentTimeMillis();
        pool.invoke(sortTask);
        duration = System.currentTimeMillis() - start;
        LOG.info("QuicksortTask  : {} ms", duration);
        sumTask = new SumTask(array);
        result = pool.invoke(sumTask);
        LOG.info("Concurrent Checksum : {}", result);

        initTask = new RandomInitTask(array, 100_000);
        pool.invoke(initTask);
        sumTask = new SumTask(array);
        result = pool.invoke(sumTask);
        LOG.info("Initial Checksum : {}", result);
        start = System.currentTimeMillis();
        QuicksortRecursive.quickSortForInts(array);
        duration = System.currentTimeMillis() - start;
        LOG.info("Serial Quicksort  : {} ms", duration);
        sumTask = new SumTask(array);
        result = pool.invoke(sumTask);
        LOG.info("Serial Checksum : {}", result);

        initTask = new RandomInitTask(array, 100_000);
        pool.invoke(initTask);
        sumTask = new SumTask(array);
        result = pool.invoke(sumTask);
        LOG.info("Initial checksum : {}", result);
        start = System.currentTimeMillis();
        Arrays.sort(array);
        duration = System.currentTimeMillis() - start;
        LOG.info("Arrays.sort    : {} ms", duration);
        sumTask = new SumTask(array);
        result = pool.invoke(sumTask);
        LOG.info("Arrays.sort checksum  : {}", result);
    }
}
