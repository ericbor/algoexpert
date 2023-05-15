package matrix;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/rotate-image
public class RotateImage {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reflect(matrix);
    }

    private void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }

    private void reflect(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }

    @Test
    public void test() {
        int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        rotate(matrix);
        Assert.assertArrayEquals(new int[][]{{13,9,5,1}, {14,10,6,2}, {15,11,7,3}, {16,12,8,4}}, matrix);
    }
}
