package educative.slidingwindow.easy;

import org.junit.Assert;
import org.junit.Test;

/*
Given an array of positive numbers and a positive number ‘S,’ find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’.
Return 0 if no such subarray exists.

Input: [2, 1, 5, 2, 3, 2], S=7 ... Output: 2
Explanation: The smallest subarray with a sum greater than or equal to '7' is [5, 2].

Input: [3, 4, 1, 1, 6], S=8 ... Output: 3
Explanation:  [3, 4, 1] or [1, 1, 6].
 */
public class MinSizeSubArraySum {
    public static int findMinSubArray(int S, int[] arr) {
        int windowStart = 0;
        int minLength = Integer.MAX_VALUE;
        int currentSum = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            currentSum += arr[windowEnd];

            while (currentSum >= S) {
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                currentSum -= arr[windowStart];
                windowStart++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    @Test
    public void verify() {
        Assert.assertEquals(2, findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 }));
        Assert.assertEquals(1, findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 }));
        Assert.assertEquals(3, findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 }));
    }
}
