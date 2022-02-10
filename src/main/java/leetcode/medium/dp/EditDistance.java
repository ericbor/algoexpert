package leetcode.medium.dp;

import org.junit.Assert;
import org.junit.Test;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        // if s2 is empty, we can remove all the characters of s1 to make it empty too
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }

        // if s1 is empty, we have to insert all the characters of s2
        for (int j = 0; j <= word2.length(); j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], //delete
                        Math.min(dp[i][j - 1], //insert
                            dp[i - 1][j - 1]));//replace
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }

    @Test
    public void test() {
        Assert.assertEquals(3, minDistance("horse", "ros"));
    }
}
