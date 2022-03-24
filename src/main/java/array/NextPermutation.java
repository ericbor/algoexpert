package array;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/next-permutation/
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        //Find longest non-increasing suffix
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            //Find rightmost successor to i
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start;
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void test() {
        int[] arr = { 1, 3, 2 };
        nextPermutation(arr);
        Assert.assertArrayEquals(new int[] { 2, 1, 3 }, arr);
    }

    @Test
    public void test2() {
        int[] arr = { 1, 2, 3 };
        nextPermutation(arr);
        Assert.assertArrayEquals(new int[] { 1, 3, 2 }, arr);
    }

    @Test
    public void test3() {
        int[] arr = { 1, 1, 5 };
        nextPermutation(arr);
        Assert.assertArrayEquals(new int[] { 1, 5, 1 }, arr);
    }
}
