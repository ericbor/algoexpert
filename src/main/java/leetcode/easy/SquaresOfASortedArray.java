package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/squares-of-a-sorted-array/
public class SquaresOfASortedArray {
    public int[] sortedSquares666(int[] nums) {

        if(nums.length == 1) {
            nums[0] = nums[0] * nums[0];
            return nums;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            if (Math.abs(nums[start]) > Math.abs(nums[end])) {
                swap(nums, start, end);
            }

            nums[end] = nums[end] * nums[end];
            end--;

            if (Math.abs(nums[start]) < Math.abs(nums[start + 1])) {
                nums[start] = nums[start] * nums[start];
                start++;
            }
        }

        return nums;
    }

    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int start = 0;
        int end = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            int startSquare = nums[start] * nums[start];
            int endSquare = nums[end] * nums[end];

            if (endSquare > startSquare) {
                result[i] = endSquare;
                end--;
            } else {
                result[i] = startSquare;
                start++;
            }

        }
        return result;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    @Test
    public void tes2() {
        Assert.assertArrayEquals(new int[] { 0, 1, 9, 16, 100 }, sortedSquares(new int[] { -4, -1, 0, 3, 10 }));
    }

    @Test
    public void test3() {
        Assert.assertArrayEquals(new int[] { 1, 4, 9, 25 }, sortedSquares(new int[] { -5, -3, -2, -1 }));
    }

    @Test
    public void test4() {
        Assert.assertArrayEquals(new int[] { 1, 4 }, sortedSquares(new int[] {1,2 }));
    }

    @Test
    public void test5() {
        Assert.assertArrayEquals(new int[] { 1, 4 }, sortedSquares(new int[] {-2,1 }));
    }

    @Test
    public void test6() {
        Assert.assertArrayEquals(new int[] { 1 }, sortedSquares(new int[] {1 }));
    }
}
