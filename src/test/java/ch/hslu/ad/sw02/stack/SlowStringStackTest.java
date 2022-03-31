package ch.hslu.ad.sw02.stack;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SlowStringStackTest {

    @Test
    void testStringStackIsEmptyAfterConstruction() {
        SlowStringStack stack = new SlowStringStack(10);
        assertThat(stack.empty()).isTrue();
    }

    @Test
    void testStringStackIsNotEmptyWhenStringWasPushed() {
        SlowStringStack stack = new SlowStringStack(10);
        stack.push("Test");
        assertThat(stack.empty()).isFalse();
    }

    @Test
    void testStringStackIsFull() {
        SlowStringStack stack = new SlowStringStack(1);
        stack.push("Test");
        assertThat(stack.full()).isTrue();
    }

    @Test
    void testPushAndPopUntilIsFull() {
        SlowStringStack stack = new SlowStringStack(10);
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
        SlowStringStack stack = new SlowStringStack(3);
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
    void testToString() {
        SlowStringStack stack = new SlowStringStack(3);
        stack.push("Toll");
        stack.push("Sind");
        stack.push("Datenstrukturen");
        String excepted = "StringStack{strings=[Datenstrukturen, Sind, Toll], size=3, numberOfStrings=3}";
        assertThat(stack.toString()).isEqualTo(excepted);
    }

    @Test
    void testPushThrowsStackOverflowError() {
        SlowStringStack stack = new SlowStringStack(3);
        while (!stack.full()) {
            stack.push("test");
        }

        assertThatThrownBy(() -> stack.push("test")).
                isInstanceOf(StackOverflowError.class).
                hasMessage("Failed to add because Stack is full");
    }

    @Test
    void testPopThrowsEmptyStackException() {
        SlowStringStack stack = new SlowStringStack(3);
        assertThatThrownBy(() -> stack.pop()).
                isInstanceOf(EmptyStackException.class);
    }
}