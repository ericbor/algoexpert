package leetcode.easy.matrix;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/reshape-the-matrix/
public class ReshapeMatrix {
    public int[][] matrixReshapeViaQueue(int[][] mat, int r, int c) {
        int matSize = mat.length * mat[0].length;
        int newSize = r * c;
        if (matSize != newSize) {
            return mat;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int[] row : mat) {
            for(int num : row) {
                queue.add(num);
            }
        }

        int[][] results = new int[r][c];
        for(int row = 0; row < r; row ++) {
            for(int col = 0; col < c; col++) {
                results[row][col] = queue.poll();
            }
        }

        return results;
    }

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int matSize = mat.length * mat[0].length;
        int newSize = r * c;
        if (matSize != newSize) {
            return mat;
        }

        int[][] results = new int[r][c];

        int row = 0;
        int col = 0;

        for (int j = 0; j < mat.length; j++) {
            for (int k = 0; k < mat[j].length; k++) {

                results[row][col] = mat[j][k];
                col++;

                if (col == c) {
                    row++;
                    col = 0;
                }
            }
        }

        return results;
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[][] { { 1, 2, 3, 4 } }, matrixReshape(new int[][] { { 1, 2 }, { 3, 4 } }, 1, 4));
        Assert.assertArrayEquals(new int[][] { { 1, 2, 3, 4 } }, matrixReshapeViaQueue(new int[][] { { 1, 2 }, { 3, 4 } }, 1, 4));
    }

    @Test
    public void test2() {
        Assert.assertArrayEquals(new int[][] { { 1, 2 }, { 3, 4 }, { 5, 6 } }, matrixReshape(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } }, 3, 2));
        Assert.assertArrayEquals(new int[][] { { 1, 2 }, { 3, 4 }, { 5, 6 } }, matrixReshapeViaQueue(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } }, 3, 2));
    }

    @Test
    public void test3() {
        Assert.assertArrayEquals(new int[][] { { 1, 2 }, { 3, 4 } }, matrixReshape(new int[][] { { 1, 2 }, { 3, 4 } }, 2, 4));
        Assert.assertArrayEquals(new int[][] { { 1, 2 }, { 3, 4 } }, matrixReshapeViaQueue(new int[][] { { 1, 2 }, { 3, 4 } }, 2, 4));
    }

    @Test
    public void test4() {
        Assert.assertArrayEquals(new int[][] { { 1, 2,3,4,5 }, { 6,7,8,9,10 } }, matrixReshape(new int[][] { { 1, 2,3,4,5 }, { 6,7,8,9,10 } }, 3, 4));
        Assert.assertArrayEquals(new int[][] { { 1, 2,3,4,5 }, { 6,7,8,9,10 } }, matrixReshapeViaQueue(new int[][] { { 1, 2,3,4,5 }, { 6,7,8,9,10 } }, 3, 4));
    }

    @Test
    public void test5() {
        Assert.assertArrayEquals(new int[][] { { 1,2 } }, matrixReshape(new int[][] { { 1,2 } }, 1, 1));
        Assert.assertArrayEquals(new int[][] { { 1,2 } }, matrixReshapeViaQueue(new int[][] { { 1,2 } }, 1, 1));
    }
}
