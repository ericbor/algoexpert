package array.medium;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/minimum-size-subarray-sum/
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int sum = 0;
        int minSize = Integer.MAX_VALUE;

        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];

            while (sum >= target) {
                minSize = Math.min(minSize, end - start + 1);
                sum -= nums[start];
                start++;
            }
        }

        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }

    @Test
    public void test() {
        Assert.assertEquals(2, minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
}
