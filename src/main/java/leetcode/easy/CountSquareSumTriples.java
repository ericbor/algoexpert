package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/count-square-sum-triples/
public class CountSquareSumTriples {
    public int countTriples(int n) {
        int counter = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int sq = (i * i) + (j * j);
                int sqRoot = (int) Math.sqrt(sq);

                if (sqRoot * sqRoot == sq && sqRoot <= n) {
                    counter += 2;
                }
            }
        }
        return counter;
    }

    @Test
    public void test() {
        Assert.assertEquals(2, countTriples(5));
    }
}
