package array.easy;

//https://leetcode.com/problems/running-sum-of-1d-array/
public class RunningSum {
    //Time: O(n), Space O(n)
    public int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];

        for(int i = 1; i < nums.length; i++) {
            result[i] = nums[i] + result[i - 1];
        }

        return result;
    }

    //Time: O(n), Space O(1)
    public int[] runningSum2(int[] nums) {
        for (int i = 1; i <= nums.length - 1; i++) {
            nums[i] = nums[i-1] + nums[i];
        }
        return nums;
    }
}
