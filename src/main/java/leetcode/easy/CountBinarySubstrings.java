package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/count-binary-substrings/
public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        int ans = 0;
        int prev = 0;
        int cur = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                cur++;
            } else {
                ans += Math.min(prev, cur);
                prev = cur;
                cur = 1;
            }
        }
        return ans + Math.min(prev, cur);
    }

    @Test
    public void test() {
        Assert.assertEquals(6, countBinarySubstrings("00110011"));
    }
}
