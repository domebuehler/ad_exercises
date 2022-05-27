package ch.hslu.ad.sw13.matrix;

import java.util.List;
import java.util.Map;

public interface RailwayNet {
    void addStation(final Station station);
    void removeStation(final Station station);
    void addConnection(final Station start, final Station destination, final int travelTime);
    void removeConnection(final Station start, final Station destination);
    int getNumberOfStations();
    int getNumberOfConnections();
    boolean isDirectConnectionBetween(final Station start, final Station destination);
    List<Station> getDirectConnectionsFrom(final Station start);
    int getTravelTimeForDirectConnection(final Station start, final Station destination);
}
