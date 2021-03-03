package array.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/maximum-subarray
public class MaximunSubarray {
    public int maxSubArray(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private int helper(int[] nums, int leftIdx, int rightIdx) {
        if (leftIdx == rightIdx) {
            return nums[leftIdx];
        }

        int pivot = (leftIdx + rightIdx) / 2;
        int leftSum = helper(nums, leftIdx, pivot);
        int rightSum = helper(nums, pivot + 1, rightIdx);
        int crossSum = crossSum(nums, leftIdx, rightIdx, pivot);

        return Math.max(Math.max(leftSum, rightSum), crossSum);
    }

    private int crossSum(int[] nums, int leftIdx, int rightIdx, int pivot) {
        if (leftIdx == rightIdx) {
            return nums[leftIdx];
        }

        int leftSubsum = Integer.MIN_VALUE;
        int currrentSum = 0;
        for (int i = pivot; i > leftIdx - 1; i--) {
            currrentSum += nums[i];
            leftSubsum = Math.max(leftSubsum, currrentSum);
        }

        int rightSubsum = Integer.MIN_VALUE;
        currrentSum = 0;
        for (int i = pivot + 1; i < rightIdx + 1; i++) {
            currrentSum += nums[i];
            rightSubsum = Math.max(rightSubsum, currrentSum);
        }

        return leftSubsum + rightSubsum;
    }

    public int maxSubArrayGreedy(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for(int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public int maxSubArrayDP(int[] nums) {
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
            maxSum = Math.max(nums[i], maxSum);
        }

        return maxSum;

    }

    @Test
    public void verify() {
        //Assert.assertEquals(6, maxSubArray(new int[]{ -2,1,-3,4,-1,2,1,-5,4}));
        //Assert.assertEquals(6, maxSubArrayGreedy(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
        Assert.assertEquals(6, maxSubArrayDP(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
    }
}
