package ch.hslu.ad.sw13.model;

import java.util.Objects;

public record Connection(Station from, Station to, int travelTime) {

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Connection)) {
            return false;
        }
        Connection other = (Connection) o;
        return travelTime == other.travelTime && Objects.equals(from, other.from) && Objects.equals(to, other.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, travelTime);
    }

    @Override
    public String toString() {
        return "Connection{" +
                "from=" + from +
                ", to=" + to +
                ", travelTime=" + travelTime +
                '}';
    }
}
