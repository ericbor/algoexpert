package leetcode.design;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/design-tic-tac-toe/
public class TicTacToe {
    private final int[][] board;
    private final Map<Integer, Integer> moves = new HashMap<>();

    // O(N), O(N^2)
    public TicTacToe(int n) {
        this.board = new int[n][n];
    }

    public int move(int row, int col, int player) {
        board[row][col] = player;
        moves.put(player, moves.getOrDefault(player, 0) + 1);

        if (moves.get(player) < board.length) {
            return 0;
        }

        if(checkRow(player, row) || checkColumn(player, col) || checkDiagonal(player) || checkAntiDiagonal(player)) {
            return player;
        }

        return 0;
    }

    private boolean checkColumn(int player, int column) {
        for(int row = 0; row < board.length; row++) {
            if(board[row][column] != player) {
                return false;
            }
        }

        return true;
    }

    private boolean checkRow(int player, int row) {
        for(int col = 0; col < board[0].length; col ++) {
            if(board[row][col] != player) {
                return false;
            }
        }

        return true;
    }

    private boolean checkDiagonal(int player) {
        for (int row = 0; row < board.length; row++) {
            if (board[row][row] != player) {
                return false;
            }
        }

        return true;
    }

    private boolean checkAntiDiagonal(int player) {
        for (int row = 0; row < board.length; row++) {
            if (board[row][board.length - row - 1] != player) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        TicTacToe game2 = new TicTacToe(2);
        Assert.assertEquals(0, game2.move(0, 0, 2));
        Assert.assertEquals(0, game2.move(1, 1, 1));
        Assert.assertEquals(2, game2.move(0, 1, 2));

        TicTacToe game = new TicTacToe(3);
        Assert.assertEquals(0, game.move(0, 0, 1));
        Assert.assertEquals(0, game.move(0, 2, 2));
        Assert.assertEquals(0, game.move(2, 2, 1));
        Assert.assertEquals(0, game.move(1, 1, 2));
        Assert.assertEquals(0, game.move(2, 0, 1));
        Assert.assertEquals(0, game.move(1, 0, 2));
        Assert.assertEquals(1, game.move(2, 1, 1));
    }
}
