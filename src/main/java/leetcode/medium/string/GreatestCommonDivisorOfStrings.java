package leetcode.medium.string;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/greatest-common-divisor-of-strings/
public class GreatestCommonDivisorOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        if (str1.length() < str2.length()) {
            return gcdOfStrings(str2, str1);
        }
        if (!str1.startsWith(str2)) {
            return ""; // shorter string is not common prefix.
        }
        if (str2.isEmpty()) {
            return str1;// gcd string found.
        }

        // cut off the common prefix part of str1.
        String substring = str1.substring(str2.length());
        return gcdOfStrings(substring, str2);
    }

    @Test
    public void test() {
        Assert.assertEquals("AB", gcdOfStrings("ABABAB", "ABAB"));
    }

    @Test
    public void test2() {
        Assert.assertEquals("ABC", gcdOfStrings("ABCABC", "ABC"));
    }

    @Test
    public void test3() {
        Assert.assertEquals("", gcdOfStrings("LEET", "CODE"));
    }

    @Test
    public void tes4() {
        Assert.assertEquals("AAAA", gcdOfStrings("AAAA", "AAAA"));
    }

    @Test
    public void tes5() {
        Assert.assertEquals("A", gcdOfStrings("AAAA", "AAA"));
    }
}
