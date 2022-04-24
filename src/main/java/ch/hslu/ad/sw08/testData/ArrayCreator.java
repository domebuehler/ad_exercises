package ch.hslu.ad.sw08.testData;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public final class ArrayCreator {

    public static int[] newRandomIntArray(final int numberOfElements) {
        int[] created = new int[numberOfElements];
        Random random = new Random();
        for (int i = 0; i < numberOfElements; i++) {
            int randomIndex = random.nextInt(numberOfElements);
            if (created[randomIndex] == 0) {
                created[randomIndex] = i + 1;
            } else {
                i--;
            }
        }
        return created;
    }

    public static int[] newRandomSortedIntArray(final int numberOfElements) {
        int[] created = new int[numberOfElements];
        for (int i = 0; i < numberOfElements; i++) {
            created[i] = i + 1;
        }
        return created;
    }

    public static int[] newRandomReverseSortedIntArray(final int numberOfElements) {
        int[] created = new int[numberOfElements];
        for (int i = 1; i <= numberOfElements; i++) {
            created[numberOfElements - i] = i;
        }
        return created;
    }
}
