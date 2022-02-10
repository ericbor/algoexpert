package leetcode.medium.matrix;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/spiral-matrix-ii/
public class SpiralMatrixII {
    public int[][] generateMatrix_2(int n) {
        int[][] matrix = new int[n][n];

        int r = 0;
        int c = 0;
        int curr = 1;
        int max = n * n;

        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        boolean[][] visited = new boolean[n][n];

        while (curr <= max) {
            for (int[] direction : directions) {
                if (curr > max) {
                    break;
                }
                if (c >= matrix[0].length) {
                    c--;
                }
                if (r >= matrix.length) {
                    r--;
                }
                if (c < 0) {
                    c++;
                }
                if (r < 0) {
                    r++;
                }

                if (r != 0 || c != 0) {
                    r += direction[0];
                    c += direction[1];
                }

                while (curr <= max && r >= 0 && c >= 0 && r < matrix.length && c < matrix[0].length && !visited[r][c]) {
                    matrix[r][c] = curr;
                    curr++;
                    visited[r][c] = true;

                    r += direction[0];
                    c += direction[1];
                }
            }

        }

        return matrix;
    }

    public int[][] generateMatrix(int n) {
        //go right, then down, then left, and then up..repeat
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        boolean[][] visited = new boolean[n][n];
        int[][] matrix = new int[n][n];
        int curr = 1;
        int visitCount = 0;
        int r = 0;
        int c = -1;

        while (curr <= n * n) {
            for (int[] direction : directions) {
                while (isValid(matrix, r + direction[0], c + direction[1]) && !visited[r + direction[0]][c + direction[1]]) {
                    r += direction[0];
                    c += direction[1];

                    matrix[r][c] = curr;
                    curr++;
                    visited[r][c] = true;
                    //visitCount++;
                }
            }
        }

        return matrix;
    }

    public boolean isValid(int[][] ans, int x, int y) {
        return (x >= 0 && x < ans.length && y >= 0 && y < ans[0].length);
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[][] { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } }, generateMatrix(3));
    }

    @Test
    public void test2() {
        Assert.assertArrayEquals(new int[][] { { 1 } }, generateMatrix(1));
    }

}
