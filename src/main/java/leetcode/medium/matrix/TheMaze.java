package leetcode.medium.matrix;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/the-maze/
public class TheMaze {

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);

        boolean[][] visited = new boolean[maze.length][maze[0].length];
        visited[start[0]][start[1]] = true;

        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currRow = curr[0];
            int currCol = curr[1];
            if (currRow == destination[0] && currCol == destination[1]) {
                return true;
            }

            for (int[] direction : directions) {
                int r = currRow + direction[0];
                int c = currCol + direction[1];

                while (r >= 0 && c >= 0 && r < maze.length && c < maze[0].length && maze[r][c] != 1) {
                    r += direction[0];
                    c += direction[1];
                }

                int prevRow = r - direction[0];
                int prevCol = c - direction[1];
                if (!visited[prevRow][prevCol]) {
                    queue.add(new int[] { prevRow, prevCol });
                    visited[prevRow][prevCol] = true;
                }
            }
        }

        return false;
    }

    @Test
    public void test() {
        Assert.assertTrue(hasPath(new int[][] { { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0 }, { 1, 1, 0, 1, 1 }, { 0, 0, 0, 0, 0 } }, new int[] { 0, 4 }, new int[] { 4, 4 }));
    }

    @Test
    public void test2() {
        Assert.assertFalse(hasPath(new int[][] { { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0 }, { 1, 1, 0, 1, 1 }, { 0, 0, 0, 0, 0 } }, new int[] { 0, 4 }, new int[] { 3, 2 }));
    }

    @Test
    public void test3() {
        Assert.assertFalse(hasPath(new int[][] { { 0, 0, 0, 0, 0 }, { 1, 1, 0, 0, 1 }, { 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 0, 1, 0, 0, 0 } }, new int[] { 4, 3 }, new int[] { 0, 1 }));
    }
}
