package leetcode.medium.string;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/longest-palindromic-substring/
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }

    @Test
    public void test() {
        Assert.assertEquals("racecar", longestPalindrome("racecar"));
    }

    @Test
    public void test2() {
        Assert.assertEquals("abba", longestPalindrome("abba"));
    }

    @Test
    public void test7() {
        Assert.assertEquals("aca", longestPalindrome("aacabdkacaa"));
    }

    @Test
    public void test6() {
        Assert.assertEquals("amanaplanacanalpanama", longestPalindrome("amanaplanacanalpanama"));
    }

    @Test
    public void test5() {
        Assert.assertEquals("aba", longestPalindrome("babad"));
    }

    @Test
    public void test8() {
        Assert.assertEquals("bb", longestPalindrome("cbbd"));
    }

    @Test
    public void test3() {
        Assert.assertEquals("c", longestPalindrome("ac"));
    }

    @Test
    public void test4() {
        Assert.assertEquals("a", longestPalindrome("a"));
    }
}
