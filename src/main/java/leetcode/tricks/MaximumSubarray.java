package leetcode.tricks;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/maximum-subarray/
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        // Initialize our variables using the first element.
        int currentSubarray = nums[0];
        int maxSubarray = nums[0];

        // Start with the 2nd element since we already used the first one.
        for (int i = 1; i < nums.length; i++) {

            currentSubarray = Math.max(currentSubarray + nums[i], nums[i]);
            maxSubarray = Math.max(maxSubarray, currentSubarray);
        }

        return maxSubarray;
    }

    @Test
    public void test() {
        Assert.assertEquals(6, maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
    }
}
