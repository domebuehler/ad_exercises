package ch.hslu.ad.sw09.heap;

import java.util.Arrays;
import java.util.NoSuchElementException;

public final class FixedSizeHeap implements IntegerHeap {

    private final int[] heap;
    private int firstFreeIndex = 0;
    private final int STATIC_SIZE;

    public FixedSizeHeap(final int size) {
        this.heap = new int[size];
        STATIC_SIZE = size;
    }

    @Override
    public int getMax() {
        if (this.firstFreeIndex == 0) {
            throw new NoSuchElementException("Heap is empty!");
        }
        int max = this.heap[0];
        this.heap[0] = this.heap[firstFreeIndex - 1];
        this.heap[firstFreeIndex - 1] = 0;
        sink(0);
        this.firstFreeIndex--;
        return max;
    }

    private void sink(final int index) {
        int indexOfLeftChild = (2 * index) + 1;
        int indexOfRightChild = 2 * (index + 1);
        if (indexOfLeftChild > STATIC_SIZE - 1 || indexOfRightChild > STATIC_SIZE - 1) {
            return;
        }
        if (this.heap[indexOfLeftChild] > this.heap[indexOfRightChild] &&
                this.heap[indexOfLeftChild] > this.heap[index]) {
            exchange(indexOfLeftChild, index);
            sink(indexOfLeftChild);
        } else if (this.heap[indexOfRightChild] > this.heap[indexOfLeftChild] &&
                this.heap[indexOfRightChild] > this.heap[index]) {
            exchange(indexOfRightChild, index);
            sink(indexOfRightChild);
        }
    }

    @Override
    public void insert(int toInsert) {
        if (this.firstFreeIndex == STATIC_SIZE) {
            throw new ArrayIndexOutOfBoundsException("Heap is all ready full!");
        }
        this.heap[firstFreeIndex] = toInsert;
        if (this.firstFreeIndex != 0) {
            climb(this.firstFreeIndex);
        }
        this.firstFreeIndex++;
    }

    private void climb(final int index) {
        int indexOfFather = (index - 1) / 2;
        if (this.heap[indexOfFather] < this.heap[index]) {
            exchange(indexOfFather, index);
            climb(indexOfFather);
        }
    }

    private void exchange(final int first, final int second) {
        int temp = this.heap[second];
        this.heap[second] = this.heap[first];
        this.heap[first] = temp;
    }

    @Override
    public String toString() {
        return "FixedSizeHeap{" +
                "heap=" + Arrays.toString(heap) +
                ", STATIC_SIZE=" + STATIC_SIZE +
                '}';
    }

    public int size(){
        return this.firstFreeIndex;
    }

    public int getIntAtIndex(final int index){
        if (index >= STATIC_SIZE) {
            throw new ArrayIndexOutOfBoundsException("This index is to to high");
        }
        return this.heap[index];
    }
}
