package leetcode.medium.matrix;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/sort-the-matrix-diagonally/
public class SortMatrixDiagonally {
    public int[][] diagonalSort2(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Map<Integer, Queue<Integer>> diagonals = new HashMap<>();
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                int key = row - col;
                diagonals.putIfAbsent(key, new PriorityQueue<>());
                diagonals.get(key).add(mat[row][col]);
            }
        }

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                mat[row][col] = diagonals.get(row - col).poll();
            }
        }

        return mat;
    }

    public int[][] diagonalSort(int[][] mat) {
        // Store the matrix dimensions.
        int m = mat.length;
        int n = mat[0].length;

        // Sort each diagonal that starts on a row.
        for (int row = 0; row < m; row++) {
            sortDiagonal(row, 0, mat);
        }

        // Sort each diagonal that starts on a col.
        // Note that we've already sorted the one starting
        // at col = 0; this is the same as the one starting
        // at row = 0.
        for (int col = 1; col < n; col++) {
            sortDiagonal(0, col, mat);
        }

        return mat;
    }

    private void sortDiagonal(int row, int col, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<Integer> diagonal = new PriorityQueue<>();

        int diagonalLength = Math.min(m - row, n - col);
        // Put values on this diagonal into the heap.
        for (int i = 0; i < diagonalLength; i++) {
            diagonal.add(mat[row + i][col + i]);
        }
        // Put values on heap back into this diagonal
        for (int i = 0; i < diagonalLength; i++) {
            mat[row + i][col + i] = diagonal.remove();
        }
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[][] { { 1, 1, 1, 1 }, { 1, 2, 2, 2 }, { 1, 2, 3, 3 } }, diagonalSort(new int[][] { { 3, 3, 1, 1 }, { 2, 2, 1, 2 }, { 1, 1, 1, 2 } }));
    }
}
