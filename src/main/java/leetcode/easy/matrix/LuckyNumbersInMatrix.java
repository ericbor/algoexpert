package leetcode.easy.matrix;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/lucky-numbers-in-a-matrix/
public class LuckyNumbersInMatrix {
    public List<Integer> luckyNumbers(int[][] matrix) {

        int[] minRows = new int[matrix.length];
        int[] maxCols = new int[matrix[0].length];

        for (int r = 0; r < matrix.length; r++) {
            int minRow = Integer.MAX_VALUE;

            for (int c = 0; c < matrix[r].length; c++) {
                int curr = matrix[r][c];
                minRow = Math.min(minRow, curr);
                int maxCol = Math.max(maxCols[c], curr);

                minRows[r] = minRow;
                maxCols[c] = maxCol;
            }
        }

        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int num : minRows) {
            maxHeap.add(num);
        }

        Queue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
        for (int num : maxCols) {
            minHeap.add(num);
        }

        List<Integer> results = new ArrayList<>();
        while (!maxHeap.isEmpty() && !minHeap.isEmpty()) {
            int maxInRow = maxHeap.poll();
            int minInCol = minHeap.poll();
            if (maxInRow == minInCol) {
                results.add(maxInRow);
            }
        }

        return results;
    }

    @Test
    public void test() {
        Assert.assertEquals(List.of(15), luckyNumbers(new int[][] { { 3, 7, 8 }, { 9, 11, 13 }, { 15, 16, 17 } }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(List.of(12), luckyNumbers(new int[][] { { 1, 10, 4, 2 }, { 9, 3, 8, 7 }, { 15, 16, 17, 12 } }));
    }
}
