package ch.hslu.ad.sw02.stack;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class StringStack implements StringStackInterface{

    private int headIndex = 0;
    private int numberOfStrings = 0;
    private final String[] strings;
    private final int size;

    public StringStack(final int size) {
        this.strings = new String[size];
        this.size = size;
    }

    @Override
    public void push(final String stringToPush) {
        if (!this.full()) {
            this.strings[this.headIndex] = stringToPush;
            this.numberOfStrings++;
            this.headIndex++;
        } else {
            throw new StackOverflowError("Failed to add because Stack is full");
        }
    }

    @Override
    public String pop() {
        if (!this.empty()) {
            this.headIndex--;
            String popped = this.strings[this.headIndex];
            this.strings[this.headIndex] = null;
            this.numberOfStrings--;
            return popped;
        } else {
            throw new EmptyStackException();
        }
    }

    @Override
    public boolean empty() {
        return this.numberOfStrings == 0;
    }

    @Override
    public boolean full() {
        return this.numberOfStrings == this.size;
    }
}
