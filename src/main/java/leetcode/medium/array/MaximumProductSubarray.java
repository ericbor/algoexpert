package leetcode.medium.array;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/maximum-product-subarray/
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int currProduct = nums[0];
        int maxProduct = nums[0];

        for(int i = 1; i < nums.length; i++) {
            currProduct = Math.max(nums[i], currProduct * nums[i]);
            maxProduct = Math.max(maxProduct, currProduct);
        }

        return maxProduct;
    }

    @Test
    public void test() {
        Assert.assertEquals(24, maxProduct(new int[]{-2,3,-4}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(6, maxProduct(new int[]{2,3,-2,4}));
    }

    @Test
    public void test3() {
        Assert.assertEquals(0, maxProduct(new int[]{-2, 0, 1}));
    }
}
