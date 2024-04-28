package binarysearch;

import org.junit.Assert;
import org.junit.Test;

public class ThreeLargestNumbers {
    public static int[] findThreeLargestNumbers(int[] array) {
        int[] result = { Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE };

        for (int num : array) {
            updateLargest(result, num);
        }

        return result;
    }

    private static void updateLargest(int[] result, int num) {
        if (result[2] < num) {
            shiftAndUpdate(result, num, 2);
        } else if (result[1] < num) {
            shiftAndUpdate(result, num, 1);
        } else if (result[0] < num) {
            shiftAndUpdate(result, num, 0);
        }
    }

    private static void shiftAndUpdate(int[] result, int num, int index) {
        for (int i = 0; i <= index; i++) {
            if (i == index) {
                result[i] = num;
            } else {
                result[i] = result[i + 1];
            }
        }
    }

    @Test
    public void verify() {
        Assert.assertArrayEquals(new int[] { 18, 141, 541 }, findThreeLargestNumbers(new int[] { 141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7 }));
    }
}
