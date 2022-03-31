package ch.hslu.ad.sw02.list;

import ch.hslu.ad.sw01_intro.Allocation;

public final class AllocationListIterator {

    private Node current;
    private Node previous = null;
    private boolean iteratorStart;

    public AllocationListIterator(final Node head) {
        this.current = head;
        this.iteratorStart = true;
    }

    public Allocation next() {
        if (!iteratorStart) {
            this.previous = this.current;
            this.current = current.getNext();
        } else {
            this.iteratorStart = false;
        }
        return this.current.getContent();
    }

    public boolean hasNext() {
        return this.current.getNext() != null;
    }

    public void remove() {
        this.previous.setNext(this.current.getNext());
    }
}
