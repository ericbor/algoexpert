package array.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/maximum-size-subarray-sum-equals-k
public class MaximumSizeSubarraySumEqualsK {
    public int maxSubArrayLen(int[] nums, int k) {
        int prefixSum = 0;
        int longestSubarray = 0;

        Map<Integer, Integer> indices = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            // Check if all the numbers seen so far sum to k.
            if (prefixSum == k) {
                longestSubarray = i + 1;
            }

            // If any subarray seen so far sums to k, then
            // update the length of the longest_subarray.
            if (indices.containsKey(prefixSum - k)) {
                longestSubarray = Math.max(longestSubarray, i - indices.get(prefixSum - k));
            }

            // Only add the current prefix_sum index pair to the
            // map if the prefix_sum is not already in the map.
            if (!indices.containsKey(prefixSum)) {
                indices.put(prefixSum, i);
            }
        }

        return longestSubarray;
    }

    @Test
    public void test() {
        Assert.assertEquals(4, maxSubArrayLen(new int[]{1, -1, 5, -2, 3}, 3));
    }

    @Test
    public void test2() {
        Assert.assertEquals(2, maxSubArrayLen(new int[]{-2, -1, 2, 1}, 1));
    }


}
