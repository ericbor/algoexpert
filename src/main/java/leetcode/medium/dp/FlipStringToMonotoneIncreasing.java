package leetcode.medium.dp;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/flip-string-to-monotone-increasing/
public class FlipStringToMonotoneIncreasing {
    // O(N), O(1)
    public int minFlipsMonoIncr(String s) {
        char[] arr = s.toCharArray();
        int zeros = 0;
        for (char c : arr) {
            if (c == '0') {
                zeros++;
            }
        }

        int minFlips = Math.min(zeros, arr.length - zeros); // zeros or ones, whichever is less
        int ones = 0;
        for (char c : arr) {
            if (c == '1') {
                ones++;
            } else {
                zeros--;
            }

            minFlips = Math.min(minFlips, ones + zeros);
        }

        return minFlips;
    }

    @Test
    public void test() {
        Assert.assertEquals(1, minFlipsMonoIncr("00110"));
    }

    @Test
    public void test2() {
        Assert.assertEquals(2, minFlipsMonoIncr("010110"));
    }

    @Test
    public void test3() {
        Assert.assertEquals(2, minFlipsMonoIncr("00011000"));
    }
}
