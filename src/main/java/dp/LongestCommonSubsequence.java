package dp;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/longest-common-subsequence/
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {

        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int row = 1; row < dp.length; row++) {
            for (int col = 1; col < dp[0].length; col++) {
                if (text1.charAt(row - 1) == text2.charAt(col - 1)) {
                    dp[row][col] = 1 + dp[row - 1][col - 1];
                } else {
                    dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }

    @Test
    public void test() {
        Assert.assertEquals(2, longestCommonSubsequence("ezupkr", "ubmrapg"));
    }
}
