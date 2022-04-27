package matrix;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/minimum-knight-moves/
public class MinimumKnightMoves {
    public int minKnightMoves(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { 0, 0 });

        boolean[][] visited = new boolean[607][607];
        int moves = 0;
        int[][] directions = { { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 }, { -2, -1 }, { -2, 1 }, { -1, 2 } };

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();

                if (curr[0] == x && curr[1] == y) {
                    return moves;
                }

                for (int[] dir : directions) {
                    int[] next = { curr[0] + dir[0], curr[1] + dir[1] };
                    if (!visited[next[0] + 302][next[1] + 302]) {
                        visited[next[0] + 302][next[1] + 302] = true;
                        queue.add(next);
                    }
                }
            }
            moves++;
        }

        return moves;
    }

    @Test
    public void test() {
        Assert.assertEquals(4, minKnightMoves(5,5));
    }
}
