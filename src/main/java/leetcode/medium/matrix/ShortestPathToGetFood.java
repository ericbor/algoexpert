package leetcode.medium.matrix;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/shortest-path-to-get-food/
public class ShortestPathToGetFood {

    public int getFood(char[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] seen = new boolean[grid.length][grid[0].length];

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '*') {
                    queue.add(new int[] { r, c });
                    seen[r][c] = true;
                    break;
                }
            }
            if (!queue.isEmpty()) {
                break;
            }
        }

        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                int[] index = queue.poll();
                int row = index[0];
                int col = index[1];

                if (grid[row][col] == '#') {
                    return steps;
                }

                for (int[] direction : directions) {
                    int r = row + direction[0];
                    int c = col + direction[1];
                    if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] != 'X' && !seen[r][c]) {
                        seen[r][c] = true;
                        queue.add(new int[] { r, c });
                    }
                }
            }

            steps++;
        }

        return -1;
    }

    @Test
    public void test() {
        Assert.assertEquals(6, getFood(new char[][] { { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' }, { 'X', '*', 'O', 'X', 'O', '#', 'O', 'X' }, { 'X', 'O', 'O', 'X', 'O', 'O', 'X', 'X' }, { 'X', 'O', 'O', 'O', 'O', '#', 'O', 'X' }, { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(3, getFood(new char[][] { { 'X', 'X', 'X', 'X', 'X', 'X' }, { 'X', '*', 'O', 'O', 'O', 'X' }, { 'X', 'O', 'O', '#', 'O', 'X' }, { 'X', 'X', 'X', 'X', 'X', 'X' } }));
    }

    @Test
    public void test3() {
        Assert.assertEquals(-1, getFood(new char[][] { { 'X', 'X', 'X', 'X', 'X' }, { 'X', '*', 'X', 'O', 'X' }, { 'X', 'O', 'X', '#', 'X' }, { 'X', 'X', 'X', 'X', 'X' } }));
    }
}
