package array.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {
    public static List<Integer> spiralTraverse(int[][] array) {
        List<Integer> result = new ArrayList<>();
        int startCol = 0;
        int endCol = array[0].length - 1;//3
        int startRow = 0;
        int endRow = array.length - 1;//4

        while (startRow <= endRow && startCol <= endCol) {
            //[0,0][0,1][0,2][0,3]
            for (int col = startCol; col <= endCol; col++) {
                result.add(array[startRow][col]);
            }

            //[1,3][2,3][3,3][4,3]
            for (int row = startRow + 1; row <= endRow; row++) {
                result.add(array[row][endCol]);
            }

            //[4,2][4,1][4,0]
            for (int col = endCol - 1; col >= startCol; col--) {
                if (startRow == endRow) break;
                result.add(array[endRow][col]);
            }

            //[3,0][2,0][1,0]
            for (int row = endRow - 1; row > startRow; row--) {
                if (startCol == endCol) break;
                result.add(array[row][startCol]);
            }

            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }

        return result;
    }

    @Test
    public void verify() {
        int[][] multi = {
            { 1, 2, 3, 4 },
            { 14, 15, 16, 5 },
            { 13, 20, 17, 6 },
            { 12, 19, 18, 7 },
            { 11, 10, 9, 8 }
        };
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
        Assert.assertEquals(expected, spiralTraverse(multi));




    }
}
