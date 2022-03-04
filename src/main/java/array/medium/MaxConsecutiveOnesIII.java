package array.medium;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/max-consecutive-ones-iii/
public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        int longestOnes = 0;
        int zeroCount = 0;
        int start = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {
                if (nums[start] == 0) {
                    zeroCount--;
                }
                start++;
            }

            longestOnes = Math.max(longestOnes, i - start + 1);
        }

        return longestOnes;
    }

    @Test
    public void test() {
        Assert.assertEquals(6, longestOnes(new int[] { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 }, 2));
    }
}
