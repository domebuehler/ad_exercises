package ch.hslu.ad.sw02.list;

import ch.hslu.ad.sw01_intro.Allocation;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AllocationListIteratorTest {

    private final Allocation testAlloc1 = new Allocation(10, 0);
    private final Allocation testAlloc2 = new Allocation(15, 10);
    private final Allocation testAlloc3 = new Allocation(20, 25);

    @Test
    void testHasNext() {
        AllocationList list = new AllocationList();
        list.add(testAlloc1);
        list.add(testAlloc2);
        list.add(testAlloc3);
        AllocationListIterator iterator = list.iterator();

        int nextCounter = 0;
        while (iterator.hasNext()) {
            iterator.next();
            nextCounter++;
        }
        assertThat(nextCounter).isEqualTo(3);
    }

    @Test
    void testNext() {
        AllocationList list = new AllocationList();
        list.add(testAlloc1);
        list.add(testAlloc2);
        list.add(testAlloc3);
        AllocationListIterator iterator = list.iterator();

        Allocation first = iterator.next();
        Allocation second = iterator.next();
        Allocation third = iterator.next();

        assertThat(first).isEqualTo(testAlloc3);
        assertThat(second).isEqualTo(testAlloc2);
        assertThat(third).isEqualTo(testAlloc1);
    }
}