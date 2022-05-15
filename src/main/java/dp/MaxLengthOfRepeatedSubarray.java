package dp;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/maximum-length-of-repeated-subarray/
public class MaxLengthOfRepeatedSubarray {
    public int findLength(int[] A, int[] B) {
        int ans = 0;
        int[][] memo = new int[A.length + 1][B.length + 1];

        for (int i = A.length - 1; i >= 0; --i) {
            for (int j = B.length - 1; j >= 0; --j) {
                if (A[i] == B[j]) {
                    memo[i][j] = memo[i + 1][j + 1] + 1;
                    if (ans < memo[i][j]) {
                        ans = memo[i][j];
                    }
                }
            }
        }

        return ans;
    }

    @Test
    public void test() {
        Assert.assertEquals(3, findLength(new int[]{1,2,3,2,1}, new int[]{3,2,1,4,7}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(5, findLength(new int[]{0,0,0,0,0}, new int[]{0,0,0,0,0}));
    }
}
