package matrix;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/valid-sudoku/
public class ValidSudoku {
    public boolean isValidSudoku(String[][] board) {
        return checkHorizontal(board) && checkVertical(board) && checkBoxes(board);
    }

    private boolean checkBoxes(String[][] board) {
        int[][] coors = {{0, 0}, {0, 3}, {0, 6}, {3, 0}, {6, 0}, {3, 3}, {3, 6}, {6, 3}, {6, 6}};

        for (int[] coor : coors) {
            Set<String> set = new HashSet<>(board.length);
            for (int i = coor[0]; i <= coor[0] + 2; i++) {
                for (int j = coor[1]; j <= coor[1] + 2; j++) {
                    if (!".".equals(board[i][j])) {
                        if (set.contains(board[i][j])) {
                            return false;
                        }
                        set.add(board[i][j]);
                    }
                }
            }
        }

        return true;
    }

    private boolean checkHorizontal(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<String> set = new HashSet<>(board.length);
            for (int j = 0; j < board[0].length; j++) {
                if (!".".equals(board[i][j])) {
                    if (set.contains(board[i][j])) {
                        return false;
                    }
                    set.add(board[i][j]);
                }
            }
        }

        return true;
    }

    private boolean checkVertical(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<String> set = new HashSet<>(board.length);
            for (int j = 0; j < board[0].length; j++) {
                if (!".".equals(board[j][i])) {
                    if (set.contains(board[j][i])) {
                        return false;
                    }
                    set.add(board[j][i]);
                }

            }
        }

        return true;
    }

    public boolean isValidSudoku2(String[][] board) {
        int N = 9;

        // Use hash set to record the status
        HashSet<String>[] rows = new HashSet[N];
        HashSet<String>[] cols = new HashSet[N];
        HashSet<String>[] boxes = new HashSet[N];
        for (int r = 0; r < N; r++) {
            rows[r] = new HashSet<>();
            cols[r] = new HashSet<>();
            boxes[r] = new HashSet<>();
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                String val = board[r][c];

                // Check if the position is filled with number
                if (".".equals(val)) {
                    continue;
                }

                // Check the row
                if (rows[r].contains(val)) {
                    return false;
                }
                rows[r].add(val);

                // Check the column
                if (cols[c].contains(val)) {
                    return false;
                }
                cols[c].add(val);

                // Check the box
                int idx = (r / 3) * 3 + c / 3;
                if (boxes[idx].contains(val)) {
                    return false;
                }
                boxes[idx].add(val);
            }
        }
        return true;
    }

    @Test
    public void test() {
        String[][] board = {{"5", "3", ".", ".", "7", ".", ".", ".", "."}
                , {"6", ".", ".", "1", "9", "5", ".", ".", "."}
                , {".", "9", "8", ".", ".", ".", ".", "6", "."}
                , {"8", ".", ".", ".", "6", ".", ".", ".", "3"}
                , {"4", ".", ".", "8", ".", "3", ".", ".", "1"}
                , {"7", ".", ".", ".", "2", ".", ".", ".", "6"}
                , {".", "6", ".", ".", ".", ".", "2", "8", "."}
                , {".", ".", ".", "4", "1", "9", ".", ".", "5"}
                , {".", ".", ".", ".", "8", ".", ".", "7", "9"}};
        Assert.assertTrue(isValidSudoku(board));
        Assert.assertTrue(isValidSudoku2(board));
    }
}
