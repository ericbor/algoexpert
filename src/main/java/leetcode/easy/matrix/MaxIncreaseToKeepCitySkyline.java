package leetcode.easy.matrix;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/max-increase-to-keep-city-skyline/
public class MaxIncreaseToKeepCitySkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] rowMaxes = new int[grid.length];
        int[] colMaxes = new int[grid.length];

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid.length; c++) {
                rowMaxes[r] = Math.max(rowMaxes[r], grid[r][c]);
                colMaxes[c] = Math.max(colMaxes[c], grid[r][c]);
            }
        }

        int increasesNum = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid.length; c++) {
                int maxIncrease = Math.min(rowMaxes[r], colMaxes[c]);
                int diff = maxIncrease - grid[r][c];

                increasesNum += diff;
            }
        }

        return increasesNum;
    }

    @Test
    public void test() {
        Assert.assertEquals(35, maxIncreaseKeepingSkyline(new int[][] { { 3, 0, 8, 4 }, { 2, 4, 5, 7 }, { 9, 2, 6, 3 }, { 0, 3, 1, 0 } }));
    }
}
