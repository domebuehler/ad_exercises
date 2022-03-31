package ch.hslu.ad.sw02.list;

import ch.hslu.ad.sw01_intro.Allocation;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NodeTest {

    @Test
    void testGetAndSetNext() {
        Allocation alloc = new Allocation(10, 0);
        Node third = new Node(null, alloc);
        Node second = new Node(third, alloc);
        Node first = new Node(second, alloc);
        third.setNext(first);
        assertThat(third.getNext()).isEqualTo(first);
    }

    @Test
    void testGetAndSetContent() {
        Allocation alloc = new Allocation(10, 0);
        Allocation secondAlloc = new Allocation(20, 10);
        Node second = new Node(null, alloc);
        Node first = new Node(second, alloc);
        first.setContent(secondAlloc);
        assertThat(first.getContent()).isEqualTo(secondAlloc);
    }

    @Test
    void testEqualsContract() {
        Node prefabNode1 = new Node(null, new Allocation(10, 0));
        Node prefabNode2 = new Node(prefabNode1, new Allocation(10, 10));
        EqualsVerifier.forClass(Node.class).
                withPrefabValues(Node.class, prefabNode1, prefabNode2).
                suppress(Warning.NONFINAL_FIELDS).
                verify();
    }
}