/*
 * Copyright 2022 Hochschule Luzern - Informatik.
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
package ch.hslu.ad.sw07.conclist;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Demonstration einer synchronisierten List mit n Producer und m Consumer.
 */
@SuppressWarnings("DuplicatedCode")
public final class DemoConcurrentList {

    private static final Logger LOG = LogManager.getLogger(DemoConcurrentList.class);

    private DemoConcurrentList() {
    }

    public static void main(final String args[]) throws InterruptedException, ExecutionException {

        final List<Integer> list = Collections.synchronizedList(new LinkedList<>());
        final ExecutorService executor = Executors.newCachedThreadPool();
        final List<Future<Long>> futures = new ArrayList<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            futures.add(executor.submit(new Producer(list, 10_000)));
        }
        Iterator<Future<Long>> iterator = futures.iterator();
        long totProd = 0;
        while (iterator.hasNext()) {
            long sum = iterator.next().get();
            totProd += sum;
            LOG.info("prod sum = " + sum);
        }
        LOG.info("prod tot = " + totProd);
        long totCons = executor.submit(new Consumer(list)).get();
        LOG.info("cons tot = " + totCons);
        executor.shutdown();
        long runtime = System.currentTimeMillis() - start;
        LOG.info("list finished after: {} ms", runtime);
    }
}
