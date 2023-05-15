package matrix;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/spiral-matrix
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int up = 0;
        int left = 0;
        int right = matrix[0].length - 1;
        int down = matrix.length - 1;

        while (result.size() < matrix.length * matrix[0].length) {
            // Traverse from left to right.
            for (int col = left; col <= right; col++) {
                result.add(matrix[up][col]);
            }
            // Traverse downwards.
            for (int row = up + 1; row <= down; row++) {
                result.add(matrix[row][right]);
            }
            // Make sure we are now on a different row.
            if (up != down) {
                // Traverse from right to left.
                for (int col = right - 1; col >= left; col--) {
                    result.add(matrix[down][col]);
                }
            }
            // Make sure we are now on a different column.
            if (left != right) {
                // Traverse upwards.
                for (int row = down - 1; row > up; row--) {
                    result.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            up++;
            down--;
        }

        return result;
    }

    @Test
    public void test() {
        int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
        Assert.assertEquals(List.of(1,2,3,4,8,12,11,10,9,5,6,7), spiralOrder(matrix));
    }
}
