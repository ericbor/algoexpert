package leetcode.easy.matrix;

import org.junit.Assert;
import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/matrix-cells-in-distance-order/
public class MatrixCellsInDistanceOrder {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            int row1 = Math.abs(a[0] - rCenter);
            int col1 = Math.abs(a[1] - cCenter);
            int aCoordinates = row1 + col1;

            int row2 = Math.abs(b[0] - rCenter);
            int col2 = Math.abs(b[1] - cCenter);
            int bCoordinates = row2 + col2;

            return bCoordinates - aCoordinates;
        });

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                minHeap.add(new int[] { r, c });
            }
        }

        int[][] results = new int[rows * cols][2];
        int row = rows * cols - 1;

        while (!minHeap.isEmpty()) {
            results[row] = minHeap.poll();
            row--;
        }

        return results;
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[][] { { 1, 2 }, { 0, 2 }, { 1, 1 }, { 0, 1 }, { 1, 0 }, { 0, 0 } }, allCellsDistOrder(2, 3, 1, 2));
    }
}
