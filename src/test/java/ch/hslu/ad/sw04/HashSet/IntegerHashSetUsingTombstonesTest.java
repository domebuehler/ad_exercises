package ch.hslu.ad.sw04.HashSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class IntegerHashSetUsingTombstonesTest {

    private static final Logger LOG = LogManager.getLogger(IntegerHashSetUsingTombstones.class);

    @Test
    void hashSetDemo() {
        IntegerHashSetUsingTombstones hashSetUsingTombstones = new IntegerHashSetUsingTombstones();
        hashSetUsingTombstones.add(1);
        hashSetUsingTombstones.add(11);
        hashSetUsingTombstones.add(111);
        hashSetUsingTombstones.add(9);
        hashSetUsingTombstones.add(99);
        assertThat(hashSetUsingTombstones.contains(1)).isTrue();
        assertThat(hashSetUsingTombstones.contains(11)).isTrue();
        assertThat(hashSetUsingTombstones.contains(111)).isTrue();
        assertThat(hashSetUsingTombstones.contains(9)).isTrue();
        assertThat(hashSetUsingTombstones.contains(99)).isTrue();
        LOG.info("after adding with probing: {}", hashSetUsingTombstones);
        hashSetUsingTombstones.remove(1);
        hashSetUsingTombstones.remove(11);
        hashSetUsingTombstones.remove(111);
        LOG.info("after removing -> Tombstone were set: {}", hashSetUsingTombstones);
        hashSetUsingTombstones.add(111);
        LOG.info("after adding again -> has to skip Tombstones: {}", hashSetUsingTombstones);
    }

    @Test
    void testAdd() {
        IntegerHashSetUsingTombstones hashSetUsingTombstones = new IntegerHashSetUsingTombstones();
        hashSetUsingTombstones.add(15);
        assertThat(hashSetUsingTombstones.contains(15)).isTrue();
    }

    @Test
    void testAddMultipleSameIndex() {
        IntegerHashSetUsingTombstones hashSetUsingTombstones = new IntegerHashSetUsingTombstones();
        hashSetUsingTombstones.add(1);
        hashSetUsingTombstones.add(11);
        hashSetUsingTombstones.add(111);
        assertThat(hashSetUsingTombstones.contains(1)).isTrue();
        assertThat(hashSetUsingTombstones.contains(11)).isTrue();
        assertThat(hashSetUsingTombstones.contains(111)).isTrue();
        assertThat(hashSetUsingTombstones.size()).isEqualTo(3);
    }

    @Test
    void testAddFailsWhenFull() {
        IntegerHashSetUsingTombstones hashSetUsingTombstones = new IntegerHashSetUsingTombstones();
        while (hashSetUsingTombstones.isThereSpace()) {
            hashSetUsingTombstones.add(new Random().nextInt());
        }
        boolean status = hashSetUsingTombstones.add(new Random().nextInt());
        assertThat(status).isFalse();
    }

    @Test
    void testAddFailsWhenAllReadyThere() {
        IntegerHashSetUsingTombstones hashSetUsingTombstones = new IntegerHashSetUsingTombstones();
        hashSetUsingTombstones.add(10);
        boolean status = hashSetUsingTombstones.add(10);
        assertThat(status).isFalse();
    }

    @Test
    void testRemove() {
        IntegerHashSetUsingTombstones hashSetUsingTombstones = new IntegerHashSetUsingTombstones();
        hashSetUsingTombstones.add(15);
        hashSetUsingTombstones.remove(15);
        assertThat(hashSetUsingTombstones.contains(15)).isFalse();
    }

    @Test
    void testRemoveFailsWhenNotThere() {
        IntegerHashSetUsingTombstones hashSetUsingTombstones = new IntegerHashSetUsingTombstones();
        hashSetUsingTombstones.add(15);
        boolean status = hashSetUsingTombstones.remove(25);
        assertThat(status).isFalse();
    }

    @Test
    void testRemoveFailsWhenEmpty() {
        IntegerHashSetUsingTombstones hashSetUsingTombstones = new IntegerHashSetUsingTombstones();
        boolean status = hashSetUsingTombstones.remove(20);
        assertThat(status).isFalse();
    }

    @Test
    void testRemoveMultipleWithSameIndex() {
        IntegerHashSetUsingTombstones hashSetUsingTombstones = new IntegerHashSetUsingTombstones();
        hashSetUsingTombstones.add(1);
        hashSetUsingTombstones.add(11);
        hashSetUsingTombstones.add(111);
        hashSetUsingTombstones.remove(111);
        hashSetUsingTombstones.remove(11);
        hashSetUsingTombstones.remove(1);
        assertThat(hashSetUsingTombstones.size()).isEqualTo(0);
    }

    @Test
    void testRemoveAllWhenFull() {
        IntegerHashSetUsingTombstones hashSetUsingTombstones = new IntegerHashSetUsingTombstones();
        int multiplicator = 2;
        int addingValue = 1;
        while (hashSetUsingTombstones.isThereSpace()) {
            hashSetUsingTombstones.add(addingValue);
            addingValue = addingValue * multiplicator;
        }

        addingValue = 1;
        int removeCount = 0;
        int expectedRemoveCount = hashSetUsingTombstones.size();
        while (!hashSetUsingTombstones.isEmpty()) {
            hashSetUsingTombstones.remove(addingValue);
            removeCount++;
            addingValue = addingValue * multiplicator;
        }
        assertThat(removeCount).isEqualTo(expectedRemoveCount);
        assertThat(hashSetUsingTombstones.add(23)).isFalse();
    }

    @Test
    void testToString() {
        IntegerHashSetUsingTombstones hashSetUsingTombstones = new IntegerHashSetUsingTombstones();
        hashSetUsingTombstones.add(1);
        hashSetUsingTombstones.add(11);
        hashSetUsingTombstones.add(111);
        String expected = "IntegerHashSetUsingTombstones{values=[0, 1, 11, 111, 0, 0, 0, 0, 0, 0], size=3}";
        assertThat(hashSetUsingTombstones.toString()).isEqualTo(expected);
    }
}