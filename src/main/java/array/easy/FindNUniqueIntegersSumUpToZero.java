package array.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero
public class FindNUniqueIntegersSumUpToZero {
    public int[] sumZero(int n) {
        int[] results = new int[n];

        for (int i = 0; i < n - 1; i += 2) {
            results[i] = i + 1;
            results[i + 1] = -(i + 1);
        }

        return results;
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{1, -1, 3, -3, 5, -5}, sumZero(6));
        Assert.assertArrayEquals(new int[]{1, -1, 3, -3, 5, -5, 0}, sumZero(7));
    }
}
