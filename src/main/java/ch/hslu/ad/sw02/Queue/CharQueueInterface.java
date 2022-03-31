package ch.hslu.ad.sw02.Queue;

import java.util.NoSuchElementException;

/**
 * An ordered Collection which implements FirstIn-FirstOut semantic.
 */
public interface CharQueueInterface {

    /**
     * Adds the offered char at the end of the Queue.
     *
     * @param character which is offered
     * @throws IllegalStateException if the element cannot be added at this time due to capacity restrictions
     */
    void offer(final char character);

    /**
     * Pulls the char at the beginning of the Queue.
     *
     * @return {@code char} at the beginning
     * @throws NoSuchElementException if this queue is empty
     */
    char pull();

    /**
     * Returns how many char the Queue contains.
     *
     * @return the number of chars in the Queue.
     */
    int size();

    /**
     * Checks if the Queue is empty.
     *
     * @return {@code true} when the Queue is empty
     */
    boolean isEmpty();

    /**
     * Checks if the Queue is full.
     *
     * @return {@code true} when the Queue is full
     */
    boolean isFull();
}
