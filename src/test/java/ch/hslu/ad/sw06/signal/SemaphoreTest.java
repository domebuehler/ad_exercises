package ch.hslu.ad.sw06.signal;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SemaphoreTest {

    @Test
    void testConstructorThrowsIllegalArgumentExceptionWhenPermitsBiggerThanLimit() {
        assertThatThrownBy(() -> new Semaphore(4, 3)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessage("permits > limit");
    }

    @Test
    void testConstructorThrowsIllegalArgumentExceptionWhenLimitOverflow() {
        assertThatThrownBy(() -> new Semaphore(4, Integer.MAX_VALUE + 1)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessage("limit < 0");
    }

    @Test
    void testReleaseThrowsIllegalStateExceptionsWhenLimitReached() {
        Semaphore semaphore = new Semaphore(3, 3);
        assertThatThrownBy(() -> semaphore.release()).
                isInstanceOf(IllegalStateException.class).
                hasMessage("semaphore overflow");
    }

    @Test
    void testReleaseThrowsIllegalArgumentExceptionWhenNumberOfReleasesBiggerThanPossiblePermits() {
        Semaphore sema = new Semaphore(0, 3);
        assertThatThrownBy(() -> sema.release(4)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessage("permits > sema");
    }

    @Test
    void testAcquireThrowsIllegalArgumentExceptionWhenNumberOfAcquireBiggerThanPermits() {
        Semaphore sema = new Semaphore(3, 3);
        assertThatThrownBy(() -> sema.acquire(4)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessage("permits > sema");
    }

    @Test
    void testAcquireThrowsIllegalArgumentExceptionWhenPermitsWhenZeroOrLess() {
        Semaphore sema = new Semaphore(3, 3);
        assertThatThrownBy(() -> sema.acquire(-1)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessage("permits <= 0");
    }

    @Test
    void testReleaseThrowsIllegalArgumentExceptionWhenPermitsWhenZeroOrLess() {
        Semaphore sema = new Semaphore(1, 3);
        assertThatThrownBy(() -> sema.release(-1)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessage("permits <= 0");
    }
}