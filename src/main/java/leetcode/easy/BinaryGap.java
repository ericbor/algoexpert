package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/binary-gap/
public class BinaryGap {
    public int binaryGap(int n) {
        char[] bits = Integer.toBinaryString(n).toCharArray();

        int nIndex = 0;
        while(bits[nIndex] != '1') {
            nIndex++;
        }

        int longest = 0;
        for(int i = nIndex + 1; i < bits.length; i++) {
            if(bits[i] == '1') {
                int currDistance = i - nIndex;
                longest = Math.max(longest, currDistance);
                nIndex = i;
            }
        }

        return longest;
    }

    @Test
    public void test() {
        Assert.assertEquals(0, binaryGap(8));
    }

    @Test
    public void test2() {
        Assert.assertEquals(2, binaryGap(22));
    }
}
