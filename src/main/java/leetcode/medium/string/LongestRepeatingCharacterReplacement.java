package leetcode.medium.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/longest-repeating-character-replacement/
public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        int[] hash = new int[26];
        int start = 0;
        int maxRepeat = 0;
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            int currIdx = (int) s.charAt(i) - (int) 'A';
            hash[currIdx]++;

            maxRepeat = Math.max(maxRepeat, hash[currIdx]);//largest count of a single, unique character in the current window

            //there are more characters in the window than we can replace, shrink
            while (i - start + 1 - maxRepeat > k) {
                hash[(int) s.charAt(start) - (int) 'A']--;
                start++;
            }

            maxLength = Math.max(maxLength, i - start + 1);
        }
        return maxLength;
    }



    @Test
    public void test2() {
        Assert.assertEquals(5, characterReplacement("AABABBABB", 1));
    }

    @Test
    public void test() {
        Assert.assertEquals(4, characterReplacement("ABAB", 2));
    }
}
