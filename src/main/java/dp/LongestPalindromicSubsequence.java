package dp;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/longest-palindromic-subsequence/
public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String st) {
        // dp[i][j] stores the length of LPS from index 'i' to index 'j'
        int[][] dp = new int[st.length()][st.length()];

        // every sequence with one element is a palindrome of length 1
        for (int i = 0; i < st.length(); i++) {
            dp[i][i] = 1;
        }

        for (int i = st.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < st.length(); j++) {
                // case 1: elements at the beginning and the end are the same
                if (st.charAt(i) == st.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else { // case 2: skip one element either from the beginning or the end
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][st.length() - 1];
    }

    @Test
    public void test() {
        Assert.assertEquals(3, longestPalindromeSubseq("cddpd"));
    }

    @Test
    public void test2() {
        Assert.assertEquals(2, longestPalindromeSubseq("cbbd"));
    }
}
