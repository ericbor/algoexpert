package leetcode.medium.dp;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/longest-increasing-subsequence/
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;

        int maxLength = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                    maxLength = Math.max(maxLength, dp[i]);
                }
            }
        }

        return maxLength;
    }

    @Test
    public void test() {
        //[2,3,7,101]
        Assert.assertEquals(4, lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }));
    }

    @Test
    public void test2() {
        //[0,1,2,3]
        Assert.assertEquals(4, lengthOfLIS(new int[] { 0, 1, 0, 3, 2, 3 }));
    }

    @Test
    public void test3() {
        //[0,1,2,3]
        Assert.assertEquals(1, lengthOfLIS(new int[] { 7, 7, 7, 7, 7, 7, 7 }));
    }
}
