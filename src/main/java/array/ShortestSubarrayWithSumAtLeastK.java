package array;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/
public class ShortestSubarrayWithSumAtLeastK {
    //TODO: fix to work with negative numbers
    public int shortestSubarray(int[] nums, int k) {
        int shortest = Integer.MAX_VALUE;
        int start = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= k) {
                shortest = Math.min(shortest, i - start + 1);
                sum -= nums[start];
                start++;
            }
        }

        return shortest == Integer.MAX_VALUE ? -1 : shortest;
    }

    @Test
    public void test() {
        Assert.assertEquals(3, shortestSubarray(new int[]{84, -37, 32, 40, 95}, 167));
    }
}
