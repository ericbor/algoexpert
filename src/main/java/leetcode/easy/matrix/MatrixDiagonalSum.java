package leetcode.easy.matrix;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/matrix-diagonal-sum/
public class MatrixDiagonalSum {
    public int diagonalSum(int[][] mat) {

        int start = 0;
        int end = mat.length - 1;

        int sum = 0;
        while(start <= end) {

            int currSum = 0;
            if(start != end) {
                int startVal =  mat[start][start] + mat[start][end];
                int endVal = mat[end][start] + mat[end][end];
                currSum = startVal + endVal;
            } else {
                currSum = mat[start][start];
            }
            sum += currSum;

            start++;
            end--;
        }

        return sum;
    }

    @Test
    public void test() {
        Assert.assertEquals(25, diagonalSum(new int[][] {{1,2,3}, {4,5,6}, {7,8,9}}));
        Assert.assertEquals(8, diagonalSum(new int[][] {{1,1,1,1},{1,1,1,1}, {1,1,1,1}, {1,1,1,1}}));
    }
}
