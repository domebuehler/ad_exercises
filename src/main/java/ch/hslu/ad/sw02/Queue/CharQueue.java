package ch.hslu.ad.sw02.Queue;

import java.util.Arrays;
import java.util.NoSuchElementException;

public final class CharQueue implements CharQueueInterface {

    private static final int SPACES_IN_QUEUE = 8;
    private static final int MAX_VALID_INDEX = SPACES_IN_QUEUE - 1;

    private int headIndex = 0;
    private int tailIndex = 0;
    private int numberOfChars = 0;
    private final char[] chars = new char[SPACES_IN_QUEUE];

    @Override
    public void offer(final char character) {
        if (!this.isFull()) {
            this.chars[tailIndex] = character;
            this.numberOfChars++;
            estimateNextTailIndex();
        } else {
            throw new IllegalStateException("char cannot be added to CharQueue due to capacity restrictions");
        }
    }

    private void estimateNextTailIndex() {
        if (this.tailIndex < MAX_VALID_INDEX) {
            this.tailIndex++;
        } else {
            this.tailIndex = 0;
        }
    }

    @Override
    public char pull() {
        if (!this.isEmpty()) {
            char pulled = this.chars[this.headIndex];
            this.chars[this.headIndex] = ' ';
            this.numberOfChars--;
            estimateNextHeadIndex();
            return pulled;
        } else {
            throw new NoSuchElementException("The Queue is empty");
        }
    }

    private void estimateNextHeadIndex() {
        if (this.headIndex < MAX_VALID_INDEX) {
            this.headIndex++;
        } else {
            this.headIndex = 0;
        }
    }

    @Override
    public int size() {
        return this.numberOfChars;
    }

    @Override
    public boolean isEmpty() {
        return this.numberOfChars == 0;

    }

    @Override
    public boolean isFull() {
        return this.numberOfChars == SPACES_IN_QUEUE;
    }

    @Override
    public String toString() {
        return "Queue{" +
                "headIndex=" + headIndex +
                ", tailIndex=" + tailIndex +
                ", numberOfChars=" + numberOfChars +
                ", chars=" + Arrays.toString(chars) +
                '}';
    }
}
