package ch.hslu.ad.sw01.ackermann;

public final class Ackermann {
    private long calls = 0;

    public long ackermann(long n, long m) {
        calls++;
        if (n == 0) {
            return m + 1;
        } else {
            if (m == 0) {
                return ackermann(n - 1, 1);
            } else {
                return ackermann(n - 1, ackermann(n, m - 1));
            }
        }
    }

    public long getCalls() {
        Integer i = 0;
        return calls;
    }
}
