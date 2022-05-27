package ch.hslu.ad.sw13.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class RailwayNetImplementation implements RailwayNet {

    private int numberOfNodes = 0;
    private int numberOfConnections = 0;
    private final List<Station> stations = new ArrayList<>();
    private int[][] matrix;

    public static RailwayNet createForRotkreuz() {
        RailwayNet railwayNet = new RailwayNetImplementation();
        railwayNet.addStation(new Station("Luzern"));
        railwayNet.addStation(new Station("Rotkreuz"));
        railwayNet.addStation(new Station("Zug"));
        railwayNet.addStation(new Station("Arth-Goldau"));
        railwayNet.addConnection(new Station("Luzern"), new Station("Rotkreuz"), 16);
        railwayNet.addConnection(new Station("Luzern"), new Station("Arth-Goldau"), 30);
        railwayNet.addConnection(new Station("Rotkreuz"), new Station("Arth-Goldau"), 15);
        railwayNet.addConnection(new Station("Rotkreuz"), new Station("Zug"), 12);
        railwayNet.addConnection(new Station("Zug"), new Station("Arth-Goldau"), 20);
        return railwayNet;
    }

    @Override
    public void addStation(final Station station) {
        if (this.stations.contains(station)) {
            throw new IllegalArgumentException("Station all ready exists");
        }
        this.stations.add(station);
        this.numberOfNodes = this.stations.size();
        copyMatrix();
    }

    @Override
    public void removeStation(Station station) {
        throw new UnsupportedOperationException(); // TODO: 27.05.2022  
    }

    private void copyMatrix() {
        int[][] newMatrix = new int[this.numberOfNodes][this.numberOfNodes];
        for (int i = 0; i < this.numberOfNodes - 1; i++) {
            System.arraycopy(this.matrix[i], 0, newMatrix[i], 0, this.numberOfNodes - 1);
        }
        this.matrix = newMatrix;
    }

    @Override
    public void addConnection(final Station start, final Station destination, final int travelTime) {
        if (!(this.stations.contains(start) && this.stations.contains(destination))) {
            throw new IllegalArgumentException("Stations are not valid");
        }
        int indexStart = this.stations.indexOf(start);
        int indexDestination = this.stations.indexOf(destination);
        this.matrix[indexStart][indexDestination] = travelTime;
        this.matrix[indexDestination][indexStart] = travelTime;
        this.numberOfConnections += 2;
    }

    @Override
    public void removeConnection(final Station start, final Station destination) {
        if (!(this.stations.contains(start) && this.stations.contains(destination))) {
            throw new IllegalArgumentException("Stations are not valid");
        }
        int indexStart = this.stations.indexOf(start);
        int indexDestination = this.stations.indexOf(destination);
        this.matrix[indexStart][indexDestination] = 0;
        this.matrix[indexDestination][indexStart] = 0;
        this.numberOfConnections -= 2;
    }

    @Override
    public int getNumberOfStations() {
        return this.numberOfNodes;
    }

    @Override
    public int getNumberOfConnections() {
        return this.numberOfConnections;
    }

    @Override
    public boolean isDirectConnectionBetween(final Station start, final Station destination) {
        if (!(this.stations.contains(start) && this.stations.contains(destination))) {
            throw new IllegalArgumentException("Stations are not valid");
        }
        int indexStart = this.stations.indexOf(start);
        int indexDestination = this.stations.indexOf(destination);
        return this.matrix[indexStart][indexDestination] != 0;
    }

    @Override
    public List<Station> getDirectConnectionsFrom(final Station start) {
        throw new UnsupportedOperationException(); // TODO: 27.05.2022  
    }

    @Override
    public int getTravelTimeForDirectConnection(final Station start, final Station destination) {
        if (!(this.stations.contains(start) && this.stations.contains(destination))) {
            throw new IllegalArgumentException("Stations are not valid");
        }
        int indexStart = this.stations.indexOf(start);
        int indexDestination = this.stations.indexOf(destination);
        return this.matrix[indexStart][indexDestination];
    }

    @Override
    public String toString() {
        return "RailwayNetImplementation:\n" +
                "numberOfNodes=" + numberOfNodes +
                "\nstations=" + stations +
                "\nmatrix=" + Arrays.deepToString(matrix) +
                '}';
    }
}
