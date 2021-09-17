package educative.slidingwindow.easy;

import org.junit.Assert;
import org.junit.Test;

public class MaxSumSubArrayOfSizeK {
    public static int findMaxSumSubArray(int k, int[] arr) {
        int currentSum = 0;
        int maxSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            currentSum += arr[windowEnd];

            if (windowEnd >= k - 1) {
                maxSum = Math.max(maxSum, currentSum);
                /*if (currentSum > maxSum) {
                    maxSum = currentSum;
                }*/

                currentSum -= arr[windowStart];
                windowStart++;
            }
        }
        return maxSum;
    }

    @Test
    public void verify() {
        int result = findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 });
        Assert.assertEquals(9, result);
    }
}
