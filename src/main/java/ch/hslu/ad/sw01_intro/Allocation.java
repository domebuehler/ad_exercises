package ch.hslu.ad.sw01_intro;

import java.util.Objects;

@SuppressWarnings("ClassCanBeRecord")
public final class Allocation implements Comparable<Allocation> {
    private final int size;
    private final int startAdress;

    public Allocation(int size, int startAdress) {
        this.size = size;
        this.startAdress = startAdress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Allocation)) {
            return false;
        }
        Allocation other = (Allocation) o;
        return Objects.equals(this.size, other.size) &&
                Objects.equals(this.startAdress, other.startAdress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.size, this.startAdress);
    }

    @Override
    public int compareTo(Allocation o) {
        if (o == null) {
            throw new NullPointerException();
        } else if (this.startAdress > o.startAdress) {
            return 1;
        } else if (this.startAdress < o.startAdress) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Allocation{" +
                "size=" + size +
                ", startAdress=" + startAdress +
                '}';
    }
}