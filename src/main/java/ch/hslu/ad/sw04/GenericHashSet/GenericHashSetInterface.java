package ch.hslu.ad.sw04.GenericHashSet;

public interface GenericHashSetInterface<T> {

    boolean add(T value);

    boolean remove(T value);

    boolean contains(T value);

    int size();
}
