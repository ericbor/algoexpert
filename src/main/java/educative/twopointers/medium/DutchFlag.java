package educative.twopointers.medium;

import org.junit.Assert;
import org.junit.Test;

/*
Given an array containing 0s, 1s and 2s, sort the array in-place. You should treat numbers of the array as objects, hence, we can’t count 0s, 1s, and 2s to recreate the array.

Input: [1, 0, 2, 1, 0] ... Output: [0 0 1 1 2]
Input: [2, 2, 0, 1, 2, 0] ... Output: [0 0 1 2 2 2 ]
 */
public class DutchFlag {
    public static void sort(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        for (int i = 0; i <= high; ) {
            if (arr[i] == 0) {
                swap(arr, i, low);
                i++;
                low++;
            } else if (arr[i] == 1) {
                i++;
            } else { //arr[i] == 2
                swap(arr, i, high);
                // decrement 'high' only, after the swap the number at index 'i' could be 0, 1 or 2
                high--;
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
