package educative.binsearch.medium;

import org.junit.Assert;
import org.junit.Test;

/*
Given an array of numbers sorted in ascending order, find the element in the array that has the minimum difference with the given ‘key’.

Input: [4, 6, 10], key = 7 ... Output: 6
Explanation: The difference between the key '7' and '6' is minimum than any other number in the array

Input: [4, 6, 10], key = 4 ... Output: 4
Input: [1, 3, 8, 10, 15], key = 12 ... Output: 10
Input: [4, 6, 10], key = 17 ... Output: 10
 */
public class MinimumDifference {
    public static int searchMinDiffElement(int[] arr, int key) {
        if (key < arr[0]) {
            return arr[0];
        }
        if (key > arr[arr.length - 1]) {
            return arr[arr.length - 1];
        }

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (key > arr[mid]) {
                start = mid + 1;
            } else if (key < arr[mid]) {
                end = mid - 1;
            } else {
                return arr[mid];
            }
        }

        // at the end of the while loop, 'start == end+1'
        // we are not able to find the element in the given array - return the element which is closest to the 'key'
        int startDiff = arr[start] - key;
        int endDiff = key - arr[end];
        if (startDiff < endDiff) {
            return arr[start];
        }

        return arr[end];
    }

    @Test
    public void main1() {
        Assert.assertEquals(6, searchMinDiffElement(new int[] { 4, 6, 10 }, 7));
    }
    @Test
    public void main2() {
        Assert.assertEquals(4, searchMinDiffElement(new int[] { 4, 6, 10 }, 4));
    }
    @Test
    public void main3() {
        Assert.assertEquals(10, searchMinDiffElement(new int[] { 1, 3, 8, 10, 15 }, 12));
    }
    @Test
    public void main4() {
        Assert.assertEquals(10, searchMinDiffElement(new int[] { 4, 6, 10 }, 17));
    }
}
