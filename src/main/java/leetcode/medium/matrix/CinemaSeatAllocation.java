package leetcode.medium.matrix;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/cinema-seat-allocation/
public class CinemaSeatAllocation {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        boolean[][] reserved = new boolean[n + 1][11];
        for (int[] reservedRow : reservedSeats) {
            reserved[reservedRow[0]][reservedRow[1]] = true;
        }

        int maxFamilies = 0;
        for (int row = 1; row <= n; row++) {
            if (checkLeftAisle(row, reserved)) {
                maxFamilies++;
                if (checkRightAisle(row, reserved)) {
                    maxFamilies++;
                }
            } else if (checkCentral(row, reserved)) {
                maxFamilies++;
            } else if (checkRightAisle(row, reserved)) {
                maxFamilies++;
            }
        }

        return maxFamilies;
    }

    private boolean checkLeftAisle(int row, boolean[][] reserved) {
        for (int col = 2; col <= 5; col++) {
            if (reserved[row][col]) {
                return false;
            }
        }

        return true;
    }

    private boolean checkRightAisle(int row, boolean[][] reserved) {
        for (int col = 6; col <= 9; col++) {
            if (reserved[row][col]) {
                return false;
            }
        }

        return true;
    }

    private boolean checkCentral(int row, boolean[][] reserved) {
        for (int col = 4; col <= 7; col++) {
            if (reserved[row][col]) {
                return false;
            }
        }

        return true;
    }

    @Test
    public void test() {
        Assert.assertEquals(4, maxNumberOfFamilies(3, new int[][] { { 1, 2 }, { 1, 3 }, { 1, 8 }, { 2, 6 }, { 3, 1 }, { 3, 10 } }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(2, maxNumberOfFamilies(2, new int[][] { { 2, 1 }, { 1, 8 }, { 2, 6 } }));
    }

    @Test
    public void test3() {
        Assert.assertEquals(4, maxNumberOfFamilies(4, new int[][] { { 4, 3 }, { 1, 4 }, { 4, 6 }, { 1, 7 } }));
    }
}
