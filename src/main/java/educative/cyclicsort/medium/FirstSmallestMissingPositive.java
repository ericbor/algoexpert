package educative.cyclicsort.medium;

import org.junit.Assert;
import org.junit.Test;

/*
Given an unsorted array containing numbers, find the smallest missing positive number in it.

Input: [-3, 1, 5, 4, 2] ... Output: 3
Explanation: The smallest missing positive number is '3'

Input: [3, -2, 0, 1, 2] ... Output: 4
Input: [3, 2, 5, 1] ... Output: 4
 */
public class FirstSmallestMissingPositive {
    public static int findNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int currVal = nums[i];
            if (currVal > 0 && currVal <= nums.length && currVal != nums[currVal - 1]) {
                swap(nums, i, currVal - 1);
            } else {
                i++;
            }
        }

        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Test
    public void verify() {
        Assert.assertEquals(3, findNumber(new int[] { -3, 1, 5, 4, 2 }));
        Assert.assertEquals(4, findNumber(new int[] { 3, -2, 0, 1, 2 }));
        Assert.assertEquals(4, findNumber(new int[] { 3, 2, 5, 1 }));
    }
}
