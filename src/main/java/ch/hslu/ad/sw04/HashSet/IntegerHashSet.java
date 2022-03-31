package ch.hslu.ad.sw04.HashSet;

import java.util.Arrays;

public final class IntegerHashSet implements HashSetInterface {
    private final static int STATIC_SIZE = 10;

    private final Integer[] values = new Integer[STATIC_SIZE];
    private int size = 0;

    @Override
    public boolean add(final Integer value) {
        if (!this.contains(value) && this.isNotFull()) {
            return this.addToIndex(value);
        } else {
            return false;
        }
    }

    private boolean addToIndex(final Integer value) {
        int indexToAdd = calculateIndex(value);
        if (this.values[indexToAdd] == null) {
            this.values[indexToAdd] = value;
            this.size++;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean remove(final Integer value) {
        if (this.contains(value)) {
            int indexToRemove = calculateIndex(value);
            this.values[indexToRemove] = null;
            this.size--;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean contains(final Integer value) {
        int indexToCheck = calculateIndex(value);
        if (this.values[indexToCheck] != null) {
            return this.values[indexToCheck].equals(value);
        } else {
            return false;
        }
    }

    private static int calculateIndex(final Integer value) {
        return Math.abs(Integer.hashCode(value) % STATIC_SIZE);
    }

    public boolean isNotFull() {
        return this.size != STATIC_SIZE;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        return "IntegerHashSet{" +
                "values=" + Arrays.toString(values) +
                ", size=" + size +
                '}';
    }
}
