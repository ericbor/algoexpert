package leetcode.medium.dp;

import org.junit.Assert;
import org.junit.Test;

//https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/B8rgqKEW05N
public class MaximumSumIncreasingSubsequence {
    public int findMSIS(int[] nums) {
        int[] dp = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            dp[i] = nums[i];
        }

        int maxSum = 0;
        for(int i = 1; i < nums.length; i ++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j] && dp[i] < dp[j] + nums[i]) {
                    dp[i] = dp[j] + nums[i];
                    maxSum = Math.max(maxSum, dp[i]);
                }
            }
        }

        return maxSum;
    }

    @Test
    public void test() {
        Assert.assertEquals(32, findMSIS(new int[]{4,1,2,6,10,1,12}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(25, findMSIS(new int[]{-4,10,3,7,15}));
    }
}
