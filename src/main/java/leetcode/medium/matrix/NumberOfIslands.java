package leetcode.medium.matrix;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/number-of-islands/
public class NumberOfIslands {
    public int numIslands2(char[][] grid) {
        Queue<int[]> landCoordinates = new LinkedList<>();
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        int totalIslands = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {

                if (grid[row][col] == '1' && !seen[row][col]) {
                    seen[row][col] = true;
                    landCoordinates.add(new int[] { row, col });

                    while (!landCoordinates.isEmpty()) {
                        int[] coordinates = landCoordinates.poll();
                        int currRow = coordinates[0];
                        int currCol = coordinates[1];

                        for (int[] direction : directions) {
                            int r = currRow + direction[0];
                            int c = currCol + direction[1];

                            if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && !seen[r][c] && grid[r][c] == '1') {
                                seen[r][c] = true;
                                landCoordinates.add(new int[] { r, c });
                            }
                        }
                    }

                    totalIslands++;
                }
            }
        }

        return totalIslands;
    }

    public int numIslands(char[][] grid) {
        int totalIslands = 0;
        if (grid == null || grid.length == 0) {
            return totalIslands;
        }

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {

                if (grid[row][col] == '1') {
                    totalIslands++;
                    dfs(grid, row, col);
                }
            }
        }

        return totalIslands;
    }

    public void dfs(char[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }

    @Test
    public void test() {
        Assert.assertEquals(1, numIslands(new char[][] {
            { '1', '1', '1', '1', '0' },
            { '1', '1', '0', '1', '0' },
            { '1', '1', '0', '0', '0' },
            { '0', '0', '0', '0', '0' }
        }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(3, numIslands(new char[][] {
            { '1', '1', '0', '0', '0' },
            { '1', '1', '0', '0', '0' },
            { '0', '0', '1', '0', '0' },
            { '0', '0', '0', '1', '1' }
        }));
    }
}
