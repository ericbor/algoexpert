package leetcode.easy.dp;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/climbing-stairs/
public class ClimbingStairs {
    public int climbStairs2(int n) {
        int[] memo = new int[n + 1];

        return count(0, n, memo);
    }

    public int count(int i, int n, int[] memo) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }

        int oneStep = count(i + 1, n, memo);
        int twoStep = count(i + 2, n, memo);
        memo[i] = oneStep + twoStep;

        return memo[i];
    }

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    @Test
    public void test() {
        Assert.assertEquals(21, climbStairs2(7));
        Assert.assertEquals(21, climbStairs(7));
    }
}
