package array.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/max-consecutive-ones/
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums != null && nums.length == 1) {
            return nums[0];
        }
        int maxCount = 0;
        int currentCount = 0;

        for (int num : nums) {
            if (num == 0) {
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                }
                currentCount = 0;
            } else {
                currentCount++;
            }
        }

        return Math.max(currentCount, maxCount);
    }

    @Test
    public void verify() {
        Assert.assertEquals(2, findMaxConsecutiveOnes(new int[] { 1, 0, 1, 1, 0, 1 }));
        Assert.assertEquals(1, findMaxConsecutiveOnes(new int[] { 1 }));
        Assert.assertEquals(0, findMaxConsecutiveOnes(new int[] { 0 }));
        Assert.assertEquals(1, findMaxConsecutiveOnes(new int[] { 0, 1 }));
        Assert.assertEquals(2, findMaxConsecutiveOnes(new int[] { 1, 0, 1, 1 }));
        Assert.assertEquals(2, findMaxConsecutiveOnes(new int[] { 1, 0, 1, 1, 0, 1 }));
    }
}
