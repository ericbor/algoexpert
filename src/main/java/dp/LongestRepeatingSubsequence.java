package dp;

import org.junit.Assert;
import org.junit.Test;

//https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/7npz2VooPl1
public class LongestRepeatingSubsequence {
    public int findLRSLength(String str) {
        int[][] dp = new int[str.length() + 1][ str.length() + 1];
        int maxLength = 0;

        for(int i = 1; i <= str.length(); i++) {
            for(int j = 1; j <= str.length(); j++) {
                if(i != j && str.charAt(i - 1) == str.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }
        return maxLength;
    }

    @Test
    public void test() {
        Assert.assertEquals(2, findLRSLength("tomorrow"));
    }

    @Test
    public void test2() {
        Assert.assertEquals(3, findLRSLength("aabdbcec"));
    }

    @Test
    public void test3() {
        Assert.assertEquals(2, findLRSLength("fmff"));
    }
}
