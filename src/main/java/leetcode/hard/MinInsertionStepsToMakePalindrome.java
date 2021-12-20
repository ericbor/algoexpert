package leetcode.hard;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
public class MinInsertionStepsToMakePalindrome {

    public int minInsertions(String s) {
        String reversed = new StringBuilder(s).reverse().toString();

        int[][] dp = new int[s.length() + 1][reversed.length() + 1];

        for (int row = 1; row < s.length() + 1; row++) {
            char sChar = s.charAt(row - 1);
            for (int col = 1; col < reversed.length() + 1; col++) {

                char rChar = reversed.charAt(col - 1);
                if (sChar == rChar) {
                    dp[row][col] = 1 + dp[row - 1][col - 1];
                } else {
                    dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1]);
                }

            }
        }

        return s.length() - dp[s.length()][reversed.length()];
    }

    @Test
    public void test() {
        Assert.assertEquals(0, minInsertions("zzazz"));
    }

    @Test
    public void test2() {
        Assert.assertEquals(2, minInsertions("mbadm"));
    }

    @Test
    public void test3() {
        Assert.assertEquals(5, minInsertions("leetcode"));
    }
}
