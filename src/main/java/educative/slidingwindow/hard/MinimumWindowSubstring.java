package educative.slidingwindow.hard;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://www.educative.io/courses/grokking-the-coding-interview/3wDJAYG2pAR
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

    public static String findSubstring2(String str, String pattern) {
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char chr : pattern.toCharArray()) {
            charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);
        }

        int windowStart = 0;
        int matched = 0;
        int minLength = str.length() + 1;
        int subStrStart = 0;
        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if (charFrequencyMap.containsKey(rightChar)) {
                charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
                if (charFrequencyMap.get(rightChar) >= 0) {// count every matching of a character
                    matched++;
                }
            }

            // shrink the window if we can, finish as soon as we remove a matched character
            while (matched == pattern.length()) {
                int currentWindowSzie = windowEnd - windowStart + 1;
                if (minLength > currentWindowSzie) {
                    minLength = currentWindowSzie;
                    subStrStart = windowStart;
                }

                char leftChar = str.charAt(windowStart);
                if (charFrequencyMap.containsKey(leftChar)) {
                    // note that we could have redundant matching characters, therefore we'll decrement the
                    // matched count only when a useful occurrence of a matched character is going out of the window
                    if (charFrequencyMap.get(leftChar) == 0) {
                        matched--;
                    }
                    charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
                }
                windowStart++;
            }
        }

        return minLength > str.length() ? "" : str.substring(subStrStart, subStrStart + minLength);
    }

    @Test
    public void verify() {
        //Assert.assertEquals("abdec", findSubstring("aabdec", "abc"));
        //Assert.assertEquals("bca", findSubstring("abdbca", "abc"));
        //Assert.assertEquals("", findSubstring("adcad", "abc"));

        Assert.assertEquals("abdec", findSubstring2("aabdec", "abc"));
        //Assert.assertEquals("bca", findSubstring2("abdbca", "abc"));
        //Assert.assertEquals("", findSubstring2("adcad", "abc"));
    }
}
