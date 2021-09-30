package educative.cyclicsort.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/*
We are given an unsorted array containing numbers taken from the range 1 to ‘n’. The array can have duplicates, which means some numbers will be missing. Find all those missing numbers.

Input: [2, 3, 1, 8, 2, 3, 5, 1] ... Output: 4, 6, 7
Explanation: The array should have all numbers from 1 to 8, due to duplicates 4, 6, and 7 are missing.

Input: [2, 4, 1, 2] ... Output: 3
 */
public class AllMissingNumbers {
    public static List<Integer> findNumbers(int[] nums) {

        int i = 0;
        while (i < nums.length) {
            int currVal = nums[i];
            if (nums[i] != nums[currVal - 1]) {
                swap(nums, i, currVal - 1);
            } else {
                i++;
            }
        }

        List<Integer> missingNumbers = new ArrayList<>();
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] != k + 1) {
                missingNumbers.add(k+1);
            }
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
        Assert.assertEquals(List.of(4, 6, 7), findNumbers(new int[] { 2, 3, 1, 8, 2, 3, 5, 1 }));
        Assert.assertEquals(List.of(3), findNumbers(new int[] { 2, 4, 1, 2 }));
        Assert.assertEquals(List.of(4), findNumbers(new int[] { 2, 3, 2, 1 }));
    }
}
