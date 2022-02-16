package dp;

import org.junit.Assert;
import org.junit.Test;

//https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/RMkk7NwE44R
public class LongestCommonSubstring {
    public int findLCSLength(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int maxLength = 0;

        //see visual representation to understand, why we leave first rows and cols as '0'
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }

        return maxLength;
    }

    @Test
    public void test() {
        Assert.assertEquals(2, findLCSLength("abdca", "cbda"));
    }

    @Test
    public void test2() {
        Assert.assertEquals(3, findLCSLength("passport", "ppsspt"));
    }
}
