package ch.hslu.ad.sw08.bubbleSort;

public final class Sort {

    public static void bubbleSort(final int[] toBeSorted) {
        for (int i = 0; i < toBeSorted.length - 1; i++) {
            for (int j = 0; j < toBeSorted.length - 1; j++) {
                if (toBeSorted[j] > toBeSorted[j + 1]) {
                    int temp = toBeSorted[j];
                    toBeSorted[j] = toBeSorted[j + 1];
                    toBeSorted[j + 1] = temp;
                }
            }
        }
    }
}
