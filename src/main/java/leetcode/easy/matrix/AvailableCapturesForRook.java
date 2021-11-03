package leetcode.easy.matrix;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/available-captures-for-rook/
public class AvailableCapturesForRook {
    public int numRookCaptures(String[][] board) {
        int[] rPosition = new int[2];
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board.length; c++) {
                if ("R".equals(board[r][c])) {
                    rPosition[0] = r;
                    rPosition[1] = c;
                }
            }
        }

        int capturesCount = 0;

        int notrthPos = rPosition[0];
        notrthPos--;
        while (notrthPos >= 0) {

            String curr = board[notrthPos][rPosition[1]];

            if ("B".equals(curr)) {
                break;
            } else if ("p".equals(curr)) {
                capturesCount++;
                break;
            }

            notrthPos--;
        }

        int southPos = rPosition[0];
        southPos++;
        while (southPos < board.length) {

            String curr = board[southPos][rPosition[1]];

            if ("B".equals(curr)) {
                break;
            } else if ("p".equals(curr)) {
                capturesCount++;
                break;
            }

            southPos++;
        }

        int westPos = rPosition[1];
        westPos--;
        while (westPos >= 0) {

            String curr = board[rPosition[0]][westPos];

            if ("B".equals(curr)) {
                break;
            } else if ("p".equals(curr)) {
                capturesCount++;
                break;
            }

            westPos--;
        }

        int eastPos = rPosition[1];
        eastPos++;
        while (eastPos < board.length) {

            String curr = board[rPosition[0]][eastPos];

            if ("B".equals(curr)) {
                break;
            } else if ("p".equals(curr)) {
                capturesCount++;
                break;
            }

            eastPos++;
        }

        return capturesCount;
    }

    @Test
    public void test() {
        Assert.assertEquals(3, numRookCaptures(new String[][] {
            { ".", ".", ".", ".", ".", ".", "p", "." },
            { "p", ".", ".", ".", ".", ".", "R", "." },
            { ".", ".", ".", ".", ".", ".", ".", "." },
            { ".", ".", ".", ".", ".", ".", ".", "." },
            { ".", ".", ".", ".", ".", ".", ".", "." },
            { ".", ".", ".", ".", ".", ".", ".", "." },
            { ".", ".", ".", ".", ".", ".", ".", "." },
            { ".", ".", ".", ".", ".", ".", "p", "." }
        }));
    }

    @Test
    public void test3() {
        Assert.assertEquals(1, numRookCaptures(new String[][] {
            { ".", ".", ".", ".", ".", ".", ".", "." },
            { ".", ".", ".", "p", ".", ".", ".", "." },
            { ".", ".", ".", "R", ".", ".", ".", "." },
            { ".", ".", ".", ".", ".", ".", ".", "." },
            { ".", ".", ".", ".", ".", ".", ".", "." },
            { ".", ".", ".", ".", ".", ".", ".", "." },
            { ".", ".", ".", ".", ".", ".", ".", "." },
            { ".", ".", ".", ".", ".", ".", ".", "." }
        }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(4, numRookCaptures(new String[][] {
            { ".", ".", ".", "p", ".", ".", ".", "." },
            { ".", ".", ".", ".", ".", ".", ".", "." },
            { "p", ".", ".", "R", ".", ".", ".", "p" },
            { ".", ".", ".", ".", ".", ".", ".", "." },
            { ".", ".", ".", ".", ".", ".", ".", "." },
            { ".", ".", ".", ".", ".", ".", ".", "." },
            { ".", ".", ".", ".", ".", ".", ".", "." },
            { ".", ".", ".", "p", ".", ".", ".", "." }
        }));
    }
}
