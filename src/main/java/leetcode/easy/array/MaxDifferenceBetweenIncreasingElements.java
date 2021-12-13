package leetcode.easy.array;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/maximum-difference-between-increasing-elements/
public class MaxDifferenceBetweenIncreasingElements {
    public int maximumDifference(int[] nums) {
        int diff = -1;
        int min = nums[0];

        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > min) {
                diff = Math.max(diff, nums[i] - min);
            }
            min = Math.min(min, nums[i]);
        }
        return diff;
    }

    @Test
    public void test() {
        Assert.assertEquals(4, maximumDifference(new int[] { 7, 1, 5, 4 }));
    }
}
