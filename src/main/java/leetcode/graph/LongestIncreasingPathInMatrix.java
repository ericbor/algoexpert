package leetcode.graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
public class LongestIncreasingPathInMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        int longestPath = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                int currPath = getLongestPath(matrix, row, col);
                longestPath = Math.max(longestPath, currPath);
            }
        }

        return longestPath;
    }

    private int getLongestPath(int[][] matrix, int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { row, col });

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        visited[row][col] = true;

        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        int result = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {

                int[] curr = queue.poll();
                int currRow = curr[0];
                int currCol = curr[1];
                int currVal = matrix[currRow][currCol];

                for (int[] direction : directions) {
                    int r = currRow + direction[0];
                    int c = currCol + direction[1];

                    if (r >= 0 && c >= 0 && r < matrix.length && c < matrix[0].length && !visited[r][c] && matrix[r][c] > currVal) {
                        visited[r][c] = true;
                        queue.add(new int[] { r, c });
                    }
                }
            }
            result++;
        }

        return result;
    }

    @Test
    public void test() {
        Assert.assertEquals(6, longestIncreasingPath(new int[][] { { 7, 8, 9 }, { 9, 7, 6 }, { 7, 2, 3 } }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(4, longestIncreasingPath(new int[][] { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } }));
    }

    @Test
    public void test3() {
        Assert.assertEquals(1, longestIncreasingPath(new int[][] { { 1 } }));
    }
}
