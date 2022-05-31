package ch.hslu.ad.sw13.list;

import ch.hslu.ad.sw13.model.Connection;
import ch.hslu.ad.sw13.model.RailwayNetInterface;
import ch.hslu.ad.sw13.model.Station;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RailwayNetWithListTest {

    @Test
    void testIsDirectConnectionBetween() {
        RailwayNetInterface railwayNet = RailwayNetWithList.createForRotkreuz();
        assertThat(railwayNet.isDirectConnectionBetween(new Station("Rotkreuz"), new Station("Zug"))).isTrue();
    }

    @Test
    void testGetTravelTimeForDirectConnection() {
        RailwayNetInterface railwayNet = RailwayNetWithList.createForRotkreuz();
        assertThat(railwayNet.getTravelTimeForDirectConnection(new Station("Rotkreuz"), new Station("Zug"))).isEqualTo(12);
    }

    @Test
    void testGetDirectConnectionsBetween() {
        RailwayNetInterface railwayNet = RailwayNetWithList.createForRotkreuz();
        List<Connection> connections = railwayNet.getDirectConnectionsFrom(new Station("Luzern"));
        assertAll(
                () -> assertThat(connections).contains(
                        new Connection(new Station("Luzern"), new Station("Rotkreuz"), 16),
                        new Connection(new Station("Luzern"), new Station("Arth-Goldau"), 30)),
                () -> assertThat(connections).doesNotContain(
                        new Connection(new Station("Luzern"), new Station("Luzern"), 10)));
    }
}