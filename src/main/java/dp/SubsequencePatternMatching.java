package dp;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/number-of-matching-subsequences/
public class SubsequencePatternMatching {
    public int findSPMCount(String str, String pat) {
        // every empty pattern has one match
        if (pat.isEmpty()) {
            return 1;
        }

        if (str.isEmpty() || pat.length() > str.length()) {
            return 0;
        }

        // dp[strIndex][patIndex] will be storing the count of SPM up to str[0..strIndex-1][0..patIndex-1]
        int[][] dp = new int[str.length() + 1][pat.length() + 1];

        // for the empty pattern, we have one matching
        for (int i = 0; i <= str.length(); i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= str.length(); i++) {
            for (int j = 1; j <= pat.length(); j++) {
                if (str.charAt(i - 1) == pat.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                dp[i][j] += dp[i - 1][j];
            }
        }

        return dp[str.length()][pat.length()];
    }

    @Test
    public void test() {
        Assert.assertEquals(3, findSPMCount("baxmx", "ax"));
    }
}
