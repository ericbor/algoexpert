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

    public String longestPalindromeDP(String s) {
        //'true' if the string from index 'i' to index 'j' is a palindrome
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        int maxLength = 1;
        int start = 0;
        int end = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    // if it's a two character string or if the remaining string is a palindrome too
                    if (j - i == 1 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;

                        int currLength = j - i + 1;
                        if (currLength > maxLength) {
                            maxLength = currLength;
                            start = i;
                            end = j;
                        }
                    }
                }
            }
        }

        return s.substring(start, end + 1);
    }

    private int start = 0;
    private int maxLength = 0;

    public String longestPalindrome3(String s) {
        for(int i = 0; i < s.length() - 1; i++) {
            expand(s, i, i);
            expand(s, i, i + 1);
        }

        return s.substring(start, start + maxLength);
    }

    private void expand(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        if(right - left - 1 > maxLength) {
            maxLength = right - left - 1;
            start = left + 1;
        }
    }

    @Test
    public void test() {
        Assert.assertEquals("racecar", longestPalindrome("racecar"));
        Assert.assertEquals("racecar", longestPalindromeDP("racecar"));
        Assert.assertEquals("racecar", longestPalindrome3("racecar"));
    }

    @Test
    public void test2() {
        Assert.assertEquals("abba", longestPalindrome("abba"));
        Assert.assertEquals("abba", longestPalindromeDP("abba"));
    }

    @Test
    public void test7() {
        Assert.assertEquals("aca", longestPalindrome("aacabdkacaa"));
        Assert.assertEquals("aca", longestPalindromeDP("aacabdkacaa"));
    }

    @Test
    public void test6() {
        Assert.assertEquals("amanaplanacanalpanama", longestPalindrome("amanaplanacanalpanama"));
        Assert.assertEquals("amanaplanacanalpanama", longestPalindromeDP("amanaplanacanalpanama"));
    }

    @Test
    public void test5() {
        Assert.assertEquals("aba", longestPalindrome("babad"));
        Assert.assertEquals("aba", longestPalindromeDP("babad"));
    }

    @Test
    public void test8() {
        Assert.assertEquals("bb", longestPalindromeDP("cbbd"));
        Assert.assertEquals("bb", longestPalindrome3("cbbd"));
    }

    @Test
    public void test3() {
        Assert.assertEquals("a", longestPalindromeDP("ac"));
    }

    @Test
    public void test4() {
        Assert.assertEquals("a", longestPalindromeDP("a"));
    }
}
