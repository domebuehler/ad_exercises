/*
 * Copyright 2022 Hochschule Luzern Informatik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.hslu.ad.sw10.quicksort;

/**
 * Codevorlage zu RecursiveAction für die Sortierung eines int-Arrays.
 */
public class QuicksortRecursive {

    public static void quickSortForInts(final int[] a) {
        int left = 0;
        int right = a.length - 1;
        quickSortForInts(a, left, right);
    }

    private static void quickSortForInts(final int[] a, final int left, final int right) {
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
