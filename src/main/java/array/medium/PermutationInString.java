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

    public boolean checkInclusion_2(String pattern, String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char chr : pattern.toCharArray()) {
            map.put(chr, map.getOrDefault(chr, 0) + 1);
        }

        int start = 0;
        int matched = 0;

        for (int i = 0; i < s.length(); i++) {
            char rightChar = s.charAt(i);
            if (map.containsKey(rightChar)) {
                map.put(rightChar, map.get(rightChar) - 1);
                if (map.get(rightChar) == 0) {
                    matched++;
                }
            }

            if (matched == map.size()) {
                return true;
            }

            if (i >= pattern.length() - 1) { // shrink the window by one character
                char leftChar = s.charAt(start);
                start++;
                if (map.containsKey(leftChar)) {
                    if (map.get(leftChar) == 0) {
                        matched--; // before putting the character back, decrement the matched count
                    }
                    // put the character back for matching
                    map.put(leftChar, map.get(leftChar) + 1);
                }
            }
        }

        return false;
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
