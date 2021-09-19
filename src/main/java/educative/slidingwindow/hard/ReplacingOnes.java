package educative.slidingwindow.hard;

import org.junit.Assert;
import org.junit.Test;


public class ReplacingOnes {
    public static int findLength(int[] arr, int k) {
        int windowStart = 0;
        int maxLength = 0;
        int maxOnesCount = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            if (arr[windowEnd] == 1) {
                maxOnesCount++;
            }

            int currentWindowSize = windowEnd - windowStart + 1;
            if (currentWindowSize - maxOnesCount > k) {
                if (arr[windowStart] == 1) {
                    maxOnesCount--;
                }

                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }

    @Test
    public void verify() {
        //Assert.assertEquals(6, findLength(new int[] {0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1}, 2)); //Replace the '0' at index 5 and 8
        Assert.assertEquals(9, findLength(new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3)); //Replace the '0' at index 6, 9, and 10

    }
}
