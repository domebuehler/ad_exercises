package ch.hslu.ad.sw04.HashSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class IntegerHashSetTest {
    private static final Logger LOG = LogManager.getLogger(IntegerHashSetTest.class);

    @Test
    void add() {
        IntegerHashSet hashSet = new IntegerHashSet();
        hashSet.add(200);
        hashSet.contains(200);
        assertThat(hashSet.contains(200)).isTrue();
    }

    @Test
    void addWhenAllReadyThere() {
        IntegerHashSet hashSet = new IntegerHashSet();
        hashSet.add(10);
        boolean success = hashSet.add(10);
        assertThat(success).isFalse();
    }

    @Test
    void addMultipleFirstJunitAndAssertJ() {
        IntegerHashSet hashSet = new IntegerHashSet();
        hashSet.add(6545);
        hashSet.add(403);
        hashSet.add(4540);

        assertAll(
                () -> assertThat(hashSet.contains(6545)).isTrue(),
                () -> assertThat(hashSet.contains(403)).isTrue(),
                () -> assertThat(hashSet.contains(4540)).isTrue()
        );
    }

    @Test
    void addMultipleFirstAssertJ1() {
        IntegerHashSet hashSet = new IntegerHashSet();
        hashSet.add(6545);
        hashSet.add(323);
        hashSet.add(4540);

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(hashSet.contains(6545)).isTrue();
            softly.assertThat(hashSet.contains(323)).isTrue();
            softly.assertThat(hashSet.contains(4540)).isTrue();
        });
    }

    @Test
    void addMultipleFirstAssertJ2() {
        IntegerHashSet hashSet = new IntegerHashSet();
        hashSet.add(6545);
        hashSet.add(403);
        hashSet.add(4540);

        SoftAssertions assertionPackage = new SoftAssertions();
        assertionPackage.assertThat(hashSet.contains(6545)).isTrue();
        assertionPackage.assertThat(hashSet.contains(403)).isTrue();
        assertionPackage.assertThat(hashSet.contains(4540)).isTrue();
        assertionPackage.assertAll();
    }

    @Test
    void testAddWhenIsFull() {
        IntegerHashSet hashSet = new IntegerHashSet();
        while (hashSet.isNotFull()) {
            hashSet.add(new Random().nextInt());
            LOG.info(hashSet);
        }
        boolean success = hashSet.add(new Random().nextInt());
        assertThat(success).isFalse();
        assertThat(hashSet.size()).isEqualTo(10);
    }

    @Test
    void remove() {
        IntegerHashSet hashSet = new IntegerHashSet();
        hashSet.add(10);
        hashSet.remove(10);
        assertThat(hashSet.contains(10)).isFalse();
    }

    @Test
    void removeWhenNotThere() {
        IntegerHashSet hashSet = new IntegerHashSet();
        hashSet.add(10);
        boolean success = hashSet.remove(500);
        assertThat(success).isFalse();
    }

    @Test
    void removeWhenIsEmpty() {
        IntegerHashSet hashSet = new IntegerHashSet();
        boolean success = hashSet.remove(500);
        assertThat(success).isFalse();
    }
}