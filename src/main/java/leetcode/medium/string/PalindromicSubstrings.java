package leetcode.medium.string;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/palindromic-substrings/
public class PalindromicSubstrings {

    public int countSubstrings(String s) {
        int counter = 0;

        for (int i = 0; i < s.length(); ++i) {
            // odd-length palindromes, single character center
            counter += countPalindromesAroundCenter(s, i, i);

            // even-length palindromes, consecutive characters center
            counter += countPalindromesAroundCenter(s, i, i + 1);
        }

        return counter;
    }

    private int countPalindromesAroundCenter(String ss, int left, int right) {
        int counter = 0;

        while (left >= 0 && right < ss.length() && ss.charAt(left) == ss.charAt(right)) {
            left--;
            right++;

            counter++;
        }

        return counter;
    }

    @Test
    public void test() {
        Assert.assertEquals(3, countSubstrings("abc"));
    }

    @Test
    public void test2() {
        Assert.assertEquals(6, countSubstrings("aaa"));
    }
}
