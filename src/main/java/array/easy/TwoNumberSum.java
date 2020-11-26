package array.easy;

import org.junit.Assert;
import org.junit.Test;

public class TwoNumberSum {

    public static int[] twoNumberSum(int[] array, int targetSum) {

    }

    @Test
    public void verify() {
        Assert.assertArrayEquals(new int[]{-1, 11}, twoNumberSum(new int[]{3, 5, -4, 8, 11, 1, -1, 6}, 10));
    }
}
