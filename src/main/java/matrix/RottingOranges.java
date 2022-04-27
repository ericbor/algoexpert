package matrix;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/rotting-oranges/
public class RottingOranges {
    public int orangesRotting(int[][] grid) {

        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 2) {
                    queue.add(new int[] { row, col });
                } else if (grid[row][col] == 1) {
                    fresh++;
                }
            }
        }

        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int minutes = 0;

        // fresh != 0 - ensure we are not continuing once all fresh oranges became rotten.
        while (fresh != 0 && !queue.isEmpty()) {
            int levelSize = queue.size();
            minutes++;// Time elapsed after neighbors of this level have become rotten.

            for (int i = 0; i < levelSize; i++) {
                int[] curr = queue.poll();
                int currRow = curr[0];
                int currCol = curr[1];

                for (int[] direction : directions) {
                    int r = currRow + direction[0];
                    int c = currCol + direction[1];
                    if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == 1) {
                        queue.add(new int[] { r, c });
                        grid[r][c] = 2;
                        fresh--;
                    }
                }

            }
        }

        return fresh == 0 ? minutes : -1;
    }

    @Test
    public void test() {
        Assert.assertEquals(4, orangesRotting(new int[][] { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(-1, orangesRotting(new int[][] { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } }));
    }

    @Test
    public void test3() {
        Assert.assertEquals(0, orangesRotting(new int[][] { { 0, 2 } }));
    }
}
