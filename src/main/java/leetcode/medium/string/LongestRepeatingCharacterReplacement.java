package leetcode.medium.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/longest-repeating-character-replacement/
public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        int[] charCount = new int[26];

        int start = 0;
        int maxRepeat = 0;
        int longest = 0;

        for (int end = 0; end < s.length(); end++) {
            char curr = s.charAt(end);
            int currIdx = (int)curr - (int)'A';

            charCount[currIdx]++;


            // IMPORTANT: maxRepeat is not the accurate number of dominant character, It is the historical maximum count
            // We do not care about it because unless it gets greater, it won't affect our final max window size.
            maxRepeat = Math.max(maxRepeat, charCount[currIdx]);

            if (end - start + 1 - maxRepeat > k) {
                char remove = s.charAt(start);
                int removeIdx = (int)remove - (int)'A';
                charCount[removeIdx]--;

                start++;
            }


            longest = Math.max(longest, end - start + 1);
        }

        return longest;
    }



    @Test
    public void test2() {
        Assert.assertEquals(5, characterReplacement("AABABBABB", 1));
    }

    @Test
    public void test3() {
        Assert.assertEquals(4, characterReplacement("ABAB", 2));
    }
}
