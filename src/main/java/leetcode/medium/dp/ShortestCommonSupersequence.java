package leetcode.medium.dp;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/shortest-common-supersequence/
public class ShortestCommonSupersequence {
    public int shortestCommonSupersequence(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i <= str1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= str2.length(); i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[str1.length()][str2.length()];
    }

    @Test
    public void test() {
        //"cabac"
        Assert.assertEquals(5, shortestCommonSupersequence("abac", "cab"));
    }

    @Test
    public void test2() {
        //"abdcf"
        Assert.assertEquals(5, shortestCommonSupersequence("abcf", "bdcf"));
    }

    @Test
    public void test3() {
        //"dynprogrammicng"
        Assert.assertEquals(15, shortestCommonSupersequence("dynamic", "programming"));
    }
}
