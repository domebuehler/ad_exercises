package ch.hslu.ad.sw08.insertionSort;

public final class Sort {

    public static void insertionSort(final int[] toBeSorted) {
        int currentInt;
        int j;
        for (int i = 1; i < toBeSorted.length; i++) {
            currentInt = toBeSorted[i];
            toBeSorted[0] = currentInt;
            j = i;
            while (toBeSorted[j - 1] > currentInt) {
                toBeSorted[j] = toBeSorted[j - 1];
                j--;
            }
            toBeSorted[j] = currentInt;
        }
    }
}
