package leetcode.easy.matrix;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/toeplitz-matrix/
public class ToeplitzMatrix {

    public boolean isToeplitzMatrix(int[][] matrix) {
        //Check whether each value is equal to the value of it's top-left neighbor.
        for (int row = matrix.length - 1; row > 0; row--) {
            int n = matrix[0].length - 1;

            while (n >= 1) {
                if (matrix[row][n] != matrix[row - 1][n - 1]) {
                    return false;
                }
                n--;
            }
        }

        return true;
    }

    @Test
    public void test() {
        Assert.assertTrue(isToeplitzMatrix(new int[][] { { 1, 2, 3, 4 }, { 5, 1, 2, 3 }, { 9, 5, 1, 2 } }));
    }

    @Test
    public void tes2() {
        Assert.assertFalse(isToeplitzMatrix(new int[][] { { 1, 2 }, { 2, 2 } }));
    }
}
