package educative.slidingwindow.hard;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
Given a string and a pattern, find the smallest substring in the given string which has all the characters of the given pattern.

Input: String="aabdec", Pattern="abc" ... Output: "abdec"
Explanation: The smallest substring having all characters of the pattern is "abdec"

Input: String="abdbca", Pattern="abc" ... Output: "bca"
Explanation: The smallest substring having all characters of the pattern is "bca".

Input: String="adcad", Pattern="abc" ... Output: ""
Explanation: No substring in the given string has all characters of the pattern.
 */
public class MinimumWindowSubstring {
    public static String findSubstring(String str, String pattern) {
        List<Character> patternLetters = new ArrayList<>();
        for (char c : pattern.toCharArray()) {
            patternLetters.add(c);
        }

        String result = "";
        int windowStart = 0;
        List<Character> strLetters = new ArrayList<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            strLetters.add(str.charAt(windowEnd));

            if (strLetters.size() >= patternLetters.size()) {
                while (strLetters.containsAll(patternLetters)) {
                    result = str.substring(windowStart, windowEnd + 1);

                    char leftChar = str.charAt(windowStart);
                    strLetters.remove(Character.valueOf(leftChar));
                    windowStart++;
                }
            }
        }

        return result;
    }

    @Test
    public void verify() {
        Assert.assertEquals("abdec", findSubstring("aabdec", "abc"));
        Assert.assertEquals("bca", findSubstring("abdbca", "abc"));
        Assert.assertEquals("", findSubstring("adcad", "abc"));
    }
}
