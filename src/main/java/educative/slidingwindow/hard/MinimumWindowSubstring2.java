package educative.slidingwindow.hard;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring2 {
    public static String findSubstring2(String str, String pattern) {
        Map<Character, Integer> map = new HashMap<>();
        for (char chr : pattern.toCharArray()) {
            map.put(chr, map.getOrDefault(chr, 0) + 1);
        }

        int start = 0;
        int matched = 0;
        int minLength = str.length() + 1;
        int subStrStart = 0;
        // try to extend the range [start, windowEnd]
        for (int i = 0; i < str.length(); i++) {
            char rightChar = str.charAt(i);
            if (map.containsKey(rightChar)) {
                map.put(rightChar, map.get(rightChar) - 1);
                if (map.get(rightChar) >= 0) {// count every matching of a character
                    matched++;
                }
            }

            // shrink the window if we can, finish as soon as we remove a matched character
            while (matched == pattern.length()) {
                int currentWindowSzie = i - start + 1;
                if (minLength > currentWindowSzie) {
                    minLength = currentWindowSzie;
                    subStrStart = start;
                }

                char leftChar = str.charAt(start);
                if (map.containsKey(leftChar)) {
                    // note that we could have redundant matching characters, therefore we'll decrement the
                    // matched count only when a useful occurrence of a matched character is going out of the window
                    if (map.get(leftChar) == 0) {
                        matched--;
                    }
                    map.put(leftChar, map.get(leftChar) + 1);
                }
                start++;
            }
        }

        return minLength > str.length() ? "" : str.substring(subStrStart, subStrStart + minLength);
    }

    @Test
    public void verify() {
        Assert.assertEquals("abdec", findSubstring2("aabdec", "abc"));
        Assert.assertEquals("bca", findSubstring2("abdbca", "abc"));
        Assert.assertEquals("", findSubstring2("adcad", "abc"));
    }
}
