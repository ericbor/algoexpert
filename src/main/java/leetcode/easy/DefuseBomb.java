package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/defuse-the-bomb/
public class DefuseBomb {
    public int[] decrypt(int[] code, int k) {
        int[] results = new int[code.length];
        if (k == 0) {
            return results;
        }

        if (k > 0) {
            for (int i = 0; i < results.length; i++) {
                results[i] = getNextSum(code, i + 1, k);
            }

        } else {
            for (int i = 0; i < results.length; i++) {
                results[i] = getPrevSum(code, i - 1, Math.abs(k));
            }
        }

        return results;
    }

    private int getPrevSum(int[] code, int j, int iterations) {
        int sum = 0;
        while (iterations > 0) {
            if (j < 0) {
                j = code.length - 1;
            }
            sum += code[j];
            j--;
            iterations--;
        }

        return sum;
    }

    private int getNextSum(int[] code, int j, int iterations) {
        int sum = 0;
        while (iterations > 0) {
            if (j >= code.length) {
                j = 0;
            }
            sum += code[j];
            j++;
            iterations--;
        }

        return sum;
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[] { 12, 10, 16, 13 }, decrypt(new int[] { 5, 7, 1, 4 }, 3));
    }

    @Test
    public void test2() {
        Assert.assertArrayEquals(new int[] { 12, 5, 6, 13 }, decrypt(new int[] { 2, 4, 9, 3 }, -2));
    }
}
