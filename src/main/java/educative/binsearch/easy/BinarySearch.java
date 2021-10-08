package educative.binsearch.easy;

import org.junit.Assert;
import org.junit.Test;

/*
Given a sorted array of numbers, find if a given number ‘key’ is present in the array.
Though we know that the array is sorted, we don’t know if it’s sorted in ascending or descending order.
You should assume that the array can have duplicates.

Write a function to return the index of the ‘key’ if it is present in the array, otherwise return -1.

Input: [4, 6, 10], key = 10
Output: 2
 */
public class BinarySearch {
    public static int search(int[] arr, int key) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int start = 0;
        int end = arr.length - 1;
        boolean isAscending = arr[start] < arr[end];

        while (start <= end) {
            // calculate the middle of the current range
            int mid = start + (end - start) / 2;

            if (key == arr[mid]) {
                return mid;
            }

            if (isAscending) {
                if (key < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (key > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return -1;
    }

    @Test
    public void main() {
        Assert.assertEquals(2, search(new int[] { 4, 6, 10 }, 10));
        Assert.assertEquals(4, search(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 5));
        Assert.assertEquals(0, search(new int[] { 10, 6, 4 }, 10));
        Assert.assertEquals(2, search(new int[] { 10, 6, 4 }, 4));
    }
}
