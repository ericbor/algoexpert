package educative.slidingwindow.hard;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
/*
Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter, find the length of the longest substring having the same letters after replacement.

Input: String="aabccbb", k=2 ... Output: 5
Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".

Input: String="abccde", k=1 ... Output: 3
Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".
 */
public class CharacterReplacement {
    public static int findLength(String str, int k) {
        int windowStart = 0;
        int maxLength = 0;
        int maxRepeatLetterCount = 0;
        Map<Character, Integer> letterFrequencyMap = new HashMap<>();

        // try to extend the range [windowStart, windowEnd]
        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            letterFrequencyMap.put(rightChar, letterFrequencyMap.getOrDefault(rightChar, 0) + 1);
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, letterFrequencyMap.get(rightChar));

            /* current window size is from windowStart to windowEnd, overall we have a letter which is
            repeating 'maxRepeatLetterCount' times, this means we can have a window which has one letter
            repeating 'maxRepeatLetterCount' times and the remaining letters we should replace.
            If the remaining letters are more than 'k', it is the time to shrink the window as we
            are not allowed to replace more than 'k' letters */
            int currentWindowSize = windowEnd - windowStart + 1;
            if(currentWindowSize - maxRepeatLetterCount > k) {
                char leftChar = str.charAt(windowStart);
                letterFrequencyMap.put(leftChar, letterFrequencyMap.get(leftChar) - 1);
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }

    @Test
    public void verify() {
        Assert.assertEquals(5, findLength("aabccbb", 2)); //bbbbb - Replace the two 'c' with 'b'
        Assert.assertEquals(4, findLength("abbcb", 1)); //bbbb - Replace the 'c' with 'b'
        Assert.assertEquals(3, findLength("abccde", 1)); //ccc - Replace the 'b' or 'd' with 'c'
    }
}
