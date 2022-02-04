package leetcode.medium.dp;

import org.junit.Assert;
import org.junit.Test;

//https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/gkX4prBkRLj
public class MinimumDeletionsToMakeStringPalindrome {
    public int findMinimumDeletions(String st) {
        // subtracting the length of Longest Palindromic Subsequence from the length of
        // the input string to get minimum number of deletions
        return st.length() - findLPSLength(st);
    }

    private int findLPSLength(String s) {
        int[][] dp = new int[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }

        return dp[0][s.length() - 1];
    }

    @Test
    public void test() {
        Assert.assertEquals(2, findMinimumDeletions("cddpd"));
    }

    @Test
    public void test2() {
        Assert.assertEquals(2, findMinimumDeletions("pqr"));
    }
}
