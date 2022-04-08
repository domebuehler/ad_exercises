package ch.hslu.ad.sw07.conclist;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.concurrent.*;

@SuppressWarnings("DuplicatedCode")
public class DemoBlockingQueue {

    private static final Logger LOG = LogManager.getLogger(DemoConcurrentList.class);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final Queue<Integer> queue = new LinkedBlockingDeque<>();
        final ExecutorService executor = Executors.newCachedThreadPool();
        final List<Future<Long>> futures = new ArrayList<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            futures.add(executor.submit(new Producer(queue, 10_000)));
        }
        Iterator<Future<Long>> iterator = futures.iterator();
        long totProd = 0;
        while (iterator.hasNext()) {
            long sum = iterator.next().get();
            totProd += sum;
            LOG.info("prod sum = " + sum);
        }
        LOG.info("prod tot = " + totProd);
        long totCons = executor.submit(new Consumer(queue)).get();
        LOG.info("cons tot = " + totCons);
        executor.shutdown();
        long runtime = System.currentTimeMillis() - start;
        LOG.info("queue finished after: {} ms", runtime);
    }
}

