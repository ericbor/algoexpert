package matrix;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/word-search/
public class WordSearch {
    //private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        //visited = new boolean[board.length][board[0].length];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (word.charAt(0) == board[row][col]) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    if (search(row, col, board, word, 0, visited)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean search(int row, int col, char[][] board, String word, int index, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || visited[row][col] || board[row][col] != word.charAt(index)) {
            return false;
        }

        visited[row][col] = true;
        if (search(row + 1, col, board, word, index + 1, visited) ||
                search(row, col + 1, board, word, index + 1, visited) ||
                search(row - 1, col, board, word, index + 1, visited) ||
                search(row, col - 1, board, word, index + 1, visited)) {
            return true;
        }

        visited[row][col] = false;
        return false;
    }

    @Test
    public void test() {
        Assert.assertTrue(exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCESEEEFS"));
    }

    @Test
    public void test2() {
        Assert.assertTrue(exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE"));
    }

    @Test
    public void test3() {
        Assert.assertFalse(exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB"));
    }

    @Test
    public void test4() {
        Assert.assertTrue(exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
    }

    @Test
    public void test5() {
        Assert.assertFalse(exist(new char[][]{{'A', 'A', 'A', 'A', 'A', 'A'}, {'A', 'A', 'A', 'A', 'A', 'A'}, {'A', 'A', 'A', 'A', 'A', 'A'}, {'A', 'A', 'A', 'A', 'A', 'A'}, {'A', 'A', 'A', 'A', 'A', 'A'}, {'A', 'A', 'A', 'A', 'A', 'A'}}, "AAAAAAAAAAAAAAB"));
    }

    @Test
    public void test6() {
        Assert.assertTrue(exist(new char[][]{{'a'}}, "a"));
    }
}
