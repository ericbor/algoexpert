package array.medium;

import org.junit.Assert;
import org.junit.Test;

public class LongestPeak {
    public static int longestPeak(int[] array) {
        int longestPeak = 0;
        int i = 1;

        while (i < array.length - 1) {
            if (array[i - 1] < array[i] && array[i] > array[i + 1]) {
                int leftIndex = i - 2;
                while (leftIndex >= 0 && array[leftIndex] < array[leftIndex + 1]) {
                    leftIndex--;
                }

                int rightIndex = i + 2;
                while (rightIndex < array.length && array[rightIndex] < array[rightIndex - 1]) {
                    rightIndex++;
                }

                int currentPeakLength = rightIndex - leftIndex - 1;
                if (currentPeakLength > longestPeak) {
                    longestPeak = currentPeakLength;
                }

                i = rightIndex;
            } else {
                i++;
            }
        }

        return longestPeak;
    }

    @Test
    public void verify() {
        Assert.assertEquals(6, longestPeak(new int[] { 1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3 }));
    }
}
