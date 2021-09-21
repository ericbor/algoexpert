package educative.slidingwindow.hard;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
/*
Given a string, find the length of the longest substring, which has no repeating characters.

Input: String="aabccbb" ... Output: 3
Explanation: The longest substring without any repeating characters is "abc".

Input: String="abccde" ... Output: 3
Explanation: Longest substrings without any repeating characters are "abc" & "cde".
 */
public class NoRepeatSubstring {
    public static int findLength(String str) {
        int longestSubstring = Integer.MIN_VALUE;
        List<Character> charsList = new ArrayList<>();

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char leftChar = str.charAt(windowEnd);
            if (charsList.contains(leftChar)) {
                charsList.clear();
            }
            charsList.add(leftChar);

            longestSubstring = Math.max(longestSubstring, charsList.size());
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
