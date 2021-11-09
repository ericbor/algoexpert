package leetcode.easy.matrix;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/transpose-matrix/
public class TransposeMatrix {
    public int[][] transpose(int[][] matrix) {

        int[][] transposed = new int[matrix[0].length][matrix.length];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (r == c) {
                    transposed[r][c] = matrix[r][c];
                } else {
                    transposed[c][r] = matrix[r][c];
                }
            }
        }

        return transposed;
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[][] { { 1, 4 }, { 2, 5 }, { 3, 6 } }, transpose(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } }));
    }

    @Test
    public void test2() {
        Assert.assertArrayEquals(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }, transpose(new int[][] { { 1, 4, 7 }, { 2, 5, 8 }, { 3, 6, 9 } }));
    }
}
