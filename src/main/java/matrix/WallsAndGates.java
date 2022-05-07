package matrix;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/walls-and-gates/
public class WallsAndGates {
    public void wallsAndGates(int[][] rooms) {

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new int[] { i, j });
                }
            }
        }

        int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];
            for (int[] dir : directions) {
                int r = row + dir[0];
                int c = col + dir[1];
                if (r < 0 || c < 0 || r >= rooms.length || c >= rooms[0].length || rooms[r][c] != Integer.MAX_VALUE) {
                    continue;
                }
                rooms[r][c] = rooms[row][col] + 1;
                queue.add(new int[] { r, c });
            }
        }

    }

    @Test
    public void test() {
        int[][] rooms = { { 2147483647, -1, 0, 2147483647 }, { 2147483647, 2147483647, 2147483647, -1 }, { 2147483647, -1, 2147483647, -1 }, { 0, -1, 2147483647, 2147483647 } };

        wallsAndGates(rooms);

        Assert.assertArrayEquals(new int[][] { { 3, -1, 0, 1 }, { 2, 2, 1, -1 }, { 1, -1, 2, -1 }, { 0, -1, 3, 4 } }, rooms);
    }
}
