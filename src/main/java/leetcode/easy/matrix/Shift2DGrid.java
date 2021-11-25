package leetcode.easy.matrix;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//https://leetcode.com/problems/shift-2d-grid/
public class Shift2DGrid {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        Deque<Integer> deque = new ArrayDeque<>();
        for (int[] row : grid) {
            for (int col : row) {
                deque.offer(col);
            }
        }

        while (k > 0) {
            int last = deque.pollLast();
            deque.offerFirst(last);
            k--;
        }

        List<List<Integer>> rows = new ArrayList<>();
        int size = grid[0].length;
        while (!deque.isEmpty()) {
            List<Integer> row = new ArrayList<>(size);
            while (row.size() != size) {
                row.add(deque.poll());
            }
            rows.add(row);
        }

        return rows;
    }

    @Test
    public void test() {
        Assert.assertEquals(List.of(List.of(7, 8, 9), List.of(1, 2, 3), List.of(4, 5, 6)), shiftGrid(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }, 3));
    }
}
