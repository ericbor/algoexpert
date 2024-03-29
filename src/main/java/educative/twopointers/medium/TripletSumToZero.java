package educative.twopointers.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array of unsorted numbers, find all unique triplets in it that add up to zero.

Input: [-3, 0, 1, 2, -1, 1, -2] ... Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
Explanation: There are four unique triplets whose sum is equal to zero.

Input: [-5, 2, -1, -2, 3] ... Output: [[-5, 2, 3], [-2, -1, 3]]
Explanation: There are two unique triplets whose sum is equal to zero.
 */
public class TripletSumToZero {
    public static List<List<Integer>> searchTriplets(int[] arr) {
        Arrays.sort(arr);

        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            searchTriplets(arr, -arr[i], i + 1, triplets);
        }
        return triplets;
    }

    private static void searchTriplets(int[] arr, int targetSum, int left, List<List<Integer>> triplets) {
        int right = arr.length - 1;

        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum == targetSum) { //found the triplet
                triplets.add(List.of(-targetSum, arr[left], arr[right]));

                left++;
                right--;

                while (left < right && arr[left] == arr[left - 1]) {
                    left++;// skip same element to avoid duplicate triplets
                }

                while (left < right && arr[right] == arr[right + 1]) {
                    right--;// skip same element to avoid duplicate triplets
                }
            } else if (targetSum > currentSum) {
                left++; // we need a pair with a bigger sum
            } else {
                right--; // we need a pair with a smaller sum
            }
        }
    }

    @Test
    public void verify() {
        Assert.assertEquals(List.of(List.of(-3, 1, 2), List.of(-2, 0, 2), List.of(-2, 1, 1), List.of(-1, 0, 1)), searchTriplets(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
        Assert.assertEquals(List.of(List.of(-5, 2, 3), List.of(-2, -1, 3)), searchTriplets(new int[] { -5, 2, -1, -2, 3 }));
    }
}
