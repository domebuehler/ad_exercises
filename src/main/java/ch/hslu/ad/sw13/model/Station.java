package ch.hslu.ad.sw13.model;

import java.util.Objects;

public record Station(String name) {

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Station)) {
            return false;
        }
        final Station station = (Station) o;
        return Objects.equals(this.name, station.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }
}
