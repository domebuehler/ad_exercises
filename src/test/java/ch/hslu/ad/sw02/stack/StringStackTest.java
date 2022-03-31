package ch.hslu.ad.sw02.stack;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringStackTest {

    @Test
    void testEmpty() {
        StringStack stack = new StringStack(10);
        assertThat(stack.empty()).isTrue();
    }

    @Test
    void testNotEmpty() {
        StringStack stack = new StringStack(10);
        stack.push("test");
        assertThat(stack.empty()).isFalse();
    }

    @Test
    void testFull() {
        StringStack stack = new StringStack(1);
        stack.push("test");
        assertThat(stack.full()).isTrue();
    }

    @Test
    void testPushAndPopUntilIsFull() {
        StringStack stack = new StringStack(10);
        while (!stack.full()) {
            stack.push("test");
        }
        int counter = 0;
        while (!stack.empty()) {
            stack.pop();
            counter++;
        }

        assertThat(counter).isEqualTo(10);
    }

    @Test
    void testOrderWhenPopping() {
        StringStack stack = new StringStack(3);
        stack.push("Toll");
        stack.push("Sind");
        stack.push("Datenstrukturen");
        String testString = "";
        while (!stack.empty()) {
            testString += stack.pop();
        }

        assertThat(testString).isEqualTo("DatenstrukturenSindToll");
    }

    @Test
    void testPushThrowsStackOverflowError() {
        StringStack stack = new StringStack(3);
        while (!stack.full()) {
            stack.push("test");
        }

        assertThatThrownBy(() -> stack.push("test")).
                isInstanceOf(StackOverflowError.class).
                hasMessage("Failed to add because Stack is full");
    }

    @Test
    void testPopThrowsEmptyStackException() {
        StringStack stack = new StringStack(3);
        assertThatThrownBy(() -> stack.pop()).
                isInstanceOf(EmptyStackException.class);
    }
}