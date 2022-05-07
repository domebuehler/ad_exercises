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

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.RecursiveAction;

/**
 * Codevorlage zu RecursiveAction für die Sortierung eines int-Arrays.
 */
@SuppressWarnings("serial")
public final class QuicksortTask extends RecursiveAction {

    private static final int THRESHOLD = 3_750_000;
    private final int[] array;
    private final int min;
    private final int max;

    public QuicksortTask(int[] array) {
        this(array, 0, array.length - 1);
    }

    private QuicksortTask(final int[] array, final int min, final int max) {
        this.array = array;
        this.min = min;
        this.max = max;
    }

    @Override
    protected void compute() {
        if (min >= max) {
            return;
        }
        if (max - min < THRESHOLD) {
            Arrays.sort(array, min, max + 1);
        } else {
            int partition = partition(min, max, array);
            invokeAll(new QuicksortTask(array, min, partition - 1), new QuicksortTask(array, partition + 1, max));
        }
    }

    private int partition(int start, int end, int[] arr) {
        int i = start;
        int j = end;
        // Decide random pivot
        int pivot = new Random().nextInt(j - i) + i;
        // Swap the pivoted with end
        // element of array;
        int temp = arr[j];
        arr[j] = arr[pivot];
        arr[pivot] = temp;
        j--;
        // Start partitioning
        while (i <= j) {
            if (arr[i] <= arr[end]) {
                i++;
            }
            if (arr[j] >= arr[end]) {
                j--;
            }
            temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            j--;
            i++;
        }
        // Swap pivoted to its
        // correct position
        temp = arr[j + 1];
        arr[j + 1] = arr[end];
        arr[end] = temp;
        return j + 1;
    }
}
