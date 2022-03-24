package array;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/maximum-swap/
public class MaximumSwap {

    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();

        int[] buckets = new int[10];
        for (int i = 0; i < digits.length; i++) {
            buckets[(int) digits[i] - (int) '0'] = i;
        }

        for (int i = 0; i < digits.length; i++) {
            int curr = (int) digits[i] - (int) '0';

            for (int k = 9; k > curr; k--) {
                if (buckets[k] > i) {
                    char tmp = digits[i];
                    digits[i] = digits[buckets[k]];
                    digits[buckets[k]] = tmp;
                    return Integer.parseInt(new String(digits));
                }
            }
        }

        return num;
    }

    @Test
    public void test() {
        Assert.assertEquals(7236, maximumSwap(2736));
    }

    @Test
    public void test2() {
        Assert.assertEquals(9973, maximumSwap(9973));
    }
}
