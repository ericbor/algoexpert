package leetcode.medium.dp;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/house-robber/
public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
        }

        return dp[nums.length];
    }

    @Test
    public void test() {
        Assert.assertEquals(4, rob(new int[] { 2, 1, 1, 2 }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(2, rob(new int[] { 2 }));
    }

    @Test
    public void test3() {
        Assert.assertEquals(10, rob(new int[] { 2, 10 }));
    }

    @Test
    public void test4() {
        Assert.assertEquals(10, rob(new int[] { 10, 2 }));
    }

    @Test
    public void test5() {
        Assert.assertEquals(4, rob(new int[] { 1, 2, 3, 1 }));
    }

    @Test
    public void test6() {
        Assert.assertEquals(12, rob(new int[] { 2, 7, 9, 3, 1 }));
    }
}
