package ch.hslu.ad.sw04.GenericHashSet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

public final class HashSetUsingBucketList<T> implements GenericHashSetInterface<T> {

    private static final int STATIC_SIZE = 10;
    private final ArrayList<LinkedList<T>> lists = new ArrayList<>();
    private int size;

    public HashSetUsingBucketList() {
        for (int i = 0; i < STATIC_SIZE; i++) {
            this.lists.add(new LinkedList<>());
        }
    }

    @Override
    public boolean add(T value) {
        if (value != null && !this.contains(value)) {
            addToIndex(value);
            this.size++;
            return true;
        } else {
            return false;
        }
    }

    private void addToIndex(T value) {
        int indexToAdd = this.calculateIndex(value);
        this.lists.get(indexToAdd).add(value);
    }

    @Override
    public boolean remove(T value) {
        if (this.contains(value)) {
            removeValueOfIndex(value);
            this.size--;
            return true;
        }
        return false;
    }

    private void removeValueOfIndex(T value) {
        int indexToRemove = this.calculateIndex(value);
        this.lists.get(indexToRemove).remove(value);
    }

    @Override
    public boolean contains(T value) {
        int indexToCheck = this.calculateIndex(value);
        if (this.lists.get(indexToCheck) != null) {
            return this.lists.get(indexToCheck).contains(value);
        }
        return false;
    }

    private int calculateIndex(T value) {
        return Math.abs(Objects.hashCode(value) % STATIC_SIZE);
    }

    @Override
    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public String toString() {
        return "HashSetUsingBucketList{" +
                ", lists=" + lists +
                ", size=" + size +
                '}';
    }
}
