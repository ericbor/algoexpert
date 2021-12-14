package leetcode.medium.array;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/maximum-product-subarray/
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int result = maxSoFar;

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int tempMax = Math.max(curr, Math.max(maxSoFar * curr, minSoFar * curr));
            minSoFar = Math.min(curr, Math.min(maxSoFar * curr, minSoFar * curr));

            maxSoFar = tempMax;

            result = Math.max(maxSoFar, result);
        }

        return result;
    }

    @Test
    public void test() {
        Assert.assertEquals(120, maxProduct(new int[]{2, -5, 3, 1, -4, 0, -10, 2, 8}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(6, maxProduct(new int[]{2,3,-2,4}));
    }

    @Test
    public void test3() {
        Assert.assertEquals(0, maxProduct(new int[]{-2, 0, -1}));
    }

    @Test
    public void test4() {
        Assert.assertEquals(24, maxProduct(new int[]{-2,3,-4}));
    }
}
