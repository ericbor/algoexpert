package matrix;

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

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currRow = curr[0];
            int currCol = curr[1];
            if (currRow == destination[0] && currCol == destination[1]) {
                return true;
            }

            for (int[] dir : directions) {
                int r = currRow;
                int c = currCol;

                while (r + dir[0] >= 0 && c + dir[1] >= 0 && r + dir[0] < maze.length && c + dir[1] < maze[0].length && maze[r + dir[0]][c + dir[1]] != 1) {
                    r += dir[0];
                    c += dir[1];
                }

                //int prevRow = r - dir[0];
                //int prevCol = c - dir[1];
                if (!visited[r][c]) {
                    queue.add(new int[]{r, c});
                    visited[r][c] = true;
                }
            }
        }

        return false;
    }

    @Test
    public void test() {
        Assert.assertTrue(hasPath(new int[][]{{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}}, new int[]{0, 4}, new int[]{4, 4}));
    }

    @Test
    public void test2() {
        Assert.assertFalse(hasPath(new int[][]{{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}}, new int[]{0, 4}, new int[]{3, 2}));
    }

    @Test
    public void test3() {
        Assert.assertFalse(hasPath(new int[][]{{0, 0, 0, 0, 0}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 1, 0, 0, 1}, {0, 1, 0, 0, 0}}, new int[]{4, 3}, new int[]{0, 1}));
    }
}
