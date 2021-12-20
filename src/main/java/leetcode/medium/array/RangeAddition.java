package leetcode.medium.array;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/range-addition/
public class RangeAddition {

    //O(N*K), O(N)
    public int[] getModifiedArray2(int length, int[][] updates) {
        int[] results = new int[length];

        for (int[] update : updates) {
            for (int i = update[0]; i <= update[1]; i++) {
                results[i] += update[2];
            }
        }

        return results;
    }

    // O(N+K), O(N)
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] results = new int[length];

        for (int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int val = update[2];

            results[start] += val;
            if (end < length - 1) {
                results[end + 1] -= val;
            }
        }

        for (int i = 1; i < length; i++) {
            results[i] += results[i - 1];
        }

        return results;
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[] { -2, 0, 3, 5, 3 }, getModifiedArray(5, new int[][] { { 1, 3, 2 }, { 2, 4, 3 }, { 0, 2, -2 } }));
    }

    @Test
    public void test2() {
        Assert.assertArrayEquals(new int[] { 0, -4, 2, 2, 2, 4, 4, -4, -4, -4 }, getModifiedArray(10, new int[][] { { 2, 4, 6 }, { 5, 6, 8 }, { 1, 9, -4 } }));
    }
}
