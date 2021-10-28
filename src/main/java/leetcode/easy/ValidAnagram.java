package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/valid-anagram/
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        int[] freqA = new int[26];
        for(char c: s.toCharArray()) {
            int idx = (int)c - (int)'a';
            freqA[idx]++;
        }

        int[] freqB = new int[26];
        for(char ch: t.toCharArray()) {
            int idx = (int)ch - (int)'a';
            freqA[idx]++;
        }

        for(int i = 0; i < freqA.length; i++) {
            if(freqA[i] != freqB[i]) {
                return false;
            }
        }

        return true;
    }

    @Test
    public void test() {
        Assert.assertTrue(isAnagram("anagram", "nagaram"));
    }

    @Test
    public void test3() {
        Assert.assertFalse(isAnagram("aa", "a"));
    }

    @Test
    public void test2() {
        Assert.assertFalse(isAnagram("ac", "bb"));
    }
}
