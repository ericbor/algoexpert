package matrix;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/word-search-ii/
public class WordSearchII {


    public List<String> findWords(char[][] board, String[] words) {

        List<String> results = new ArrayList<>();
        boolean[] wordsFound = new boolean[words.length];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                for(int i = 0; i < words.length; i++) {
                    if (!wordsFound[i] && words[i].charAt(0) == board[row][col]) {
                        boolean[][] visited = new boolean[board.length][board[0].length];
                        if(search(row, col, board, words[i], 0, visited)) {
                            results.add(words[i]);
                            wordsFound[i] = true;
                        }
                    }
                }
            }
        }

        return results;
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
        Assert.assertEquals(List.of("oath", "eat"), findWords(new char[][] { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' }, { 'i', 'f', 'l', 'v' } }, new String[] { "oath", "pea", "eat", "rain" }));
    }
}
