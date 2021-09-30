package educative.cyclicsort.easy;

import org.junit.Assert;
import org.junit.Test;

/*
We are given an array containing ‘n’ distinct numbers taken from the range 0 to ‘n’.
Since the array has only ‘n’ numbers out of the total ‘n+1’ numbers, find the missing number.

Input: [4, 0, 3, 1] ... Output: 2
Input: [8, 3, 5, 2, 4, 6, 0, 1] ... Output: 7
 */
public class MissingNumber {
    public static int findMissingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int currValue = nums[i];
            if (currValue < nums.length && currValue != nums[currValue]) {
                swap(nums, i, currValue);
            } else {
                i++;
            }
        }

        for (int k = 0; k < nums.length; k++) {
            if (nums[k] != k) {
                return k;
            }
        }

        return -1;
    }

    private static void swap(int[] nums, int currentIndex, int correctIndex) {
        int tmp = nums[currentIndex];
        nums[currentIndex] = nums[correctIndex];
        nums[correctIndex] = tmp;
    }

    @Test
    public void verify() {
        Assert.assertEquals(2, findMissingNumber(new int[] { 4, 0, 3, 1 }));

        Assert.assertEquals(7, findMissingNumber(new int[] { 8, 3, 5, 2, 4, 6, 0, 1 }));
    }
}


