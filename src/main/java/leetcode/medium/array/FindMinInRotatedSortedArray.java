package leetcode.medium.array;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
public class FindMinInRotatedSortedArray {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        if (nums.length == 1) {
            return nums[start];
        }

        //[0,1,2,3] - no rotation
        if (nums[end] > nums[start]) {
            return nums[start];
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            //[4, 5, 6, 7, 0, 1, 2] : 7 > 0
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            //[5, 6, 7, 0, 1, 2, 4] : 0 < 7
            if (nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }

            if (nums[mid] > nums[0]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    @Test
    public void test() {
        Assert.assertEquals(0, findMin(new int[] { 0, 1, 2, 4, 5, 6, 7 }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(0, findMin(new int[] { 4, 5, 6, 7, 0, 1, 2 }));
    }

    @Test
    public void test3() {
        Assert.assertEquals(0, findMin(new int[] { 5, 6, 7, 0, 1, 2, 4 }));
    }

    @Test
    public void test4() {
        Assert.assertEquals(0, findMin(new int[] { 1, 2, 4, 5, 6, 7, 0 }));
    }

    @Test
    public void test5() {
        Assert.assertEquals(0, findMin(new int[] { 7, 0, 1, 2, 4, 5, 6 }));
    }
}
