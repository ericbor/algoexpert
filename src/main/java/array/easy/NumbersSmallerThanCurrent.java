package array.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
public class NumbersSmallerThanCurrent {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int currentValue = nums[i];
            for (int k = 0; k < nums.length; k++) {
                if (k != i) {
                    if (currentValue > nums[k]) {
                        result[i] += 1;
                    }
                }
            }
        }

        return result;
    }

    public int[] smallerNumbersThanCurrent2(int[] nums) {
        int[] freq = new int[101];
        //count each occurance
        for (int a : nums) {
            freq[a]++;
        }
        //calculate how many numbers are smaller
        for (int i = 1; i < freq.length; i++) {
            freq[i] += freq[i - 1];
        }
        // fill resulting array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            int index = nums[i] - 1;
            nums[i] = freq[index];
        }
        return nums;
    }

    @Test
    public void verify() {
        Assert.assertArrayEquals(new int[] { 4, 0, 1, 1, 3 }, smallerNumbersThanCurrent2(new int[] { 8, 1, 2, 2, 3 }));
    }
}
