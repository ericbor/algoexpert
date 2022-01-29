package leetcode.easy.string;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/count-binary-substrings/
public class CountBinarySubstrings {
    public int countBinarySubstrings2(String s) {
        int[] groups = new int[s.length()];
        int currGroup = 0;
        groups[currGroup] = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                groups[currGroup]++;
            } else {
                currGroup++;
                groups[currGroup] = 1;
            }
        }

        int totalCounter = 0;
        for (int i = 1; i <= currGroup; i++) {
            totalCounter += Math.min(groups[i - 1], groups[i]);
        }
        return totalCounter;
    }

    public int countBinarySubstrings(String s) {
        int totalCounter = 0;
        int prev = 0;
        int cur = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                cur++;
            } else {
                totalCounter += Math.min(prev, cur);
                prev = cur;
                cur = 1;
            }
        }

        return totalCounter + Math.min(prev, cur);
    }

    @Test
    public void test() {
        Assert.assertEquals(6, countBinarySubstrings("00110011"));
        Assert.assertEquals(6, countBinarySubstrings2("00110011"));
    }

    @Test
    public void test2() {
        Assert.assertEquals(4, countBinarySubstrings("10101"));
        Assert.assertEquals(4, countBinarySubstrings2("10101"));
    }

    @Test
    public void test3() {
        Assert.assertEquals(0, countBinarySubstrings("0"));
    }

    @Test
    public void test4() {
        Assert.assertEquals(0, countBinarySubstrings("1"));
    }

    @Test
    public void test5() {
        Assert.assertEquals(1, countBinarySubstrings("001"));
    }

    @Test
    public void test6() {
        Assert.assertEquals(1, countBinarySubstrings("11111111111111111111111111111111111111111111110"));
    }
}
