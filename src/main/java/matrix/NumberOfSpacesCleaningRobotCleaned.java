package matrix;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/number-of-spaces-cleaning-robot-cleaned/
public class NumberOfSpacesCleaningRobotCleaned {
    private static final int[][] DIRECTIONS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public int numberOfCleanRooms(int[][] room) {
        int m = room.length;
        int n = room[0].length;

        int[][] visited = new int[m][n];

        int count = 0;
        int row = 0, col = 0, dir = 0;

        while (true) {

            if(visited[row][col] == dir) {
                return count;
            }

            int r = DIRECTIONS[dir][0] + row;
            int c = DIRECTIONS[dir][1] + col;

            if (r >= 0 && r < m && c >= 0 && c < n && room[r][c] == 0) {
                count++;
                row = r;
                col = c;
                visited[row][col] = dir;
            } else {
                dir = (dir + 1) % 4;
            }
        }

    }

    @Test
    public void test() {
        Assert.assertEquals(8, numberOfCleanRooms(new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } }));
    }

    @Test
    public void test3() {
        Assert.assertEquals(7, numberOfCleanRooms(new int[][] { { 0, 0, 0 }, { 1, 1, 0 }, { 0, 0, 0 } }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(1, numberOfCleanRooms(new int[][] { { 0, 1, 0 }, { 1, 0, 0 }, { 0, 0, 0 } }));
    }
}
