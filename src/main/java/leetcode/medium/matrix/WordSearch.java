package leetcode.medium.matrix;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/word-search/
public class WordSearch {
    public boolean exist(char[][] board, String word) {

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (word.charAt(0) == board[row][col]) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    visited[row][col] = true;

                    Queue<WordCoordinate> queue = new LinkedList<>();
                    queue.add(new WordCoordinate(new int[]{row, col}, 1));

                    int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

                    while (!queue.isEmpty()) {
                        WordCoordinate current = queue.poll();
                        int lastRow = current.lastCoordinate[0];
                        int lastCol = current.lastCoordinate[1];
                        int currLength = current.currentLength;

                        if(currLength > word.length()) {
                            continue;
                        }
                        if(currLength == word.length()) {
                            return true;
                        }

                        char nextLetter = word.charAt(current.currentLength);

                        for (int[] direction : directions) {
                            int r = lastRow + direction[0];
                            int c = lastCol + direction[1];

                            if (r >= 0 && c >= 0 && r < board.length && c < board[0].length && !visited[r][c] && board[r][c] == nextLetter) {
                                if(currLength == word.length() - 1) {
                                    return true;
                                }
                                visited[r][c] = true;
                                queue.add(new WordCoordinate(new int[]{r, c}, current.currentLength + 1));
                            }
                        }
                    }
                }
            }
        }

        return false;
    }

    class WordCoordinate {
        int currentLength;
        int[] lastCoordinate;

        WordCoordinate(int[] lastCoordinate, int currentLength) {
            this.currentLength = currentLength;
            this.lastCoordinate = lastCoordinate;
        }
    }

    @Test
    public void test() {
        Assert.assertTrue(exist(new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'E', 'S' }, { 'A', 'D', 'E', 'E' } }, "ABCESEEEFS"));
    }

    @Test
    public void test2() {
        Assert.assertTrue(exist(new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } }, "SEE"));
    }

    @Test
    public void test3() {
        Assert.assertFalse(exist(new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } }, "ABCB"));
    }

    @Test
    public void test4() {
        Assert.assertTrue(exist(new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } }, "ABCCED"));
    }

    @Test
    public void test5() {
        Assert.assertFalse(exist(new char[][] { { 'A', 'A', 'A', 'A', 'A', 'A' }, { 'A', 'A', 'A', 'A', 'A', 'A' }, { 'A', 'A', 'A', 'A', 'A', 'A' }, { 'A', 'A', 'A', 'A', 'A', 'A' }, { 'A', 'A', 'A', 'A', 'A', 'A' }, { 'A', 'A', 'A', 'A', 'A', 'A' } }, "AAAAAAAAAAAAAAB"));
    }

    @Test
    public void test6() {
        Assert.assertTrue(exist(new char[][] { { 'a' } }, "a"));
    }
}
