package leetcode.medium.dp;

import org.junit.Assert;
import org.junit.Test;

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        // dp[mIndex][nIndex] will be storing the result of string interleaving up to p[0..mIndex+nIndex-1]
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

        // make sure if lengths of the strings add up
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                // if 'm' and 'n' are empty, then 'p' must have been empty too.
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0 && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    // if 'm' is empty, we need to check the interleaving with 'n' only
                    dp[i][j] = dp[i][j - 1];
                } else if (j == 0 && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    // if 'n' is empty, we need to check the interleaving with 'm' only
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // if the letter of 'm' and 'p' match, we take whatever is matched till i-1
                    if (i > 0 && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                        dp[i][j] = dp[i - 1][j];
                    }
                    // if the letter of 'n' and 'p' match, we take whatever is matched till j-1 too
                    // note the '|=', this is required when we have common letters
                    if (j > 0 && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                        dp[i][j] |= dp[i][j - 1];
                    }
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    @Test
    public void test() {
        Assert.assertTrue(isInterleave("abd", "cef", "abcdef"));
    }

    @Test
    public void test2() {
        Assert.assertTrue(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }
}
