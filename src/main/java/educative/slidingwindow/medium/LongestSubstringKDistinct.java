package educative.slidingwindow.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {
    public static int findLength(String str, int k) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException();
        }

        int windowStart = 0;
        int longestSubstring = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char leftChar = str.charAt(windowEnd);
            charFrequencyMap.put(leftChar, charFrequencyMap.getOrDefault(leftChar, 0) + 1);

            while (charFrequencyMap.size() > k) {
                char rightChar = str.charAt(windowStart);
                charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
                if (charFrequencyMap.get(rightChar) == 0) {
                    charFrequencyMap.remove(rightChar);
                }
                windowStart++;
            }
            longestSubstring = Math.max(longestSubstring, windowEnd - windowStart + 1);
        }

        return longestSubstring;
    }

    @Test
    public void verify() {
        //Assert.assertEquals(4, findLength("araaci", 2));
        Assert.assertEquals(2, findLength("araaci", 1));
        //Assert.assertEquals(5, findLength("cbbebi", 3));
        //Assert.assertEquals(6, findLength("cbbebi", 10));
    }
}
