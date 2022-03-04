package dp;

import org.junit.Assert;
import org.junit.Test;

public class PartitionEqualSubsetSum {
    // O(mn), O(mn)
    Boolean[][] memo;

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;
        memo = new Boolean[nums.length + 1][sum + 1];

        return recMemo(nums, 0, sum);
    }

    private boolean recMemo(int[] nums, int i, int sum) {
        if (sum == 0) {
            return true;
        }
        if (sum < 0 || i == nums.length) {
            return false;
        }

        //if the (index, sum) pair was checked - return the result
        if (memo[i][sum] != null) {
            return memo[i][sum];
        }

        //if we can find sum WITH nums[i] element
        boolean res = recMemo(nums, i + 1, sum - nums[i]) || recMemo(nums, i + 1, sum);
        memo[i][sum] = res;

        return res;
    }

    @Test
    public void test() {
        Assert.assertTrue(canPartition(new int[] { 1, 2, 3, 4 }));
    }

    @Test
    public void test3() {
        Assert.assertTrue(canPartition(new int[] { 1, 5, 11, 5 }));
    }

    @Test
    public void test2() {
        Assert.assertFalse(canPartition(new int[] { 1, 2, 3, 5 }));
    }
}
