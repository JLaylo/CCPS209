public class P2J3 {
    public static void reverseAscendingSubarrays(int[] items) {
        throw new UnsupportedOperationException();
    }

    public static String pancakeScramble(String text) {
        String subString1 = "";
        String subString2 = "";
        String newString = text;

        for (int i = 2; i < text.length(); i++) {
            subString1 = newString.substring(0, i);
            subString2 = newString.substring(i);

            newString = new StringBuilder(subString1).reverse().toString() +  subString2;
        }

        newString = new StringBuilder(newString).reverse().toString();

        return newString;
    }

    public static String reverseVowels(String text) {
        throw new UnsupportedOperationException();
    }
}
