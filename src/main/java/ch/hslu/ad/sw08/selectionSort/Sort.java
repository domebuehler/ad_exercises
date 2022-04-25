package ch.hslu.ad.sw08.selectionSort;

public final class Sort {

    public static void selectionSort(final int[] toBeSorted) {
        int leastIndex;
        for (int i = 0; i < toBeSorted.length - 1; i++) {
            leastIndex = i;
            for (int j = i + 1; j < toBeSorted.length; j++) {
                if (toBeSorted[leastIndex] > toBeSorted[j]) {
                    leastIndex = j;
                }
            }
            int temp = toBeSorted[leastIndex];
            toBeSorted[leastIndex] = toBeSorted[i] ;
            toBeSorted[i] = temp ;
        }
    }
}
