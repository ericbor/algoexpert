package educative.slidingwindow.hard;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/*
Given a string, find the length of the longest substring, which has no repeating characters.

Input: String="aabccbb" ... Output: 3
Explanation: The longest substring without any repeating characters is "abc".

Input: String="abccde" ... Output: 3
Explanation: Longest substrings without any repeating characters are "abc" & "cde".
 */
public class NoRepeatSubstring2 {
    public static int findLength(String str) {
        int windowStart = 0;
        int longestSubstring = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();
        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            // if the map already contains the 'rightChar', shrink the window from the beginning so that
            // we have only one occurrence of 'rightChar'
            if (charIndexMap.containsKey(rightChar)) {
                // this is tricky; in the current window, we will not have any 'rightChar' after its previous index
                // and if 'windowStart' is already ahead of the last index of 'rightChar', we'll keep 'windowStart'
                windowStart = Math.max(windowStart, charIndexMap.get(rightChar) + 1);
            }
            charIndexMap.put(rightChar, windowEnd); // insert the 'rightChar' into the map
            longestSubstring = Math.max(longestSubstring, windowEnd - windowStart + 1); // remember the maximum length so far
        }

        return longestSubstring;
    }

    @Test
    public void verify() {
        Assert.assertEquals(3, findLength("aabccbb"));
        //Assert.assertEquals(3, findLength("aabccbb"));
        //Assert.assertEquals(3, findLength("abccde"));
    }
}
