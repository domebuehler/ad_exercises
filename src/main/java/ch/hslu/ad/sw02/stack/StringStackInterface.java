package ch.hslu.ad.sw02.stack;

import java.util.NoSuchElementException;

/**
 * An ordered Collection of Strings implemented as a Stack with the FirstIn-LastOut semantic.
 */
public interface StringStackInterface {

    /**
     * Adds a String on the StringStack.
     * @param stringToPush the String to add on the StringStack
     * @throws StackOverflowError if the stack is full
     */
    void push(final String stringToPush);

    /**
     * Returns the String on top of the StringStack.
     * @return {@code String} on top of the StringStack
     * @throws java.util.EmptyStackException if the Stack is empty
     */
    String pop();
    /**
     * Checks if the StringStack is empty.
     * @return {@code true} if StringStack is empty
     */
    boolean empty();

    /**
     * Checks if the StringStack is full.
     * @return {@code true} if StringStack is full
     */
    boolean full();
}
