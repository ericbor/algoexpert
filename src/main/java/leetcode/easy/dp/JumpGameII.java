package leetcode.easy.dp;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/jump-game-ii/
public class JumpGameII {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];

        //initialize with infinity, except the first index which should be zero as we start from there
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j <= i + nums[i] && j < nums.length; j++) {
                //min value between the current jump-count and the jumps needed to reach the current index + 1.
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }

        return dp[nums.length - 1];
    }

    @Test
    public void test() {
        Assert.assertEquals(4, jump(new int[] { 1, 1, 3, 6, 9, 3, 0, 1, 3 }));
    }

    @Test
    public void test3() {
        Assert.assertEquals(2, jump(new int[] { 2, 3, 1, 1, 4 }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(2, jump(new int[] { 2, 3, 0, 1, 4 }));
    }
}
