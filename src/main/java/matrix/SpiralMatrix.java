package matrix;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/spiral-matrix
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        while (result.size() < matrix.length * matrix[0].length) {
            // Traverse Right
            for (int j = colBegin; j <= colEnd; j ++) {
                result.add(matrix[rowBegin][j]);
            }
            rowBegin++;

            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j ++) {
                result.add(matrix[j][colEnd]);
            }
            colEnd--;

            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colBegin; j --) {
                    result.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;

            if (colBegin <= colEnd) {
                // Traver Up
                for (int j = rowEnd; j >= rowBegin; j --) {
                    result.add(matrix[j][colBegin]);
                }
            }
            colBegin ++;
        }

        return result;
    }

    @Test
    public void test() {
        int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
        Assert.assertEquals(List.of(1,2,3,4,8,12,11,10,9,5,6,7), spiralOrder(matrix));
    }
}
