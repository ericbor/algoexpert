package leetcode.easy.matrix;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/
public class CellsWithOddValuesInMatrix {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] matrix = new int[m][n];

        int oddsNum = 0;
        for (int[] index : indices) {
            int row = index[0];
            int column = index[1];

            for (int i = 0; i < matrix[row].length; i++) {
                matrix[row][i]++;

                if (matrix[row][i] % 2 != 0) {
                    oddsNum++;
                }
            }

            for (int j = 0; j < matrix.length; j++) {
                matrix[j][column]++;

                if (matrix[j][column] % 2 != 0) {
                    oddsNum++;
                }
            }
        }

        return oddsNum;
    }

    public int oddCells2(int n, int m, int[][] indices) {
        int[] row = new int[n];
        int[] col = new int[m];
        for (int[] x : indices) {
            row[x[0]]++;
            col[x[1]]++;
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int val = row[i] + col[j];
                if (val % 2 != 0) {//adding rows[i] and columns[j] will give the value in final array. check whether it is odd or even
                    count++;
                }
            }
        }
        return count;
    }

    @Test
    public void test() {
        Assert.assertEquals(6, oddCells2(2, 3, new int[][] { { 0, 1 }, { 1, 1 } }));
    }
}
