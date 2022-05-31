package ch.hslu.ad.sw13.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConnectionTest {

    @Test
    void testGetFrom() {
        Connection connection = new Connection(new Station("Luzern"), new Station("Basel"), 40);
        assertThat(connection.from()).isEqualTo(new Station("Luzern"));
    }

    @Test
    void testEqualsContract() {
        EqualsVerifier.forClass(Connection.class).verify();
    }
}