package array;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero
public class MinimumOperationsToReducexToZero {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int maxLength = -1;
        int currSum = 0;
        int start = 0;
        for (int end = 0; end < nums.length; end++) {
            currSum += nums[end];
            while (start <= end && currSum > sum - x) {
                currSum -= nums[start];
                start++;
            }
            if (currSum == sum - x) {
                maxLength = Math.max(maxLength, end - start + 1);
            }
        }

        return maxLength == -1 ? -1 : nums.length - maxLength;
    }

    @Test
    public void test() {
        Assert.assertEquals(2, minOperations(new int[]{1,1,4,2,3}, 5));
    }
}
