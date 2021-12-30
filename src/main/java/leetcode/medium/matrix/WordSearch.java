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
                    LinkedList<String> coordinates = new LinkedList<>();
                    coordinates.add(String.valueOf(row) + col);

                    Queue<WordCoordinate> queue = new LinkedList<>();
                    queue.add(new WordCoordinate(String.valueOf(board[row][col]), coordinates));

                    int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

                    while (!queue.isEmpty()) {
                        WordCoordinate current = queue.poll();
                        String lastWord = current.word;

                        if (lastWord.equals(word)) {
                            return true;
                        }

                        LinkedList<String> currCoordinates = current.coordinates;
                        String lastCoordinate = currCoordinates.getLast();
                        int lastRow = (int) lastCoordinate.charAt(0) - (int) '0';
                        int lastCol = (int) lastCoordinate.charAt(1) - (int) '0';
                        int currLength = lastWord.length();
                        char nextLetter = word.charAt(currLength);

                        for (int[] direction : directions) {
                            int r = lastRow + direction[0];
                            int c = lastCol + direction[1];

                            if (r >= 0 && c >= 0 && r < board.length && c < board[0].length && board[r][c] == nextLetter) {
                                String newCoordinate = String.valueOf(r) + c;
                                if (!currCoordinates.contains(newCoordinate)) {
                                    LinkedList<String> newCoordiantes = new LinkedList<>(currCoordinates);
                                    newCoordiantes.add(newCoordinate);
                                    queue.add(new WordCoordinate(lastWord + board[r][c], newCoordiantes));
                                }
                            }
                        }
                    }
                }
            }
        }

        return false;
    }

    private boolean wordExists(char[][] board, String word, int row, int col) {

        LinkedList<String> coordinates = new LinkedList<>();
        coordinates.add(String.valueOf(row) + col);

        Queue<WordCoordinate> queue = new LinkedList<>();
        queue.add(new WordCoordinate(String.valueOf(board[row][col]), coordinates));

        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        while (!queue.isEmpty()) {
            WordCoordinate current = queue.poll();
            String lastWord = current.word;

            if (lastWord.contains(word)) {
                return true;
            }

            LinkedList<String> currCoordinates = current.coordinates;
            String lastCoordinate = currCoordinates.getLast();
            int lastRow = (int) lastCoordinate.charAt(0) - (int) '0';
            int lastCol = (int) lastCoordinate.charAt(1) - (int) '0';

            for (int[] direction : directions) {
                int r = lastRow + direction[0];
                int c = lastCol + direction[1];

                if (r >= 0 && c >= 0 && r < board.length && c < board.length) {
                    String newCoordinate = String.valueOf(r) + c;
                    if (!currCoordinates.contains(newCoordinate)) {
                        LinkedList<String> newCoordiantes = new LinkedList<>(currCoordinates);
                        newCoordiantes.add(newCoordinate);
                        queue.add(new WordCoordinate(lastWord + board[r][c], newCoordiantes));
                    }

                }
            }
        }

        return false;
    }

    class WordCoordinate {
        String word;
        LinkedList<String> coordinates;

        WordCoordinate(String word, LinkedList<String> coordinates) {
            this.word = word;
            this.coordinates = coordinates;
        }
    }

    @Test
    public void test() {
        Assert.assertTrue(exist(new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } }, "ABCCED"));
    }

    @Test
    public void test2() {
        Assert.assertTrue(exist(new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } }, "SEE"));
    }

    @Test
    public void test3() {
        Assert.assertFalse(exist(new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } }, "ABCB"));
    }
}
