package array.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/permutation-in-string/
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {

        int[] s1Hash = getHash(s1);
        int start = 0;

        for (int i = 0; i < s2.length(); i++) {
            if (i - start + 1 == s1.length()) {
                int[] s2Hash = getHash(s2.substring(start, i + 1));
                if (isPermutation(s1Hash, s2Hash)) {
                    return true;
                }
                start++;
            }
        }

        return false;
    }

    private boolean isPermutation(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }

    private int[] getHash(String s) {
        int[] hash = new int[26];
        for (char c : s.toCharArray()) {
            hash[(int) c - (int) 'a']++;
        }

        return hash;
    }

    public boolean checkInclusion_2(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] s1count = new int[26];
        int[] s2count = new int[26];
        //int k = s1.length();
        for (int i = 0; i < s1.length(); i++) {
            s1count[s1.charAt(i) - 'a']++;
            s2count[s2.charAt(i) - 'a']++;
        }
        if (matches(s1count, s2count)) {
            return true;
        }

        int front = 0;
        int back = s1.length();
        while (back < s2.length()) {
            s1count[s2.charAt(front) - 'a']--;
            s2count[s2.charAt(back) - 'a']++;

            if (matches(s1count, s2count)) {
                return true;
            }
            front++;
            back++;
        }

        return matches(s1count, s2count);
    }

    public boolean matches(int[] s1count, int[] s2count) {
        for (int i = 0; i < 26; i++) {
            if (s1count[i] != s2count[i])
                return false;
        }
        return true;
    }

    @Test
    public void test() {
        Assert.assertFalse(checkInclusion("hello", "ooolleoooleh"));
        Assert.assertFalse(checkInclusion_2("hello", "ooolleoooleh"));
    }

    @Test
    public void test3() {
        Assert.assertTrue(checkInclusion("ab", "eidbaooo"));
        Assert.assertTrue(checkInclusion_2("ab", "eidbaooo"));
    }

    @Test
    public void test2() {
        Assert.assertFalse(checkInclusion("ab", "eidboaoo"));
        Assert.assertFalse(checkInclusion_2("ab", "eidboaoo"));
    }
}
