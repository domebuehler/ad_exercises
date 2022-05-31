package ch.hslu.ad.sw13.list;

import ch.hslu.ad.sw13.model.Connection;
import ch.hslu.ad.sw13.model.RailwayNetInterface;
import ch.hslu.ad.sw13.model.Station;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class RailwayNetWithList implements RailwayNetInterface {

    private int numberOfNodes;
    private int numberOfConnections;
    private List<List<Connection>> stationList = new LinkedList<>();

    @SuppressWarnings("DuplicatedCode")
    public static RailwayNetInterface createForRotkreuz() {
        RailwayNetInterface railwayNet = new RailwayNetWithList();
        railwayNet.addStation(new Station("Luzern"));
        railwayNet.addStation(new Station("Rotkreuz"));
        railwayNet.addStation(new Station("Zug"));
        railwayNet.addStation(new Station("Arth-Goldau"));
        railwayNet.addConnection(new Connection(new Station("Luzern"), new Station("Rotkreuz"), 16));
        railwayNet.addConnection(new Connection(new Station("Luzern"), new Station("Arth-Goldau"), 30));
        railwayNet.addConnection(new Connection(new Station("Rotkreuz"), new Station("Arth-Goldau"), 15));
        railwayNet.addConnection(new Connection(new Station("Rotkreuz"), new Station("Zug"), 12));
        railwayNet.addConnection(new Connection(new Station("Zug"), new Station("Arth-Goldau"), 20));
        return railwayNet;
    }

    @Override
    public void addStation(Station station) {
        Connection stationAsConnectionToItself = new Connection(station, station, 0);
        for (List<Connection> list : stationList) {
            if (list.indexOf(stationAsConnectionToItself) == 0) {
                throw new IllegalArgumentException("stations exists all ready!");
            }
        }
        List<Connection> node = new LinkedList<>();
        node.add(stationAsConnectionToItself);
        stationList.add(node);
        numberOfNodes++;
    }

    @Override
    public void removeStation(Station station) {
        Connection stationAsConnectionToItself = new Connection(station, station, 0);
        for (List<Connection> list : stationList) {
            if (list.indexOf(stationAsConnectionToItself) == 0) {
                stationList.remove(list);
                numberOfNodes--;
            }
        }
    }

    @Override
    public void addConnection(Connection connection) {
        for (List<Connection> list : stationList) {
            if (list.get(0).from().equals(connection.from())) {
                if (list.contains(connection)) {
                    throw new IllegalArgumentException("connection is all ready there!");
                }
                list.add(connection);
                numberOfConnections++;
            }
            if (list.get(0).to().equals(connection.to())) {
                if (list.contains(connection)) {
                    throw new IllegalArgumentException("connection is all ready there!");
                }
                list.add(new Connection(connection.to(), connection.from(), connection.travelTime()));
                numberOfConnections++;
            }
        }
    }

    @Override
    public void removeConnection(Connection connection) {
        for (List<Connection> list : stationList) {
            if (list.get(0).from().equals(connection.from())) {
                list.remove(connection);
                numberOfConnections--;
            }
            if (list.get(0).to().equals(connection.to())) {
                list.remove(new Connection(connection.to(), connection.from(), connection.travelTime()));
                numberOfConnections--;
            }
        }
    }

    @Override
    public int getNumberOfStations() {
        return numberOfNodes;
    }

    @Override
    public int getNumberOfConnections() {
        return numberOfConnections;
    }

    @Override
    public boolean isDirectConnectionBetween(Station start, Station destination) {
        return getTravelTimeForDirectConnection(start, destination) > 0;
    }

    @Override
    public List<Connection> getDirectConnectionsFrom(Station start) {
        for (List<Connection> list : stationList) {
            if (list.get(0).from().equals(start)) {
                List<Connection> directConnectionsFromStart = new LinkedList<>(list);
                directConnectionsFromStart.remove(new Connection(start, start, 0));
                return directConnectionsFromStart;
            }
        }
        return Collections.emptyList();
    }

    @Override
    public int getTravelTimeForDirectConnection(Station start, Station destination) {
        for (List<Connection> list : stationList) {
            if (list.get(0).equals(new Connection(start, start, 0))) {
                for (Connection connection : list) {
                    if (connection.from().equals(start) && connection.to().equals(destination)) {
                        return connection.travelTime();
                    }
                }
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "RailwayNetWithList{" +
                "\nnumberOfNodes=" + numberOfNodes +
                "\nnumberOfConnections=" + numberOfConnections +
                "\nstationList=" + stationListToString() +
                '}';
    }

    private String stationListToString() {
        String string = "";
        for (List<Connection> list : stationList) {
            string += list.toString() + "\n";
        }
        return string;
    }
}
