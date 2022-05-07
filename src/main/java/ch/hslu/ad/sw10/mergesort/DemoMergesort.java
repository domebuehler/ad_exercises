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
package ch.hslu.ad.sw10.mergesort;

import java.util.concurrent.ForkJoinPool;

import ch.hslu.ad.sw10.array.init.RandomInitTask;
import ch.hslu.ad.sw10.array.sum.SumTask;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Performance Vergleich der Mergesort-Implementation.
 */
public final class DemoMergesort {

    static final int SIZE = 300_000_000;
    static final int[] ARRAY = new int[SIZE];
    static final ForkJoinPool POOL = new ForkJoinPool();
    static SumTask sumTask;
    static long start;
    static long duration;
    static long[] durationArray = new long[20];
    static long result;

    private static final Logger LOG = LogManager.getLogger(DemoMergesort.class);

    private DemoMergesort() {}

    public static void main(final String[] args) {
        int iter = 10;
        for (int i = 0; i < iter; i++) {
            parallelMergeSort();
            durationArray[i] = duration;
        }
        double sum = 0;
        for (int i = 0; i < iter; i++) {
            sum += durationArray[i];
        }
        LOG.info("average parallel: {} ms", sum / iter);

       /* for (int i = 0; i < iter; i++) {
            serialMergeSort();
            durationArray[i + iter] = duration;
        }
        sum = 0;
        for (int i = 0; i < iter; i++) {
            sum += durationArray[i + iter];
        }
        LOG.info("average serial: {} ms", sum / iter);*/
    }

    private static void parallelMergeSort() {
        randomize();
        sumTask = new SumTask(ARRAY);
        result = POOL.invoke(sumTask);
        LOG.info("Initial Checksum  : {}", result);
        final MergesortTask sortTask = new MergesortTask(ARRAY);
        start = System.currentTimeMillis();
        POOL.invoke(sortTask);
        duration = System.currentTimeMillis() - start;
        LOG.info("Concurrent Mergesort: {} ms", duration);
        sumTask = new SumTask(ARRAY);
        result = POOL.invoke(sumTask);
        LOG.info("Merge Checksum  : {}", result);
    }

    private static void serialMergeSort() {
        randomize();
        sumTask = new SumTask(ARRAY);
        result = POOL.invoke(sumTask);
        LOG.info("Initial checksum  : {}", result);
        start = System.currentTimeMillis();
        MergesortRecursive.mergeSort(ARRAY);
        duration = System.currentTimeMillis() - start;
        LOG.info("Serial Mergesort   : {} ms", duration);
        sumTask = new SumTask(ARRAY);
        result = POOL.invoke(sumTask);
        LOG.info("Sort checksum   : {}", result);
    }

    private static void randomize() {
        RandomInitTask initTask = new RandomInitTask(ARRAY, 100);
        POOL.invoke(initTask);
    }
}
