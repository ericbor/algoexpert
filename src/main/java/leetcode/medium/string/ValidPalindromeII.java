package leetcode.medium.string;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/valid-palindrome-ii/
public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return isPalindrome(s, start + 1, end) || isPalindrome(s, start, end - 1);
            }
            start++;
            end--;
        }

        return true;
    }
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    @Test
    public void test() {
        Assert.assertTrue(validPalindrome("acxcybycxcxa"));
    }

    @Test
    public void test7() {
        Assert.assertTrue(validPalindrome("lcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupucul"));
    }

    @Test
    public void test2() {
        Assert.assertFalse(validPalindrome("tebbem"));
    }

    @Test
    public void test3() {
        Assert.assertTrue(validPalindrome("deeee"));
    }

    @Test
    public void test4() {
        Assert.assertTrue(validPalindrome("aba"));
    }

    @Test
    public void test5() {
        Assert.assertTrue(validPalindrome("abca"));
    }

    @Test
    public void test6() {
        Assert.assertFalse(validPalindrome("abc"));
    }
}
