package ch.hslu.ad.sw02.list;

import ch.hslu.ad.sw01_intro.Allocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AllocationListTest {

    private static final Logger LOG = LogManager.getLogger(AllocationListTest.class);

    private final Allocation testAlloc1 = new Allocation(10, 0);
    private final Allocation testAlloc2 = new Allocation(15, 10);
    private final Allocation testAlloc3 = new Allocation(20, 25);
    private final Allocation testAlloc4 = new Allocation(10, 45);
    private final Allocation testAlloc5 = new Allocation(15, 55);

    @Test
    void testAddOneElement() {
        AllocationList list = new AllocationList();
        list.add(testAlloc1);

        assertThat(list.size()).isEqualTo(1);
    }

    @Test
    void testAddTwoElements() {
        AllocationList list = new AllocationList();
        list.add(testAlloc1);
        list.add(testAlloc2);

        assertThat(list.size()).isEqualTo(2);
    }

    @Test
    void testContainsTrue() {
        AllocationList list = new AllocationList();
        list.add(testAlloc1);
        list.add(testAlloc2);
        list.add(testAlloc3);

        assertThat(list.contains(testAlloc2)).isTrue();
    }

    @Test
    void testContainsFalse() {
        AllocationList list = new AllocationList();
        list.add(testAlloc1);
        list.add(testAlloc3);

        assertThat(list.contains(testAlloc2)).isFalse();
    }

    @Test
    void testPopCorrectObject() {
        AllocationList list = new AllocationList();
        list.add(testAlloc1);
        list.add(testAlloc2);
        list.add(testAlloc3);

        Allocation popped = list.pop();

        assertThat(popped).isEqualTo(testAlloc3);
    }

    @Test
    void testPopRemoveSuccessful() {
        AllocationList list = new AllocationList();
        list.add(testAlloc1);
        list.add(testAlloc2);
        list.add(testAlloc3);
        list.pop();

        AllocationListIterator iterator = list.iterator();
        int iteratorCounter = 0;
        while (iterator.hasNext()) {
            iteratorCounter++;
            iterator.next();
        }
        assertThat(iteratorCounter).isEqualTo(2);
    }

    @Test
    void testRemoveHead() {
        AllocationList list = new AllocationList();
        list.add(testAlloc1);
        list.add(testAlloc2);
        list.add(testAlloc3);
        LOG.info(list.printList());
        list.remove(testAlloc3);

        assertThat(list.contains(testAlloc3)).isFalse();
        assertThat(list.size()).isEqualTo(2);
        LOG.info(list.printList());
    }

    @Test
    void testRemoveTail() {
        AllocationList list = new AllocationList();
        list.add(testAlloc1);
        list.add(testAlloc2);
        list.add(testAlloc3);
        LOG.info(list.printList());
        list.remove(testAlloc1);

        assertThat(list.contains(testAlloc1)).isFalse();
        assertThat(list.size()).isEqualTo(2);
        LOG.info(list.printList());
    }

    @Test
    void testRemoveMiddleObject() {
        AllocationList list = new AllocationList();
        list.add(testAlloc1);
        list.add(testAlloc2);
        list.add(testAlloc3);
        LOG.info(list.printList());
        list.remove(testAlloc2);

        assertThat(list.contains(testAlloc2)).isFalse();
        assertThat(list.size()).isEqualTo(2);
        LOG.info(list.printList());
    }

    @Test
    void testRemoveObjectNotOnList() {
        AllocationList list = new AllocationList();
        list.add(testAlloc1);
        list.add(testAlloc2);
        list.add(testAlloc3);
        LOG.info(list.printList());
        list.remove(new Allocation(50, 50));

        assertThat(list.size()).isEqualTo(3);
        LOG.info(list.printList());
    }

    @Test
    void testRemoveMultiple() {
        AllocationList list = new AllocationList();
        list.add(testAlloc1);
        list.add(testAlloc2);
        list.add(testAlloc3);
        list.add(testAlloc4);
        list.add(testAlloc5);
        LOG.info(list.printList());

        list.remove(testAlloc3);
        list.remove(testAlloc1);

        assertThat(list.contains(testAlloc3)).isFalse();
        assertThat(list.contains(testAlloc1)).isFalse();
        assertThat(list.size()).isEqualTo(3);
        LOG.info(list.printList());
    }
}