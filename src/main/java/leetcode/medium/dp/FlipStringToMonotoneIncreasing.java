package leetcode.medium.dp;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/flip-string-to-monotone-increasing/
public class FlipStringToMonotoneIncreasing {
    // O(N), O(1)
    public int minFlipsMonoIncr(String s) {
        int minFlips = 0;
        int ones = 0;
        for (char c : s.toCharArray()) {
            //if c is 1, then it will not inpact the minFlips
            if (c == '1') {
                ones++;
            } else {
                // if c is 0, then 2 options we can do to make it mono incr
                // 1. keep it as 0, and flip all the preceeding 1 to 0, need to know the count of ones so far
                // 2. flip it to 1, will not need to do anything
                minFlips++;
            }

            minFlips = Math.min(minFlips, ones);
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
