package leetcode.design;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/design-tic-tac-toe/
public class TicTacToe2 {
    private final int[] rows;
    private final int[] cols;
    private int diagonal;
    private int antiDiagonal;

    public TicTacToe2(int n) {
        rows = new int[n];
        cols = new int[n];
    }

    public int move(int row, int col, int player) {
        int currentPlayer = player == 1 ? 1 : -1;
        // update currentPlayer in rows and cols arrays
        rows[row] += currentPlayer;
        cols[col] += currentPlayer;
        // update diagonal
        if (row == col) {
            diagonal += currentPlayer;
        }
        //update anti diagonal
        if (col == cols.length - row - 1) {
            antiDiagonal += currentPlayer;
        }
        int n = rows.length;
        // check if the current player wins
        if (Math.abs(rows[row]) == n ||
            Math.abs(cols[col]) == n ||
            Math.abs(diagonal) == n ||
            Math.abs(antiDiagonal) == n) {
            return player;
        }
        // No one wins
        return 0;
    }

    public static void main(String[] args) {
        TicTacToe2 game2 = new TicTacToe2(2);
        Assert.assertEquals(0, game2.move(0, 0, 2));
        Assert.assertEquals(0, game2.move(1, 1, 1));
        Assert.assertEquals(2, game2.move(0, 1, 2));

        TicTacToe2 game = new TicTacToe2(3);
        Assert.assertEquals(0, game.move(0, 0, 1));
        Assert.assertEquals(0, game.move(0, 2, 2));
        Assert.assertEquals(0, game.move(2, 2, 1));
        Assert.assertEquals(0, game.move(1, 1, 2));
        Assert.assertEquals(0, game.move(2, 0, 1));
        Assert.assertEquals(0, game.move(1, 0, 2));
        Assert.assertEquals(1, game.move(2, 1, 1));
    }
}
