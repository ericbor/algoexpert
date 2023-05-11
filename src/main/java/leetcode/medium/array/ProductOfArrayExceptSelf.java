package leetcode.medium.array;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/product-of-array-except-self/
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf2(int[] nums) {

        int[] prefixProduct = new int[nums.length];
        prefixProduct[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            prefixProduct[i] = nums[i - 1] * prefixProduct[i - 1];
        }

        int[] suffixProduct = new int[nums.length];
        suffixProduct[suffixProduct.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            suffixProduct[i] = nums[i + 1] * suffixProduct[i + 1];
        }

        int[] results = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            results[i] = prefixProduct[i] * suffixProduct[i];
        }

        return results;
    }

    public int[] productExceptSelf(int[] nums) {

        int[] results = new int[nums.length];
        results[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            results[i] = results[i - 1] * nums[i - 1];
        }

        int suffixProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            results[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }

        return results;
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{24, 12, 8, 6}, productExceptSelf2(new int[]{1, 2, 3, 4}));
    }

    @Test
    public void test2() {
        Assert.assertArrayEquals(new int[]{0, 0, 9, 0, 0}, productExceptSelf2(new int[]{-1, 1, 0, -3, 3}));
    }
}
