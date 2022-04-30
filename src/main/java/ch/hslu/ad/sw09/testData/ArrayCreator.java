package ch.hslu.ad.sw09.testData;

import java.util.Arrays;
import java.util.Random;

public final class ArrayCreator {

    private int[] masterIntArray;
    private char[] masterCharArray;
    private Random random = new Random();
    @SuppressWarnings("SpellCheckingInspection")
    private String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public void createNewMasterCharArray(final int length) {
        this.masterCharArray = new char[length];
        for (int i = 0; i < length; i++) {
            int randomInt = this.random.nextInt(chars.length());
            this.masterCharArray[i] = this.chars.charAt(randomInt);
        }
    }

    public char[] getMasterCharArray() {
        return Arrays.copyOf(this.masterCharArray, this.masterCharArray.length);
    }

    public void createNewMasterIntArray(final int length) {
        this.masterIntArray = new int[length];
        for (int i = 0; i < length; i++) {
            this.masterIntArray[i] = this.random.nextInt();
        }
    }

    public int[] getMasterIntArray() {
        return Arrays.copyOf(this.masterIntArray, this.masterIntArray.length);
    }
}
