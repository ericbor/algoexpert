package array.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/kth-missing-positive-number/
public class KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        // if the kth missing is less than arr[0]
        if (k <= arr[0] - 1) {
            return k;
        }
        int kIndex = k - (arr[0] - 1);

        // search kth missing between the array numbers
        for (int i = 0; i < arr.length - 1; ++i) {
            // missing between arr[i] and arr[i + 1]
            int currMissing = arr[i + 1] - arr[i] - 1;
            // if the kth missing is between
            // arr[i] and arr[i + 1] -> return it
            if (kIndex <= currMissing) {
                return arr[i] + kIndex;
            }
            // otherwise, proceed further
            kIndex -= currMissing;
        }

        // if the missing number if greater than arr[n - 1]
        return arr[arr.length - 1] + kIndex;
    }

    public int findKthPositive2(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int pivot = left + (right - left) / 2;
            // If number of positive integers
            // which are missing before arr[pivot]
            // is less than k -->
            // continue to search on the right.
            if (arr[pivot] - pivot - 1 < k) {
                left = pivot + 1;
                // Otherwise, go left.
            } else {
                right = pivot - 1;
            }
        }

        // At the end of the loop, left = right + 1,
        // and the kth missing is in-between arr[right] and arr[left].
        // The number of integers missing before arr[right] is
        // arr[right] - right - 1 -->
        // the number to return is
        // arr[right] + k - (arr[right] - right - 1) = k + left
        return left + k;
    }

    @Test
    public void verify() {
        //Assert.assertEquals(9, findKthPositive(new int[] { 2, 3, 4, 7, 11 }, 5));
        //Assert.assertEquals(6, findKthPositive(new int[] { 1,2,3,4 }, 2));
        Assert.assertEquals(9, findKthPositive2(new int[] { 2, 3, 4, 7, 11 }, 5));
        //Assert.assertEquals(6, findKthPositive2(new int[] { 1,2,3,4 }, 2));
    }
}
