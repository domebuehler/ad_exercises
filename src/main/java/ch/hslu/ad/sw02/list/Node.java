package ch.hslu.ad.sw02.list;

import ch.hslu.ad.sw01_intro.Allocation;

import java.util.Objects;

public final class Node {
    private Node next;
    private Allocation content;

    public Node(final Node next, final Allocation content) {
        this.next = next;
        this.content = content;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Allocation getContent() {
        return content;
    }

    public void setContent(Allocation content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Node)) {
            return false;
        }
        Node other = (Node) o;
        return Objects.equals(this.next, other.next) && Objects.equals(this.content, other.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.next, this.content);
    }
}
