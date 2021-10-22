package leetcode.easy.matrix;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/island-perimeter/
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int i = 0; i < grid[row].length; i++) {
                if (grid[row][i] == 1) {
                    int up = 0;
                    if (row != 0 && grid[row - 1][i] == 1) {
                        up = 1;
                    }

                    int down = 0;
                    if (row != grid.length - 1 && grid[row + 1][i] == 1) {
                        down = 1;
                    }

                    int left = 0;
                    if (i != 0 && grid[row][i - 1] == 1) {
                        left = 1;
                    }

                    int right = 0;
                    if (i != grid[row].length - 1 && grid[row][i + 1] == 1) {
                        right = 1;
                    }

                    int currentPerimeter = 4 - up - down - left - right;
                    perimeter += currentPerimeter;

                }
            }
        }

        return perimeter;
    }

    @Test
    public void test() {
        Assert.assertEquals(16, islandPerimeter(new int[][] { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } }));
    }
}
