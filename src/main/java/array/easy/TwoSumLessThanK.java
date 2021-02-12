package array.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

//https://leetcode.com/problems/two-sum-less-than-k/
public class TwoSumLessThanK {
    //Time: O(n log n), Space: O(n log n)
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);

        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        int maxSum = -1;
        while (leftIndex < rightIndex) {
            int currentSum = nums[leftIndex] + nums[rightIndex];
            if (currentSum < k) {
                /*if(sum > maxSum) {
                    maxSum = sum;
                } */
                maxSum = Math.max(maxSum, currentSum);
                leftIndex++;
            } else {
                rightIndex--;
            }
        }

        return maxSum;
    }

    @Test
    public void verify() {
        Assert.assertEquals(58, twoSumLessThanK(new int[] { 34, 23, 1, 24, 75, 33, 54, 8 }, 60));
    }
}
