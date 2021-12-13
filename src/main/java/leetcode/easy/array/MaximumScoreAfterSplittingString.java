package leetcode.easy.array;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/maximum-score-after-splitting-a-string/
public class MaximumScoreAfterSplittingString {
    public int maxScore(String s) {
        char[] arr = s.toCharArray();
        int ones = 0;
        int zeros = arr[0] == '0' ? 1 : 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == '1') {
                ones++;
            }
        }

        int maxScore = ones + zeros;
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] == '0') {
                zeros++;
            } else {
                ones--;
            }

            maxScore = Math.max(maxScore, ones + zeros);
        }

        return maxScore;
    }

    @Test
    public void test() {
        Assert.assertEquals(5, maxScore("011101"));
    }
}
