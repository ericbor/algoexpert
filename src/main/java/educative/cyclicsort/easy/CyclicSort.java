package educative.cyclicsort.easy;

import org.junit.Assert;
import org.junit.Test;

/*
Input: [3, 1, 5, 4, 2] ... Output: [1, 2, 3, 4, 5]

Input: [2, 6, 4, 3, 1, 5] ... Output: [1, 2, 3, 4, 5, 6]
 */
public class CyclicSort {
    public static void sort(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int currVal = nums[i];
            if (nums[i] == nums[currVal - 1]) {
                i++;
            } else {
                swap(nums, i, currVal - 1);
            }
        }
    }

    private static void swap(int[] nums, int currentIndex, int correctIndex) {
        int tmp = nums[currentIndex];
        nums[currentIndex] = nums[correctIndex];
        nums[correctIndex] = tmp;
    }

    @Test
    public void verify() {
        int[] arr1 = { 3, 1, 5, 4, 2 };
        sort(arr1);
        Assert.assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, arr1);

        int[] arr2 = { 2, 6, 4, 3, 1, 5 };
        sort(arr2);
        Assert.assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6 }, arr2);
    }
}
