package ch.hslu.ad.sw04.Performance;

import ch.hslu.ad.sw02.stack.StringStack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public final class PerformanceTester {

    private static final Logger LOG = LogManager.getLogger(PerformanceTester.class);

    private static final int DATA_ARRAY_SIZE = 100_000;
    private static final int ITER = 1_000;

    public static void main(String[] args) {

        LOG.info("----------------------- Performance Test Stacks: DATA_SIZE = {}; ITER = {} -------------------", DATA_ARRAY_SIZE, ITER);
        long start = System.currentTimeMillis();
        String[] strings = MeasurementDataCreator.getStrings(DATA_ARRAY_SIZE);
        long end = System.currentTimeMillis();
        LOG.info("time to create data = {} ms", end - start); //~45ms

        start = System.nanoTime();
        for (int j = 0; j < ITER; j++) {
            Stack<String> javaStack = new Stack<>();
            javaStack.setSize(DATA_ARRAY_SIZE);
            for (int i = 0; i < DATA_ARRAY_SIZE; i++) {
                javaStack.push(strings[i]);
            }
        }
        end = System.nanoTime();
        LOG.info("time to fill java.util.Stack  = {} ms", (end - start) / (1000000d * ITER)); //~2ms

        start = System.nanoTime();
        for (int j = 0; j < ITER; j++) {
            StringStack ownStack = new StringStack(DATA_ARRAY_SIZE);
            for (int i = 0; i < DATA_ARRAY_SIZE; i++) {
                ownStack.push(strings[i]);
            }
        }
        end = System.nanoTime();
        LOG.info("time to fill own implementation of Stack  = {} ms", (end - start) / (1000000d * ITER)); //~0.3ms

        start = System.nanoTime();
        for (int j = 0; j < ITER; j++) {
            Deque<String> javaDeque = new ArrayDeque<>(DATA_ARRAY_SIZE);
            for (int i = 0; i < DATA_ARRAY_SIZE; i++) {
                javaDeque.push(strings[i]);
            }
        }
        end = System.nanoTime();
        LOG.info("time to fill java.util.Deque  = {} ms", (end - start) / (1000000d * ITER)); //~0.3ms

        LOG.info("------------------------------------ Performance Test finished -------------------------------------");
    }
}