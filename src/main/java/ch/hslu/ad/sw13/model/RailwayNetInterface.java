package ch.hslu.ad.sw13.model;

import java.util.List;

public interface RailwayNetInterface {
    void addStation(final Station station);

    void removeStation(final Station station);

    void addConnection(final Connection connection);

    void removeConnection(final Connection connection);

    int getNumberOfStations();

    int getNumberOfConnections();

    boolean isDirectConnectionBetween(final Station start, final Station destination);

    List<Station> getDirectConnectionsFrom(final Station start);

    int getTravelTimeForDirectConnection(final Station start, final Station destination);
}
