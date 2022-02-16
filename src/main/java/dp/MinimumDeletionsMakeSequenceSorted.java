package dp;

import org.junit.Assert;
import org.junit.Test;

//https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/qV251wjM2ZD
public class MinimumDeletionsMakeSequenceSorted {
    public int findMinimumDeletions(int[] nums) {
        int[] dp = new int[nums.length];

        int deletions = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] < nums[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                    deletions = Math.max(deletions, dp[i]);
                }
            }
        }

        return deletions;
    }

    @Test
    public void test() {
        Assert.assertEquals(2, findMinimumDeletions(new int[] { 4, 2, 3, 6, 10, 1, 12 }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(1, findMinimumDeletions(new int[] { -4, 10, 3, 7, 15 }));
    }

    @Test
    public void test3() {
        Assert.assertEquals(3, findMinimumDeletions(new int[] { 3, 2, 1, 0 }));
    }
}
