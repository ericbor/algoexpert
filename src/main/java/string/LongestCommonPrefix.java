package string;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/longest-common-prefix
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }

    @Test
    public void test3() {
        Assert.assertEquals("", longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }

    @Test
    public void test2() {
        Assert.assertEquals("a", longestCommonPrefix(new String[]{"a"}));
    }

    @Test
    public void test() {
        Assert.assertEquals("fl", longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }
}
