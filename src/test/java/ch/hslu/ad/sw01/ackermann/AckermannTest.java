package ch.hslu.ad.sw01.ackermann;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class AckermannTest {

    private static final Logger LOG = LogManager.getLogger(Ackermann.class);

    @Disabled
    @Test
    void testAckermann() {
        Ackermann ackermann = new Ackermann();
        LOG.info(ackermann.ackermann(4, 1));
        LOG.info(ackermann.getCalls());
    }
}