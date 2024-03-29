package leetcode.medium.string;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/palindromic-substrings/
public class PalindromicSubstrings {
    private int counter = 0;

    public int countSubstrings(String s) {

        for (int i = 0; i < s.length(); ++i) {
            // odd-length palindromes, single character center
            countPalindromesAroundCenter(s, i, i);

            // even-length palindromes, consecutive characters center
            countPalindromesAroundCenter(s, i, i + 1);
        }

        return counter;
    }

    private void countPalindromesAroundCenter(String ss, int left, int right) {
        while (left >= 0 && right < ss.length() && ss.charAt(left) == ss.charAt(right)) {
            left--;
            right++;

            counter++;
        }
    }

    public int countSubstringsDP(String s) {
        int counter = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            counter++;
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i == 1 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        counter++;
                    }
                }
            }
        }

        return counter;

    }

    @Test
    public void test6() {
        Assert.assertEquals(10, countSubstrings("racecar"));
    }

    @Test
    public void test5() {
        Assert.assertEquals(3, countSubstrings("pqr"));
    }

    @Test
    public void test4() {
        Assert.assertEquals(7, countSubstrings("cddpd"));
    }

    @Test
    public void test() {
        Assert.assertEquals(7, countSubstrings("abdbca"));
    }

    @Test
    public void test3() {
        Assert.assertEquals(3, countSubstrings("abc"));
        Assert.assertEquals(3, countSubstringsDP("abc"));
    }

    @Test
    public void test2() {
        Assert.assertEquals(6, countSubstrings("aaa"));
        Assert.assertEquals(6, countSubstringsDP("aaa"));
    }
}
