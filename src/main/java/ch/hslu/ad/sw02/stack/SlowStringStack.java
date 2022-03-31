package ch.hslu.ad.sw02.stack;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public final class SlowStringStack implements StringStackInterface {

    private final String[] strings;
    private final int size;
    private int numberOfStrings = 0;

    public SlowStringStack(final int size) {
        this.strings = new String[size + 1];
        this.size = size;
    }

    @Override
    public void push(final String stringToPush) {
        if (!this.full()) {
            shiftOneToTheRight();
            this.strings[0] = stringToPush;
            this.numberOfStrings++;
        } else {
            throw new StackOverflowError("Failed to add because Stack is full");
        }
    }

    private void shiftOneToTheRight() {
        int indexToShift = this.numberOfStrings - 1;
        int newIndex = indexToShift + 1;
        for (int i = 0; i < this.numberOfStrings; i++) {
            this.strings[newIndex] = this.strings[indexToShift];
            newIndex--;
            indexToShift--;
        }
    }

    @Override
    public String pop() {
        if (!this.empty()) {
            String popped = this.strings[0];
            shiftOneToTheLeft();
            this.numberOfStrings--;
            return popped;
        } else {
            throw new EmptyStackException();
        }
    }

    private void shiftOneToTheLeft() {
        int indexToShift = 1;
        int newIndex = 0;
        for (int i = 0; i < this.numberOfStrings; i++) {
            this.strings[newIndex] = this.strings[indexToShift];
            indexToShift++;
            newIndex++;
        }
    }

    @Override
    public boolean empty() {
        return this.numberOfStrings == 0;
    }

    @Override
    public boolean full() {
        return this.size == this.numberOfStrings;
    }

    @Override
    public String toString() {
        String representation = "StringStack{strings=[";
        for (int i = 0; i < this.numberOfStrings; i++) {
            if (i != 0) {
                representation += ", ";
            }
            representation += this.strings[i];
        }
        representation += "], size=" + size + ", numberOfStrings=" + numberOfStrings + "}";
        return representation;
    }
}