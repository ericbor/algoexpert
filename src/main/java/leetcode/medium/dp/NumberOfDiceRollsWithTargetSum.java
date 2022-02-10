package leetcode.medium.dp;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
public class NumberOfDiceRollsWithTargetSum {
    public int numRollsToTarget(int dice, int face, int target) {
        int mod = 1_000_000_007;

        long[] dp = new long[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= dice; i++) {
            for (int j = target; j >= 0; j--) {
                dp[j] = 0;
                for (int k = 1; k <= face; k++) {
                    if (j >= k) {
                        dp[j] = (dp[j] + dp[j - k]) % mod;
                    } else {
                        break;
                    }
                }
            }
        }
        return (int) dp[target];
    }

    @Test
    public void test() {
        Assert.assertEquals(1, numRollsToTarget(1, 6, 3));
    }

    @Test
    public void test2() {
        Assert.assertEquals(6, numRollsToTarget(2, 6, 7));
    }

    @Test
    public void test3() {
        Assert.assertEquals(222616187, numRollsToTarget(30, 30, 500));
    }
}
