package ch.hslu.ad.sw01.ackermann;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AckermannTest {

    private static final Logger LOG = LogManager.getLogger(Ackermann.class);

    @Test
    void testAckermann() {
        Ackermann ackermann = new Ackermann();
        assertThat(ackermann.ackermann(2,1)).isEqualTo(5);
    }
}