package ch.hslu.ad.sw11;

import java.util.regex.Pattern;

public final class DeterministicFiniteAutomaton {

    private static State state;
    private static boolean breakFlag;

    public static boolean isWordLanguage(final String string) {
        if (string == null) {
            return false;
        }
        breakFlag = false;
        state = State.Z0;
        for (char c : string.toCharArray()) {
            if (breakFlag) {
                return false;
            } else if (c == '0') {
                handleZero();
            } else if (c == '1') {
                handleOne();
            } else {
                return false;
            }
        }
        return (state == State.Z1 && !breakFlag) || (state == State.Z4 && !breakFlag);
    }

    private static void handleOne() {
        if (state == State.Z1) {
            state = State.Z2;
        } else if (state == State.Z2) {
            state = State.Z3;
        } else if (state == State.Z3) {
            state = State.Z2;
        } else if (state == State.Z4) {
            state = State.Z2;
        } else {
            breakFlag = true;
        }
    }

    private static void handleZero() {
        if (state == State.Z0) {
            state = State.Z1;
        } else if (state == State.Z2) {
            state = State.Z4;
        } else {
            breakFlag = true;
        }
    }
}
