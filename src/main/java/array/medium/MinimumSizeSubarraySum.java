package array.medium;

//https://leetcode.com/problems/minimum-size-subarray-sum/
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int currSum = 0;
        int minSize = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];

            while (currSum >= target) {
                minSize = Math.min(minSize, i - start + 1);
                currSum -= nums[start];
                start++;
            }

        }

        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }
}
