package dp;

import org.junit.Assert;
import org.junit.Test;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        // if 'sum' is a an odd number, we can't have two subsets with same total
        if (totalSum % 2 != 0) {
            return false;
        }

        // we are trying to find a subset of given numbers that has a total sum of ‘sum/2’.
        totalSum /= 2;

        boolean[][] dp = new boolean[nums.length][totalSum + 1];

        // populate the sum=0 column, as we can always have '0' sum without including any element
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }

        // with only one number, we can form a subset only when the required sum is equal to its value
        for (int s = 1; s <= totalSum; s++) {
            dp[0][s] = nums[0] == s;
        }

        // process all subsets for all sums
        for (int i = 1; i < nums.length; i++) {
            for (int s = 1; s <= totalSum; s++) {
                // if we can get the sum 's' without the number at index 'i'
                if (dp[i - 1][s]) {
                    dp[i][s] = dp[i - 1][s];
                } else if (s >= nums[i]) { // else if we can find a subset to get the remaining sum
                    dp[i][s] = dp[i - 1][s - nums[i]];
                }
            }
        }

        // the bottom-right corner will have our answer.
        return dp[nums.length - 1][totalSum];
    }

    @Test
    public void test() {
        Assert.assertTrue(canPartition(new int[] { 1, 5, 11, 5 }));
    }

    @Test
    public void test2() {
        Assert.assertFalse(canPartition(new int[] { 1, 2, 3, 5 }));
    }
}
