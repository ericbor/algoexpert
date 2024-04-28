package binarysearch;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/binary-search
public class BinarySearch {
    public static int binarySearch(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == array[mid]) {
                return mid;
            }

            if (target < array[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;  // Avoid potential overflow
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        if (start < nums.length && nums[start] == target) {  // Additional check for bounds
            return start;
        } else {
            return -1;
        }
    }

    public static int binarySearchRecursive(int[] array, int target) {
        return binarySearchHelper(array, target, 0, array.length - 1);
    }

    private static int binarySearchHelper(int[] array, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int middle = (left + right) / 2;
        int potentialMatch = array[middle];

        if (target == potentialMatch) {
            return middle;
        }

        if (target < potentialMatch) {
            return binarySearchHelper(array, target, left, middle - 1);
        } else {
            return binarySearchHelper(array, target, middle + 1, right);
        }
    }

    @Test
    public void verify() {
        Assert.assertEquals(3, binarySearch(new int[] { 0, 1, 21, 33, 45, 45, 61, 71, 72, 73 }, 33));
        Assert.assertEquals(3, binarySearchRecursive(new int[] { 0, 1, 21, 33, 45, 45, 61, 71, 72, 73 }, 33));
        Assert.assertEquals(3, search(new int[] { 0, 1, 21, 33, 45, 45, 61, 71, 72, 73 }, 33));
    }

    @Test
    public void verifyV2() {
        Assert.assertEquals(-1, binarySearch(new int[] { 1, 5, 23, 111 }, 35));
        Assert.assertEquals(-1, binarySearchRecursive(new int[] { 1, 5, 23, 111 }, 35));
    }
}
