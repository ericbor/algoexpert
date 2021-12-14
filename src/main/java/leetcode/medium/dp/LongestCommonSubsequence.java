package leetcode.medium.dp;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/longest-common-subsequence/
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {

        int[][] dpGrid = new int[text1.length() + 1][text2.length() + 1];

        // Iterate up each column, starting from the last one.
        for (int col = text2.length() - 1; col >= 0; col--) {
            char t2 = text2.charAt(col);

            for (int row = text1.length() - 1; row >= 0; row--) {
                // If the corresponding characters for this cell are the same...
                char t1 = text1.charAt(row);

                if (t1 == t2) {
                    dpGrid[row][col] = 1 + dpGrid[row + 1][col + 1];
                } else {
                    // Otherwise, they must be different...
                    dpGrid[row][col] = Math.max(dpGrid[row + 1][col], dpGrid[row][col + 1]);
                }
            }
        }

        return dpGrid[0][0];
    }

    @Test
    public void test() {
        Assert.assertEquals(2, longestCommonSubsequence("ezupkr", "ubmrapg"));
    }
}
