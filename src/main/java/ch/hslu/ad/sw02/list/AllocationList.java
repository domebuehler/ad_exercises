package ch.hslu.ad.sw02.list;

import ch.hslu.ad.sw01_intro.Allocation;

public final class AllocationList {
    private Node head = null;
    private int listCount = 0;

    public int size() {
        return this.listCount;
    }

    //Exception-Handling z.B. bei Null oder leerer Liste!
    public void add(final Allocation allocation) {
        this.head = new Node(head, allocation);
        this.listCount++;
    }

    public void remove(final Allocation allocation) {
        if (isHeadToBeRemoved(allocation)) {
            pop();
        } else {
            removeOther(allocation);
        }
    }

    private boolean isHeadToBeRemoved(final Allocation allocation) {
        return allocation.equals(this.head.getContent());
    }

    /**
     * Hallo
     * @return
     */
    public Allocation pop() {
        Allocation allocationToBePopped = this.head.getContent();
        this.head = this.head.getNext();
        listCountDekrement();
        return allocationToBePopped;
    }

    private void removeOther(Allocation allocation) {
        AllocationListIterator iterator = this.iterator();
        while (iterator.hasNext()) {
            Allocation currentAlloc = iterator.next();
            if (currentAlloc.equals(allocation)) {
                iterator.remove();
                listCountDekrement();
            }
        }
    }

    private void listCountDekrement() {
        this.listCount--;
    }

    public boolean contains(final Allocation allocation) {
        AllocationListIterator iterator = this.iterator();
        while (iterator.hasNext()) {
            Allocation currentAlloc = iterator.next();
            if (currentAlloc.equals(allocation)) {
                return true;
            }
        }
        return false;
    }

    public AllocationListIterator iterator() {
        return new AllocationListIterator(this.head);
    }

    public String printList() {
        String printString = "AllocationList: ";
        AllocationListIterator iterator = this.iterator();
        while (iterator.hasNext()) {
            printString += iterator.next().toString() + " ;";
        }
        return printString;
    }
}
