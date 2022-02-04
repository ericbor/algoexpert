package leetcode.hard;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
public class MinInsertionStepsToMakePalindrome {

    public int minInsertions(String s) {
        return s.length() - findLPS(s);
    }

    private int findLPS(String s) {
        int[][] dp = new int[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][s.length() - 1];
    }

    @Test
    public void test() {
        Assert.assertEquals(0, minInsertions("zzazz"));
    }

    @Test
    public void test2() {
        Assert.assertEquals(2, minInsertions("mbadm"));
    }

    @Test
    public void test3() {
        Assert.assertEquals(5, minInsertions("leetcode"));
    }
}
