package dp;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations/
public class MaxScoreFromPerformingMultiplicationOperations {
    public int maximumScore(int[] nums, int[] multipliers) {
        int[][] dp = new int[multipliers.length + 1][multipliers.length + 1];

        for (int i = multipliers.length - 1; i >= 0; i--) {
            for (int left = i; left >= 0; left--) {
                int mult = multipliers[i];
                int right = nums.length - 1 - (i - left);

                int fromLeft = mult * nums[left] + dp[i + 1][left + 1];
                int fromRight = mult * nums[right] + dp[i + 1][left];

                dp[i][left] = Math.max(fromLeft, fromRight);
            }
        }

        return dp[0][0];
    }

    @Test
    public void test() {
        Assert.assertEquals(102, maximumScore(new int[] { -5, -3, -3, -2, 7, 1 }, new int[] { -10, -5, 3, 4, 6 }));
    }
}
