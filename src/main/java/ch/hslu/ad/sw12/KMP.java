package ch.hslu.ad.sw12;

public final class KMP {

    public static int kmpSearch(final String searchWord, final String pattern) {
        final int n = searchWord.length();
        final int m = pattern.length();
        int indexSearchWord = 0;
        int indexPattern = 0;
        // 1. generate next
        int[] next= initNext(pattern);
        // 2. search for p
        do{
            if((indexPattern == -1) || (searchWord.charAt(indexSearchWord) == pattern.charAt(indexPattern))) { // (j == -1) first!
                indexSearchWord++; // process next character
                indexPattern++;
            } else{
                indexPattern = next[indexPattern]; // goto next state
            }
        } while((indexPattern < m) && (indexSearchWord < n));
        if(indexPattern == m) {
            return(indexSearchWord -m); // pattern found: index to position in a
        } else{
            return-1; // pattern not found
        }
    }

    /**
     * Erzeugt für das Pattern einen Musterautomaten.
     * @paramp Pattern, nach dem später gesucht werden soll.
     * @returnMusterautomat in Form eines int-Arrays.
     */
    public static int[] initNext(final String pattern) {
        final int m = pattern.length();
        final int[] next= new int[m];
        int i = 0;
        int j = -1;
        next[0] = -1;
        // special value! (-1 = no reference to a following state)
        do{
            if((j == -1) || (pattern.charAt(i) == pattern.charAt(j))) {
                // (j == -1) must be first operand!
                i++;
                j++;
                next[i] = j;
            } else{
                j = next[j];
            }
        } while(i < (m -1));
        return next;
    }
}
