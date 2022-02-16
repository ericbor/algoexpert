package dp;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

//https://leetcode.com/problems/coin-change/
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }

        return coinChange(coins, amount, new int[amount + 1]);
    }

    private int coinChange(int[] coins, int remainder, int[] dp) {
        if (remainder < 0) {
            return -1;
        }

        if (remainder == 0) {
            return 0;
        }

        if (dp[remainder] != 0) {
            return dp[remainder];
        }

        //No answer yet. Try each coin as the last coin in the change that we make for the amount
        int minimum = Integer.MAX_VALUE;
        for (int coin: coins) {
            int changeResult = coinChange(coins, remainder - coin, dp);

            if (changeResult >= 0 && changeResult < minimum) {
                minimum = 1 + changeResult;
            }
        }

        dp[remainder] = minimum == Integer.MAX_VALUE ? -1 : minimum;

        return dp[remainder];
    }

    public int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    @Test
    public void test() {
        Assert.assertEquals(3, coinChange(new int[] { 1, 2, 5 }, 11));
        Assert.assertEquals(3, coinChange2(new int[] { 1, 2, 5 }, 11));
    }

    @Test
    public void test2() {
        Assert.assertEquals(-1, coinChange(new int[] { 2 }, 3));
    }

    @Test
    public void test3() {
        Assert.assertEquals(0, coinChange(new int[] { 1 }, 0));
    }
}
