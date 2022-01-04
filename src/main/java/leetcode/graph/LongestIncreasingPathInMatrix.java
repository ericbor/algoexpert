package leetcode.graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
public class LongestIncreasingPathInMatrix {
    public int longestIncreasingPath_2(int[][] matrix) {
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

                    if (r >= 0 && c >= 0 && r < matrix.length && c < matrix[0].length && matrix[r][c] > currVal) {
                        queue.add(new int[] { r, c });
                    }
                }
            }

            result++;
        }

        return result;
    }

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[][] cache = new int[matrix.length][matrix[0].length];
        int ans = 0;

        for (int row = 0; row < matrix.length; ++row) {
            for (int col = 0; col < matrix[0].length; ++col) {
                ans = Math.max(ans, dfs(matrix, row, col, cache));
            }
        }

        return ans;
    }

    private int dfs(int[][] matrix, int row, int col, int[][] cache) {
        if (cache[row][col] != 0) {
            return cache[row][col];
        }

        int ans = 0;
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        for (int[] direction : directions) {
            int r = row + direction[0];
            int c = col + direction[1];
            int currVal = matrix[row][col];

            if (r >= 0 && c >= 0 && r < matrix.length && c < matrix[0].length && matrix[r][c] > currVal) {
                cache[row][col] = Math.max(cache[row][col], dfs(matrix, r, c, cache));
            }
        }
        cache[row][col]++;

        return cache[row][col];
    }

    @Test
    public void test() {
        Assert.assertEquals(140, longestIncreasingPath(new int[][] {
            { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 },
            { 19, 18, 17, 16, 15, 14, 13, 12, 11, 10 },
            { 20, 21, 22, 23, 24, 25, 26, 27, 28, 29 },
            { 39, 38, 37, 36, 35, 34, 33, 32, 31, 30 },
            { 40, 41, 42, 43, 44, 45, 46, 47, 48, 49 },
            { 59, 58, 57, 56, 55, 54, 53, 52, 51, 50 },
            { 60, 61, 62, 63, 64, 65, 66, 67, 68, 69 },
            { 79, 78, 77, 76, 75, 74, 73, 72, 71, 70 },
            { 80, 81, 82, 83, 84, 85, 86, 87, 88, 89 },
            { 99, 98, 97, 96, 95, 94, 93, 92, 91, 90 },
            { 100, 101, 102, 103, 104, 105, 106, 107, 108, 109 },
            { 119, 118, 117, 116, 115, 114, 113, 112, 111, 110 },
            { 120, 121, 122, 123, 124, 125, 126, 127, 128, 129 },
            { 139, 138, 137, 136, 135, 134, 133, 132, 131, 130 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
        }));
    }

    @Test
    public void test4() {
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
