package educative.twopointers.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array of unsorted numbers and a target number, find all unique quadruplets in it, whose sum is equal to the target number.

Input: [4, 1, 2, -1, 1, -3], target=1 ... Output: [-3, -1, 1, 4], [-3, 1, 1, 2]
Input: [2, 0, -1, 1, -2, 2], target=2 ... Output: [-2, 0, 2, 2], [-1, 0, 1, 2]
 */
public class QuadrupleSumToTarget {
    public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> quadruplets = new ArrayList<>();
        for (int i = 0; i < arr.length - 3; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < arr.length - 2; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = arr.length - 1;
                while (left < right) {
                    int currentSum = arr[i] + arr[j] + arr[left] + arr[right];
                    if (currentSum == target) {
                        quadruplets.add(Arrays.asList(arr[i], arr[j], arr[left], arr[right]));
                        left++;
                        right--;

                        while (left < right && arr[left] == arr[left - 1]) {
                            left++; // skip same element to avoid duplicate quadruplets
                        }
                        while (left < right && arr[right] == arr[right + 1]) {
                            right--; // skip same element to avoid duplicate quadruplets
                        }
                    } else if (currentSum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return quadruplets;
    }

    @Test
    public void verify() {
        Assert.assertEquals(List.of(List.of(-3, -1, 1, 4), List.of(-3, 1, 1, 2)), searchQuadruplets(new int[] { 4, 1, 2, -1, 1, -3 }, 1));
        Assert.assertEquals(List.of(List.of(-2, 0, 2, 2), List.of(-1, 0, 1, 2)), searchQuadruplets(new int[] { 2, 0, -1, 1, -2, 2 }, 2));
    }
}
