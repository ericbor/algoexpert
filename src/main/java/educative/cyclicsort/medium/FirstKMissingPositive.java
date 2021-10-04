package educative.cyclicsort.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/*
Given an unsorted array containing numbers and a number ‘k’, find the first ‘k’ missing positive numbers in the array.

Input: [3, -1, 4, 5, 5], k=3 ... Output: [1, 2, 6]
Explanation: The smallest missing positive numbers are 1, 2 and 6.

Input: [2, 3, 4], k=3 ... Output: [1, 5, 6]
Input: [-2, -3, 4], k=2 ... Output: [1, 2]
 */
public class FirstKMissingPositive {
    public static List<Integer> findNumbers(int[] nums, int k) {
        int i = 0;
        int maxNum = Integer.MIN_VALUE;

        while (i < nums.length) {
            int currVal = nums[i];
            maxNum = Math.max(maxNum, currVal);
            if (currVal > 0 && currVal <= nums.length && currVal != nums[currVal - 1]) {
                swap(nums, i, currVal - 1);
            } else {
                i++;
            }
        }

        List<Integer> missingNumbers = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                if (missingNumbers.size() < k) {
                    missingNumbers.add(j + 1);
                } else {
                    break;
                }
            }
        }

        int lastNumValue = nums[nums.length - 1];
        while (missingNumbers.size() < k) {
            maxNum++;
            missingNumbers.add(maxNum);
        }

        return missingNumbers;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    @Test
    public void verify() {
        Assert.assertEquals(List.of(1, 2, 6), findNumbers(new int[] { 3, -1, 4, 5, 5 }, 3));
        Assert.assertEquals(List.of(1, 5, 6), findNumbers(new int[] { 2, 3, 4 }, 3));
        Assert.assertEquals(List.of(1, 2), findNumbers(new int[] { -2, -3, 4 }, 2));
    }
}
