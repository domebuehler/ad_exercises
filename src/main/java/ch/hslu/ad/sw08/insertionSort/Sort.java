package ch.hslu.ad.sw08.insertionSort;

public final class Sort {

    @SuppressWarnings("UnusedAssignment")
    public static int[] insertionSort(int[] toBeSorted) {
        int[] toBeSortedWithDummy = copyArrayToArrayWithDummy(toBeSorted);
        int currentInt;
        int j;
        for (int i = 1; i < toBeSortedWithDummy.length; i++) {
            currentInt = toBeSortedWithDummy[i];
            toBeSortedWithDummy[0] = currentInt;
            j = i;
            while (toBeSortedWithDummy[j - 1] > currentInt) {
                toBeSortedWithDummy[j] = toBeSortedWithDummy[j - 1];
                j--;
            }
            toBeSortedWithDummy[j] = currentInt;
        }
        return removeDummyElementFromArray(toBeSortedWithDummy);
    }

    private static int[] copyArrayToArrayWithDummy(final int[] toBeSorted) {
        int[] toBeSortedWithDummy = new int[toBeSorted.length + 1];
        System.arraycopy(toBeSorted, 0, toBeSortedWithDummy, 1, toBeSorted.length);
        return toBeSortedWithDummy;
    }

    private static int[] removeDummyElementFromArray(final int[] toBeSortedWithDummy) {
        int[] toBeSorted = new int[toBeSortedWithDummy.length - 1];
        System.arraycopy(toBeSortedWithDummy, 1, toBeSorted, 0, toBeSorted.length);
        return toBeSorted;
    }
}
