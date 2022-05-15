package other;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/number-of-times-binary-string-is-prefix-aligned/
public class NumberOfTimesBinaryStringIsPrefixAligned {
    public int numTimesAllBlue(int[] flips) {
        int rightMax = 0;
        int res = 0;

        for (int i = 0; i < flips.length; ++i) {
            rightMax = Math.max(rightMax, flips[i]);
            if (rightMax == i + 1) {
                res++;
            }
        }

        return res;
    }

    @Test
    public void test() {
        Assert.assertEquals(2, numTimesAllBlue(new int[] { 3, 2, 4, 1, 5 }));
    }
}
