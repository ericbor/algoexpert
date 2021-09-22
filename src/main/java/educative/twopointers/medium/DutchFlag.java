package educative.twopointers.medium;

import org.junit.Assert;
import org.junit.Test;

/*
Given an array containing 0s, 1s and 2s, sort the array in-place. You should treat numbers of the array as objects, hence, we can’t count 0s, 1s, and 2s to recreate the array.

Input: [1, 0, 2, 1, 0] ... Output: [0 0 1 1 2]
Input: [2, 2, 0, 1, 2, 0] ... Output: [0 0 1 2 2 2 ]
 */
public class DutchFlag {

    public void sort(int[] arr) {
        int low = 0;
        int current = 0;
        int high = arr.length - 1;

        while (current <= high) {
            if (arr[current] == 0) {
                swap(arr, current, low);
                low++;
                current++;
            } else if (arr[current] == 2) {
                swap(arr, current, high);
                high--;
            } else {
                current++;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    @Test
    public void verify() {
        int[] arr1 = { 1, 0, 2, 1, 0 };
        sort(arr1);
        Assert.assertArrayEquals(new int[] { 0, 0, 1, 1, 2 }, arr1);
        int[] arr2 = { 2, 2, 0, 1, 2, 0 };
        sort(arr2);
        Assert.assertArrayEquals(new int[] { 0, 0, 1, 2, 2, 2 }, arr2);
    }
}
