package ch.hslu.ad.sw04.Performance;

import java.util.Random;

public final class MeasurementDataCreator {

    private static final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int LETTERS = 4;

    public static String[] getStrings(final int size) {
        String[] strings = new String[size];
        for (int i = 0; i < size; i++) {
            strings[i] = createRandomString();
        }
        return strings;
    }

    private static String createRandomString() {
        String randomString = "";
        for (int i = 0; i < LETTERS; i++) {
            int randomNum = new Random().nextInt(26);
            randomString += chars.charAt(randomNum);
        }
        return randomString;
    }
}
