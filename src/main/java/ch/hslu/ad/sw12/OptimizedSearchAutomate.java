package ch.hslu.ad.sw12;

public final class OptimizedSearchAutomate {

    public static int stateSearchANANAS(final String a) {
        int i = 0;
        final int notFound = -1;
        String state = "";

        if (a == null) {
            return notFound;
        }

        do {

            switch (state) {
                case "":
                    if (a.charAt(i) == 'A') {
                        state = "A";
                    }
                    break;

                case "A":
                    if (a.charAt(i) == 'N') {
                        state = "AN";
                    } else if (a.charAt(i) == 'A') {
                        state = "A";
                    } else {
                        state = "";
                    }
                    break;

                case "AN":
                    if (a.charAt(i) == 'A') {
                        state = "ANA";
                    } else {
                        state = "";
                    }
                    break;

                case "ANA":
                    if (a.charAt(i) == 'N') {
                        state = "ANAN";
                    } else if (a.charAt(i) == 'A') {
                        state = "A";
                    } else {
                        state = "";
                    }
                    break;

                case "ANAN":
                    if (a.charAt(i) == 'A') {
                        state = "ANANA";
                    } else if (a.charAt(i) == 'N') {
                        state = "AN";
                    } else {
                        state = "";
                    }
                    break;

                case "ANANA":
                    if (a.charAt(i) == 'S') {
                        state = "ANANAS";
                    } else if (a.charAt(i) == 'N') {
                        state = "AN";
                    } else {
                        state = "A";
                    }
                    break;
            }
            i++;
        } while ((state != "ANANAS") && (i < a.length()));
        if (state.equals("ANANAS")) {
            return (i - "ANANAS".length());
        }
        return notFound;
    }
}
