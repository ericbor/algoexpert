package matrix;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/sparse-matrix-multiplication
public class SparseMatrixMultiplication {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int n = mat1.length;
        int k = mat1[0].length;
        int m = mat2[0].length;

        // Product matrix will have 'n x m' size.
        int[][] ans = new int[n][m];

        for (int r = 0; r < n; ++r) {
            for (int elementIndex = 0; elementIndex < k; elementIndex++) {
                // If current element of mat1 is non-zero then iterate over all columns of mat2.
                if (mat1[r][elementIndex] != 0)  {
                    for (int c = 0; c < m; ++c) {
                        ans[r][c] += mat1[r][elementIndex] * mat2[elementIndex][c];
                    }
                }
            }
        }

        return ans;
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[][]{{7,0,0},{-7,0,3}}, multiply(new int[][]{{1,0,0},{-1,0,3}}, new int[][]{{7,0,0},{0,0,0},{0,0,1}}));
    }
}
