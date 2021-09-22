package educative.twopointers.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/*
Given an array arr of unsorted numbers and a target sum, count all triplets in it such that arr[i] + arr[j] + arr[k] < target where i, j, and k are three different indices. Write a function to return the count of such triplets.

Input: [-1, 0, 2, 3], target=3 ... Output: 2
Explanation: There are two triplets whose sum is less than the target: [-1, 0, 3], [-1, 0, 2]

Input: [-1, 4, 2, 1, 3], target=5 ... Output: 4
Explanation: There are four triplets whose sum is less than the target:
   [-1, 1, 4], [-1, 1, 3], [-1, 1, 2], [-1, 2, 3]
 */
public class TripletWithSmallerSum {

    public static int searchTriplets(int[] arr, int target) {
        int count = 0;
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;

            while (left < right) {
                int currentSum = arr[i] + arr[left] + arr[right];
                if (currentSum >= target) {
                    right--;
                } else {// Else move left corner
                    // This is important. For current i and j, there
                    // can be total k-j third elements.
                    count += right - left;
                    left++;
                }
            }
        }

        return count;
    }

    @Test
    public void verify() {
        Assert.assertEquals(4, searchTriplets(new int[] { -1, 4, 2, 1, 3 }, 5));
        Assert.assertEquals(2, searchTriplets(new int[] { -1, 0, 2, 3 }, 3));
    }
}
