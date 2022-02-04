package leetcode.medium.dp;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/palindrome-partitioning-ii/
public class PalindromePartitioningII {
    public int minCut(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i == 1 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                    }
                }
            }
        }

        int[] cuts = new int[s.length()];
        for (int j = 0; j < s.length(); j++) {
            int minimumCut = j;
            for (int i = 0; i <= j; i++) {
                if (dp[i][j]) {
                    minimumCut = i == 0 ? 0 : Math.min(minimumCut, cuts[i - 1] + 1);
                }
            }
            cuts[j] = minimumCut;
        }
        return cuts[s.length() - 1];
    }

    @Test
    public void test() {
        Assert.assertEquals(1, minCut("aab"));
    }

    @Test
    public void test2() {
        Assert.assertEquals(0, minCut("a"));
    }

    @Test
    public void test3() {
        Assert.assertEquals(0, minCut("racecar"));
    }

    @Test
    public void test4() {
        Assert.assertEquals(1, minCut("ab"));
    }

    @Test
    public void test5() {
        Assert.assertEquals(3, minCut("abdbca"));
    }

    @Test
    public void test6() {
        Assert.assertEquals(2, minCut("cddpd"));
    }

    @Test
    public void test7() {
        Assert.assertEquals(2, minCut("pqr"));
    }

    @Test
    public void test8() {
        Assert.assertEquals(0, minCut("pp"));
    }
}
