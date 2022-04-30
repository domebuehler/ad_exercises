package ch.hslu.ad.sw09.quickSort;

public final class QuickSort {

    public static void quickSortForChars(final char[] a) {
        int left = 0;
        int right = a.length - 1;
        quickSortForChars(a, left, right);
    }

    public static void quickSortForChars(final char[] a, final int left, final int right) {
        int up = left; // linke Grenze
        int down = right - 1; // rechte Grenze (ohne Trennelement)
        char t = a[right]; // rechtes Element als Trennelement
        boolean allChecked = false;
        do {
            while (a[up] < t) {
                up++; // suche grösseres (>=) Element von links an
            }
            while ((a[down] >= t) && (down > up)) {
                down--; // suche echt kleineres (<) Element von rechts an
            }
            if (down > up) { // solange keine Überschneidung
                exchangeChars(a, up, down);
                up++;
                down--; // linke und rechte Grenze verschieben
            } else {
                allChecked = true; // Austauschen beendet
            }
        } while (!allChecked);
        exchangeChars(a, up, right); // Trennelement an endgültige Position (a[up])
        if (left < (up - 1)) quickSortForChars(a, left, (up - 1)); // linke Hälfte
        if ((up + 1) < right) quickSortForChars(a, (up + 1), right); // rechte Hälfte, ohne T’Elt.
    }

    public static void quickSortForCharsExchangingEqualsTo(final char[] a) {
        int left = 0;
        int right = a.length - 1;
        quickSortForCharsExchangingEqualsTo(a, left, right);
    }

    public static void quickSortForCharsExchangingEqualsTo(final char[] a, final int left, final int right) {
        int up = left; // linke Grenze
        int down = right - 1; // rechte Grenze (ohne Trennelement)
        char t = a[right]; // rechtes Element als Trennelement
        boolean allChecked = false;
        do {
            while (a[up] < t) {
                up++; // suche grösseres (>=) Element von links an
            }
            while ((a[down] > t) && (down > up)) {
                down--; // suche echt kleineres (<) Element von rechts an
            }
            if (down > up) { // solange keine Überschneidung
                exchangeChars(a, up, down);
                up++;
                down--; // linke und rechte Grenze verschieben
            } else {
                allChecked = true; // Austauschen beendet
            }
        } while (!allChecked);
        exchangeChars(a, up, right); // Trennelement an endgültige Position (a[up])
        if (left < (up - 1)) quickSortForChars(a, left, (up - 1)); // linke Hälfte
        if ((up + 1) < right) quickSortForChars(a, (up + 1), right); // rechte Hälfte, ohne T’Elt.
    }

    private static void exchangeChars(final char[] a, final int firstIndex, final int secondIndex) {
        char tmp;
        tmp = a[firstIndex];
        a[firstIndex] = a[secondIndex];
        a[secondIndex] = tmp;
    }

    public static void quickSortForInts(final int[] a) {
        int left = 0;
        int right = a.length - 1;
        quickSortForInts(a, left, right);
    }

    public static void quickSortForInts(final int[] a, final int left, final int right) {
        int up = left; // linke Grenze
        int down = right - 1; // rechte Grenze (ohne Trennelement)
        int t = a[right]; // rechtes Element als Trennelement
        boolean allChecked = false;
        do {
            while (a[up] < t) {
                up++; // suche grösseres (>=) Element von links an
            }
            while ((a[down] >= t) && (down > up)) {
                down--; // suche echt kleineres (<) Element von rechts an
            }
            if (down > up) { // solange keine Überschneidung
                exchangeInts(a, up, down);
                up++;
                down--; // linke und rechte Grenze verschieben
            } else {
                allChecked = true; // Austauschen beendet
            }
        } while (!allChecked);
        exchangeInts(a, up, right); // Trennelement an endgültige Position (a[up])
        if (left < (up - 1)) quickSortForInts(a, left, (up - 1)); // linke Hälfte
        if ((up + 1) < right) quickSortForInts(a, (up + 1), right); // rechte Hälfte, ohne T’Elt.
    }

    private static void exchangeInts(final int[] a, final int firstIndex, final int secondIndex) {
        int tmp;
        tmp = a[firstIndex];
        a[firstIndex] = a[secondIndex];
        a[secondIndex] = tmp;
    }
}
