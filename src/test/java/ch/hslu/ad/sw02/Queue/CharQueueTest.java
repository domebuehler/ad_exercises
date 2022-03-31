package ch.hslu.ad.sw02.Queue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CharQueueTest {

    private static final Logger LOG = LogManager.getLogger(CharQueueTest.class);

    @Test
    void testIsFull() {
        CharQueue queue = new CharQueue();
        while (!queue.isFull()) {
            queue.offer('a');
        }
        assertThat(queue.isFull()).isTrue();
    }

    @Test
    void testIsEmpty() {
        CharQueue queue = new CharQueue();
        assertThat(queue.isEmpty()).isTrue();
    }

    @Test
    void testSize() {
        CharQueue queue = new CharQueue();
        queue.offer('a');
        queue.offer('b');
        queue.offer('c');
        assertThat(queue.size()).isEqualTo(3);
    }

    @Test
    void testOfferAndPull() {
        CharQueue queue = new CharQueue();
        queue.offer('a');
        queue.offer('b');
        queue.offer('c');
        String pulled = "";
        while (!queue.isEmpty()) {
            pulled += queue.pull();
        }

        assertThat(pulled).isEqualTo("abc");
    }

    @Test
    void testOfferAndPullWithIndexOverflow() {
        CharQueue queue = new CharQueue();
        queue.offer('a');
        queue.offer('b');
        queue.offer('c');
        String pulled = "";
        while (!queue.isEmpty()) {
            pulled += queue.pull();
        }
        queue.offer('d');
        queue.offer('e');
        queue.offer('f');
        queue.offer('g');
        queue.offer('h');
        queue.offer('i');
        queue.offer('j');
        queue.offer('l');
        while (!queue.isEmpty()) {
            pulled += queue.pull();
        }
        assertThat(pulled).isEqualTo("abcdefghijl");
    }

    @Test
    void testToString() {
        CharQueue queue = new CharQueue();
        while (!queue.isFull()) {
            queue.offer('a');
        }
        String expected = "Queue{headIndex=0, tailIndex=0, numberOfChars=8, chars=[a, a, a, a, a, a, a, a]}";

        assertThat(queue.toString()).isEqualTo(expected);
    }

    @Test
    void testOfferThrowsIllegalStateException() {
        CharQueue queue = new CharQueue();
        while (!queue.isFull()) {
            queue.offer('a');
        }
        assertThatThrownBy(() -> queue.offer('a')).
                isInstanceOf(IllegalStateException.class).
                hasMessage("char cannot be added to CharQueue due to capacity restrictions");
    }

    @Test
    void testPullThrowsNoSuchElementException() {
        CharQueue queue = new CharQueue();
        assertThatThrownBy(() -> queue.pull()).
                isInstanceOf(NoSuchElementException.class).
                hasMessage("The Queue is empty");
    }
}