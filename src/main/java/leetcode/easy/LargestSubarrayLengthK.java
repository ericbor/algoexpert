package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/largest-subarray-length-k/
public class LargestSubarrayLengthK {
    public int[] largestSubarray(int[] nums, int k) {

        int maxIndex = Integer.MIN_VALUE;
        int maxValue = Integer.MIN_VALUE;

        int i = 0;
        while (i < nums.length) {

            if (nums[i] > maxValue) {
                if (i + k - 1 < nums.length) {
                    maxValue = nums[i];
                    maxIndex = i;
                } else {
                    break;
                }
            }
            i++;
        }

        int[] results = new int[k];
        for (int j = 0; j < results.length; j++) {
            results[j] = nums[maxIndex];
            maxIndex++;
        }

        return results;
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[] { 5 }, largestSubarray(new int[] { 1, 4, 5, 2, 3 }, 1));
    }

    @Test
    public void test2() {
        Assert.assertArrayEquals(new int[] { 5, 2, 3 }, largestSubarray(new int[] { 1, 4, 5, 2, 3 }, 3));
    }

    @Test
    public void test3() {
        Assert.assertArrayEquals(new int[] { 4, 5, 2, 3 }, largestSubarray(new int[] { 1, 4, 5, 2, 3 }, 4));
    }

    @Test
    public void test4() {
        Assert.assertArrayEquals(new int[] { 5, 2 }, largestSubarray(new int[] { 1, 4, 5, 2, 3 }, 2));
    }
}
