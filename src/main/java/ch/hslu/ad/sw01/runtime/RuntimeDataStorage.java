package ch.hslu.ad.sw01.runtime;

@SuppressWarnings("ClassCanBeRecord")
public final class RuntimeDataStorage {
    private final int executionsTask1;
    private final int executionsTask2;
    private final int executionsTask3;
    private final int n;

    public RuntimeDataStorage(int n, int executionsTask1, int executionsTask2, int executionsTask3) {
        this.executionsTask1 = executionsTask1;
        this.executionsTask2 = executionsTask2;
        this.executionsTask3 = executionsTask3;
        this.n = n;
    }

    @Override
    public String toString() {
        return "Number of Executions for n = " + n + " : " +
                "executionsTask1=" + executionsTask1 +
                ", executionsTask2=" + executionsTask2 +
                ", executionsTask3=" + executionsTask3 +
                '}';
    }
}
