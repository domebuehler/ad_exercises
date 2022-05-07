package ch.hslu.ad.sw10.quicksort;

import ch.hslu.ad.sw10.array.init.RandomInitTask;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ForkJoinPool;

import static org.assertj.core.api.Assertions.assertThat;

class QuicksortTaskTest {

    @Test
    void testParallelQuickSort() {
        final int size = 30_00_000;
        final int[] array = new int[size];
        final ForkJoinPool pool = new ForkJoinPool();
        RandomInitTask initTask = new RandomInitTask(array, 100_000);
        pool.invoke(initTask);
        final QuicksortTask sortTask = new QuicksortTask(array);
        pool.invoke(sortTask);

        assertThat(array).isSorted();
    }
}