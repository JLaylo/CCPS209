import java.util.Arrays;

public class P2J3 {
    public static void reverseAscendingSubarrays(int[] items)
    {
        if (items.length<2)
        {
            return;
        }

        int starti = 0;
        int endi = 0;

        for (int i=1; i<items.length; i++)
        {
            if (items[i]>items[i-1])
            {
                endi = i;
            }
            else
            {
                reverseSubArray(items, starti, endi);
                starti = i;
                endi = i;
            }
        }

        if (endi > starti)
        {
            reverseSubArray(items, starti, endi);
        }
    }

    public static void reverseSubArray(int[] arr, int start, int end) {
        if (arr == null || start < 0 || end >= arr.length || start >= end)
        {
            return;
        }

        int left = start;
        int right = end;

        while (left < right)
        {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    public static String pancakeScramble(String text)
    {
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

    public static String reverseVowels(String text)
    {
        if (text.length()<=1)
        {
            return text;
        }

        String vowels = "aeiouAEIOU";
        char[] newTextArr = new char[text.length()];
        int starti = 0;
        int endi = text.length()-1;

        char c1;
        char c2 = text.charAt(endi);

        while (starti <= endi)
        {
            c1 = text.charAt(starti);
            if(vowels.contains(Character.toString(c1)))
            {
                //c is a vowel, look for end vowel for swap
                while(starti <= endi)
                {
                    c2 = text.charAt(endi);
                    if(vowels.contains(Character.toString(c2)))
                    {
                        //check capitalization
                        if(Character.isUpperCase(c1))
                        {
                            newTextArr[starti] = Character.toUpperCase(c2);
                        }
                        else
                        {
                            newTextArr[starti] = Character.toLowerCase(c2);
                        }

                        if (Character.isUpperCase(c2))
                        {
                            newTextArr[endi] = Character.toUpperCase(c1);
                        }
                        else
                        {
                            newTextArr[endi] = Character.toLowerCase(c1);
                        }
                        break;
                    }
                    else
                    {
                        newTextArr[endi] = text.charAt(endi);
                    }

                    endi--;
                }

                endi--;
            }
            else
            {
                newTextArr[starti] = text.charAt(starti);
            }

            starti++;
        }

        return String.valueOf(newTextArr);
    }
}
