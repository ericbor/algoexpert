package educative.twopointers.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/*
Given an array of unsorted numbers and a target number, find a triplet in the array whose sum is as close to the target number as possible, return the sum of the triplet. If there are more than one such triplet, return the sum of the triplet with the smallest sum.

Input: [-2, 0, 1, 2], target=2 ... Output: 1
Explanation: The triplet [-2, 1, 2] has the closest sum to the target.

Input: [-3, -1, 1, 2], target=1 ... Output: 0
Explanation: The triplet [-3, 1, 2] has the closest sum to the target.

Input: [1, 0, 1, 1], target=100 ... Output: 3
Explanation: The triplet [1, 1, 1] has the closest sum to the target.
 */
public class TripletSumCloseToTarget {
    public static int searchTriplet(int[] arr, int targetSum) {
        Arrays.sort(arr);
        int smallestDifference = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;
            while (left < right) {
                int currentSum = arr[i] + arr[left] + arr[right];
                int currentDiff = targetSum - currentSum;
                if (Math.abs(currentDiff) < Math.abs(smallestDifference)) {
                    smallestDifference = currentDiff;
                }

                if (currentSum < targetSum) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return targetSum - smallestDifference;
    }

    @Test
    public void verify() {
        //Assert.assertEquals(1, searchTriplet(new int[] { -2, 0, 1, 2 }, 2));
        Assert.assertEquals(0, searchTriplet(new int[] { -3, -1, 1, 2 }, 1));
        //Assert.assertEquals(3, searchTriplet(new int[] { 1, 0, 1, 1 }, 100));
    }
}
