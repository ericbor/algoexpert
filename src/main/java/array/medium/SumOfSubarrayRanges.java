package array.medium;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/sum-of-subarray-ranges/
public class SumOfSubarrayRanges {
    public long subArrayRanges(int[] nums) {
        long res = 0;

        for (int i = 0; i < nums.length; i++) {
            int max = nums[i];
            int min = nums[i];

            for (int j = i; j < nums.length; j++) {
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
                res += max - min;
            }
        }

        return res;
    }

    @Test
    public void test() {
        Assert.assertEquals(4, subArrayRanges(new int[] { 1, 2, 3 }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(59, subArrayRanges(new int[] { 4, -2, -3, 4, 1 }));
    }
}
