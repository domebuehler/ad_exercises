package ch.hslu.ad.sw04.GenericHashSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;

class HashSetUsingBucketListTest {

    private static final Logger LOG = LogManager.getLogger(HashSetUsingBucketListTest.class);

    @Test
    void testConstruction() {
        HashSetUsingBucketList<Integer> hashSet = new HashSetUsingBucketList<>();
        assertThat(hashSet.isEmpty()).isTrue();
    }

    @Test
    void testAddWithSoftAssertion() {
        HashSetUsingBucketList<Integer> hashSet = new HashSetUsingBucketList<>();
        hashSet.add(111);
        hashSet.add(222);
        hashSet.add(333);

        SoftAssertions.assertSoftly(softAssertions -> {
            assertThat(hashSet.contains(111)).isTrue();
            assertThat(hashSet.contains(222)).isTrue();
            assertThat(hashSet.contains(333)).isTrue();
            assertThat(hashSet.size()).isEqualTo(3);
        });
    }

    @Test
    void testAddWithAssertAll() {
        HashSetUsingBucketList<Integer> hashSet = new HashSetUsingBucketList<>();
        hashSet.add(444);
        hashSet.add(555);
        hashSet.add(666);
        assertAll(
                () -> assertThat(hashSet.contains(444)).isTrue(),
                () -> assertThat(hashSet.contains(555)).isTrue(),
                () -> assertThat(hashSet.contains(666)).isTrue(),
                () -> assertThat(hashSet.size()).isEqualTo(3)
        );
    }

    @Test
    void testAddingWithCollision() {
        HashSetUsingBucketList<Integer> hashSet = new HashSetUsingBucketList<>();
        hashSet.add(7);
        hashSet.add(17);
        hashSet.add(77);

        assertAll(
                () -> assertThat(hashSet.contains(77)).isTrue(),
                () -> assertThat(hashSet.contains(17)).isTrue(),
                () -> assertThat(hashSet.contains(17)).isTrue(),
                () -> assertThat(hashSet.size()).isEqualTo(3)
        );
    }

    @Test
    void testAddingOnFullRange() {
        HashSetUsingBucketList<Integer> hashSet = new HashSetUsingBucketList<>();
        int value = 100;
        for (int i = 0; i < 10; i++) {
            hashSet.add(value + i);
        }
        assertThat(hashSet.size()).isEqualTo(10);
        LOG.info(hashSet);
    }

    @Test
    void testAddNullFails() {
        HashSetUsingBucketList<Integer> hashSet = new HashSetUsingBucketList<>();
        assertFalse(hashSet.add(null));
    }

    @Test
    void testAddFailsWhenAllReadyInHashSet() {
        HashSetUsingBucketList<Integer> hashSet = new HashSetUsingBucketList<>();
        hashSet.add(888);
        assertFalse(hashSet.add(888));
    }
}