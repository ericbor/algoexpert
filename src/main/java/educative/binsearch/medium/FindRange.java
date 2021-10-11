package educative.binsearch.medium;

import org.junit.Assert;
import org.junit.Test;

/*
Given an array of numbers sorted in ascending order, find the range of a given number ‘key’.
The range of the ‘key’ will be the first and last position of the ‘key’ in the array.

Write a function to return the range of the ‘key’. If the ‘key’ is not present return [-1, -1].

Input: [4, 6, 6, 6, 9], key = 6 ... Output: [1, 3]
Input: [1, 3, 8, 10, 15], key = 10 ... Output: [3, 3]
Input: [1, 3, 8, 10, 15], key = 12 ... Output: [-1, -1]
 */
public class FindRange {
    public static int[] findRange(int[] arr, int key) {
        int[] result = { -1, -1 };

        result[0] = find(arr, key, false);
        if (result[0] != -1) {
            result[1] = find(arr, key, true);
        }

        return result;
    }

    private static int find(int[] arr, int key, boolean findMaxIndex) {
        int start = 0;
        int end = arr.length - 1;
        int keyIndex = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (key < arr[mid]) {
                end = mid - 1;
            } else if (key > arr[mid]) {
                start = mid + 1;
            } else { // key == arr[mid]
                keyIndex = mid;
                if (findMaxIndex) {
                    start = mid + 1; // search ahead to find the last index of 'key'
                } else {
                    end = mid - 1; // search behind to find the first index of 'key'
                }
            }
        }

        return keyIndex;
    }

    @Test
    public void main() {
        Assert.assertArrayEquals(new int[] { 1, 3 }, findRange(new int[] { 4, 6, 6, 6, 9 }, 6));
        Assert.assertArrayEquals(new int[] { 3, 3 }, findRange(new int[] { 1, 3, 8, 10, 15 }, 10));
        Assert.assertArrayEquals(new int[] { -1, -1 }, findRange(new int[] { 1, 3, 8, 10, 15 }, 12));
    }
}
