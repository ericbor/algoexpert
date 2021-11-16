package leetcode.easy.matrix;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/special-positions-in-a-binary-matrix/
public class SpecialPositions {
    public int numSpecial(int[][] mat) {
        int[] row = new int[mat.length];
        int[] col = new int[mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    if (row[i] == 1 && col[j] == 1) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        Assert.assertEquals(1, numSpecial(new int[][] { { 1, 0, 0 }, { 0, 0, 1 }, { 1, 0, 0 } }));
    }
}
