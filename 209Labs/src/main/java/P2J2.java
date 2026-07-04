import java.util.Arrays;
import java.util.HashSet;

public class P2J2 {
    public static String removeDuplicates(String text)
    {
        if (text.isEmpty()) {
            return "";
        } else if (text.length() == 1) {
            return text;
        }

        char prevChar =  text.charAt(0);
        String newText = "" + prevChar;

        for(int i=1; i<text.length(); i++)
        {
            if (prevChar != text.charAt(i))
            {
                newText += text.charAt(i);
            }

            prevChar = text.charAt(i);
        }

        return newText;
    }

    public static String uniqueCharacters(String text)
    {
        if (text.isEmpty()) {
            return "";
        } else if (text.length() == 1) {
            return text;
        }

        HashSet<Character> seenChars = new HashSet<Character>();
        seenChars.add(text.charAt(0));
        String newText = "" + text.charAt(0);

        for(int i=1; i<text.length(); i++)
        {
            if (!seenChars.contains(text.charAt(i)))
            {
                seenChars.add(text.charAt(i));
                newText += text.charAt(i);
            }
        }

        return newText;
    }

    public static int countSafeSquaresRooks(int n, boolean[][] rooks)
    {
        Boolean[] safeRows = new Boolean[n];
        Boolean[] safeCols = new Boolean[n];

        Arrays.fill(safeRows, true);
        Arrays.fill(safeCols, true);

        int countCol = 0;
        int countRow = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (rooks[i][j]) {
                    safeRows[i] = false;
                    safeCols[j] = false;
                }
            }
        }

        for (int x = 0; x < n; x++) {
            if  (safeRows[x]) {
                countRow++;
            }
        }

        for  (int x = 0; x < n; x++) {
            if  (safeCols[x]) {
                countCol++;
            }
        }

        return countRow * countCol;
    }

    public static int recaman(int n)
    {
        Boolean[] seen = new Boolean[n*10];
        Arrays.fill(seen, false);

        int prev_a = 1;
        seen[1] = true;
        int a = 0;

        if (n==1) {
            return 1;
        }

        for (int i = 2; i <= n; i++) {
            if(prev_a - i > 0) {
                if (!seen[prev_a - i]) {
                    a = prev_a - i;
                } else {
                    a = prev_a + i;
                }
            }
            else {
                a = prev_a + i;
            }

            seen[a] = true;
            prev_a = a;
        }

        return a;
    }

}
