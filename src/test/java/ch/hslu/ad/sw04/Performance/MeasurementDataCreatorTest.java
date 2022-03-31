package ch.hslu.ad.sw04.Performance;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class MeasurementDataCreatorTest {

    private static final Logger LOG = LogManager.getLogger(MeasurementDataCreatorTest.class);

    @Test
    void testGetStrings() {
        String[] strings = MeasurementDataCreator.getStrings(10);
        LOG.info(Arrays.toString(strings));
        assertThat(strings.length).isEqualTo(10);
    }
}