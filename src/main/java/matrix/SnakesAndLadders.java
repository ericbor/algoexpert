package matrix;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

//https://leetcode.com/problems/snakes-and-ladders/
public class SnakesAndLadders {
    public int snakesAndLadders(int[][] board) {
        //Step1: Convert board to hashmap to map the board cell number to cell value for easier calculation
        int n = board.length;
        Map<Integer, Integer> map = new HashMap<>();
        int end = n * n;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if ((n - row) % 2 == 0) {
                    map.put(end, board[row][col]);
                } else {
                    map.put(end, board[row][n - col - 1]);
                }
                end--;
            }
        }
        // breadth-first-search
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        Set<Integer> visited = new HashSet<>();
        visited.add(1);  // For visited  cells
        int step = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                if (current == n * n) {    // Reached the top!
                    return step;
                }

                for (int j = 1; j <= 6; j++) {
                    int newPoint = current + j;
                    if (newPoint > n * n) {
                        continue;       // We are outside the board now with this choice
                    }
                    if (map.get(newPoint) != -1) {
                        newPoint = map.get(newPoint);    // Either snake or ladder (doesn't matter)
                    }
                    if (!visited.contains(newPoint)) {
                        queue.add(newPoint);
                        visited.add(newPoint);
                    }
                }
            }
            step++;
        }

        return -1;
    }

    @Test
    public void test() {
        Assert.assertEquals(4, snakesAndLadders(new int[][] { { -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1 }, { -1, 35, -1, -1, 13, -1 }, { -1, -1, -1, -1, -1, -1 }, { -1, 15, -1, -1, -1, -1 } }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(1, snakesAndLadders(new int[][] { { -1, -1 }, { -1, 3 } }));
    }
}
