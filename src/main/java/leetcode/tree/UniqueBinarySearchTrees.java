package leetcode.tree;

import org.junit.Assert;
import org.junit.Test;

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int level = 2; level <= n; level++) {
            for (int root = 1; root <= level; root++) {
                dp[level] += dp[level - root] * dp[root - 1];
            }
        }
        return dp[n];
    }

    @Test
    public void test() {
        Assert.assertEquals(5, numTrees(3));
    }

    @Test
    public void test2() {
        Assert.assertEquals(1, numTrees(1));
    }
}
