package array.medium;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/missing-element-in-sorted-array/
public class MissingElementInSortedArray {
    public int missingElement_2(int[] nums, int k) {
        int missing = 0;

        for (int i = 1; i < nums.length; i++) {
            int val = nums[i - 1];
            while (val != nums[i] - 1 && k != 0) {
                val++;
                k--;
                missing = val;
            }
        }

        int lastVal = nums[nums.length - 1];
        while (k != 0) {
            lastVal++;
            k--;
            missing = lastVal;
        }

        return missing;
    }

    public int missingElement(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            int tmp = nums[mid] - nums[start] - (mid - start); //total number of missing numbers between nums[mid] and nums[start]

            if (tmp >= k) {
                end = mid;
            } else {
                start = mid;
                k -= tmp;
            }
        }

        if (nums[start] + k >= nums[end]) {
            return nums[start] + k + 1;
        }
        return nums[start] + k;
    }

    @Test
    public void test() {
        Assert.assertEquals(5, missingElement(new int[] { 4, 7, 9, 10 }, 1));
    }

    @Test
    public void test2() {
        Assert.assertEquals(8, missingElement(new int[] { 4, 7, 9, 10 }, 3));
    }

    @Test
    public void test3() {
        Assert.assertEquals(6, missingElement(new int[] { 1, 2, 4 }, 3));
    }
}
