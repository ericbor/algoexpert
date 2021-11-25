package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/n-th-tribonacci-number/
public class TribonacciNumber {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n < 3) {
            return 1;
        }

        int[] trib = new int[n + 1];
        trib[1] = 1;
        trib[2] = 1;

        for (int i = 3; i < trib.length; i++) {
            trib[i] = trib[i - 1] + trib[i - 2] + trib[i - 3];
        }

        return trib[trib.length - 1];
    }

    @Test
    public void test() {
        Assert.assertEquals(4, tribonacci(4));
    }
}
