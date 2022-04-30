package ch.hslu.ad.sw09.heap;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class FixedSizeHeapTest {

    @Test
    void testSize() {
        FixedSizeHeap heap = new FixedSizeHeap(10);
        heap.insert(20);
        heap.insert(10);
        heap.insert(5);
        heap.insert(12);
        heap.insert(7);
        heap.insert(50);
        assertThat(heap.size()).isEqualTo(6);
    }

    @Test
    void testGetMax() {
        FixedSizeHeap heap = new FixedSizeHeap(10);
        heap.insert(20);
        heap.insert(10);
        heap.insert(5);
        heap.insert(12);
        heap.insert(7);
        heap.insert(50);
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += heap.getMax();
        }
        int finalSum = sum;
        assertAll(
                () -> assertThat(finalSum).isEqualTo(82),
                () -> assertThat(heap.size()).isEqualTo(3)
        );
    }

    @Test
    void testGetMaxThrowsExceptionWhenEmpty() {
        FixedSizeHeap heap = new FixedSizeHeap(10);
        assertThatThrownBy(() -> heap.getMax()).
                isInstanceOf(NoSuchElementException.class).
                hasMessage("Heap is empty!");
    }

    @Test
    void testInsert() {
        FixedSizeHeap heap = new FixedSizeHeap(10);
        heap.insert(20);
        heap.insert(10);
        heap.insert(5);
        heap.insert(12);
        heap.insert(7);
        heap.insert(50);
        assertAll(
                () -> assertThat(heap.getIntAtIndex(0)).isEqualTo(50),
                () -> assertThat(heap.getIntAtIndex(1)).isEqualTo(12),
                () -> assertThat(heap.getIntAtIndex(2)).isEqualTo(20),
                () -> assertThat(heap.getIntAtIndex(3)).isEqualTo(10),
                () -> assertThat(heap.getIntAtIndex(4)).isEqualTo(7),
                () -> assertThat(heap.getIntAtIndex(5)).isEqualTo(5)
        );
    }

    @Test
    void testInsertThrowsExceptionWhenFull() {
        FixedSizeHeap heap = new FixedSizeHeap(10);
        for (int i = 0; i < 10; i++) {
            heap.insert(i);
        }
        assertThatThrownBy(() -> heap.insert(10)).
                isInstanceOf(ArrayIndexOutOfBoundsException.class).
                hasMessage("Heap is all ready full!");
    }

    @Test
    void testGetIndexAtThrowsExceptionWhenIndexToBig() {
        FixedSizeHeap heap = new FixedSizeHeap(10);
        assertThatThrownBy(() -> heap.getIntAtIndex(10)).
                isInstanceOf(ArrayIndexOutOfBoundsException.class).
                hasMessage("This index is to to high");
    }
}