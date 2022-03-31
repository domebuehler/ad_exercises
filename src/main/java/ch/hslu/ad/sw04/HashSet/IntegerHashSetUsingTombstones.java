package ch.hslu.ad.sw04.HashSet;

import java.util.Arrays;

public final class IntegerHashSetUsingTombstones implements HashSetInterface {

    private final static int STATIC_SIZE = 10;
    private final static int TOMBSTONE = 999_999_999;
    private final int[] values = new int[STATIC_SIZE];
    private int size = 0;
    private int tombstoneCounter = 0;
    private int foundAtIndex;

    @Override
    public boolean add(final Integer value) {
        if (!this.contains(value) && isThereSpace()) {
            addToIndex(value);
            this.size++;
            return true;
        } else {
            return false;
        }
    }

    private void addToIndex(final Integer value) {
        int indexToAdd = calculateIndex(value);
        if (this.values[indexToAdd] != 0) {
            indexToAdd = getNextFreeIndex(indexToAdd);
        }
        this.values[indexToAdd] = value;
    }

    private static int calculateIndex(final Integer value) {
        return Math.abs(Integer.hashCode(value) % STATIC_SIZE);
    }

    private int getNextFreeIndex(Integer indexToAdd) {
        while (this.values[indexToAdd] != 0) {
            indexToAdd = (indexToAdd + 1) % STATIC_SIZE;
        }
        return indexToAdd;
    }

    @Override
    public boolean remove(final Integer value) {
        if (this.contains(value)) {
            int indexToRemove = calculateIndex(value);
            if (this.values[indexToRemove] != value) {
                indexToRemove = this.foundAtIndex;
            }
            this.values[indexToRemove] = TOMBSTONE;
            this.size--;
            this.tombstoneCounter++;
            return true;
        } else {
            return false;
        }
    }

    private int searchForIndex(final Integer value, int index) {
        boolean found = false;
        int loopCounter = 0;
        while (!found && loopCounter < STATIC_SIZE) {
            loopCounter++;
            index = (index + 1) % STATIC_SIZE;
            if (this.values[index] == value) {
                found = true;
                this.foundAtIndex = index;
            }
        }
        return index;
    }

    @Override
    public boolean contains(final Integer value) {
        int indexToSearch = calculateIndex(value);
        if (this.values[indexToSearch] == value) {
            return true;
        } else if (this.values[indexToSearch] != 0) {
            int otherIndex = searchForIndex(value, indexToSearch);
            return otherIndex != indexToSearch;
        } else {
            return false;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        return "IntegerHashSetUsingTombstones{" +
                "values=" + Arrays.toString(values) +
                ", size=" + size +
                '}';
    }

    public boolean isThereSpace() {
        return this.size + this.tombstoneCounter < STATIC_SIZE;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
}