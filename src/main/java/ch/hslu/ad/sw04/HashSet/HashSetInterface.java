package ch.hslu.ad.sw04.HashSet;
/**
 * Implementation of a hashed Set.
 */
public interface HashSetInterface {
    /**
     * Adds a unique Integer in the HashSet.
     * @param value the Integer to add
     * @return {@code true} when the Integer was added, {@code false} when adding failed
     */
    boolean add(Integer value);

    /**
     * Removes an Integer from the HashSet.
     * @param value the Integer to remove
     * @return {@code true} when the Integer was removed, {@code false} when removing failed
     */
    boolean remove(Integer value);

    /**
     * Checks if an Integer is in the HashSet.
     * @param value the Integer to check
     * @return {@code true} when the Integer is in the HashSet.
     */
    boolean contains(Integer value);

    /**
     * Returns the Number of Integers in the HashSet.
     * @return the size
     */
    int size();
}
