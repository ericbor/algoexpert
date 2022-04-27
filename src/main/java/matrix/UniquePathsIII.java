package matrix;

import org.junit.Assert;
import org.junit.Test;

public class UniquePathsIII {
    int pathCount = 0;
    int zeros = 0;
    int row;
    int col;

    public int uniquePathsIII(int[][] grid) {


        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 0) {
                    zeros++;
                } else if (grid[i][j] == 1) {
                    row = i;
                    col = j;
                }
            }
        }

        dfs(grid, row, col);

        return pathCount;
    }

    public void dfs(int[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] < 0) {
            return;
        }

        if (grid[r][c] == 2) {
            if (zeros == -1) {
                pathCount++;
            }
            return;
        }

        grid[r][c] = -2;
        zeros--;
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);

        grid[r][c] = 0;
        zeros++;
    }

    @Test
    public void test() {
        Assert.assertEquals(2, uniquePathsIII(new int[][] { { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 2, -1 } }));
    }
}
