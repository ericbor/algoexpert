package dp;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/uncrossed-lines/
public class UncrossedLines {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];

        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[nums1.length][nums2.length];
    }

    @Test
    public void test() {
        Assert.assertEquals(2, maxUncrossedLines(new int[] { 1, 4, 2 }, new int[] { 1, 2, 4 }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(3, maxUncrossedLines(new int[] { 2, 5, 1, 2, 5 }, new int[] { 10, 5, 2, 1, 5, 2 }));
    }

    @Test
    public void test3() {
        Assert.assertEquals(3, maxUncrossedLines(new int[] { 1, 3, 7, 1, 7, 5 }, new int[] { 1, 9, 2, 5, 1 }));
    }
}
