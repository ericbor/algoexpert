package leetcode.medium.matrix;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/cut-off-trees-for-golf-event/
public class CutOffTreesForGolfEvent {
    private static final int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int cutOffTree(List<List<Integer>> forest) {
        if (forest == null || forest.isEmpty()) {
            return 0;
        }

        int m = forest.size();
        int n = forest.get(0).size();

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (forest.get(i).get(j) > 1) {
                    pq.add(new int[] { i, j, forest.get(i).get(j) });
                }
            }
        }

        int[] start = new int[2];
        int sum = 0;
        while (!pq.isEmpty()) {
            int[] nextTree = pq.poll();
            int step = minStep(forest, start, nextTree, m, n);

            if (step < 0) {
                return -1;
            }
            sum += step;

            start[0] = nextTree[0];
            start[1] = nextTree[1];
        }

        return sum;
    }

    private int minStep(List<List<Integer>> forest, int[] start, int[] tree, int m, int n) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);

        boolean[][] visited = new boolean[m][n];
        visited[start[0]][start[1]] = true;

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                if (curr[0] == tree[0] && curr[1] == tree[1]) {
                    return step;
                }

                for (int[] dir : directions) {
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];
                    if (r >= 0 && r < m && c >= 0 && c < n && forest.get(r).get(c) != 0 && !visited[r][c]) {
                        queue.add(new int[] { r, c });
                        visited[r][c] = true;
                    }
                }
            }
            step++;
        }

        return -1;
    }

    @Test
    public void test() {
        Assert.assertEquals(57, cutOffTree(List.of(
            List.of(54581641, 64080174, 24346381, 69107959),
            List.of(86374198, 61363882, 68783324, 79706116),
            List.of(668150, 92178815, 89819108, 94701471),
            List.of(83920491, 22724204, 46281641, 47531096),
            List.of(89078499, 18904913, 25462145, 60813308))));
    }

    @Test
    public void test2() {
        Assert.assertEquals(6, cutOffTree(List.of(List.of(1, 2, 3), List.of(0, 0, 4), List.of(7, 6, 5))));
    }

    @Test
    public void test4() {
        Assert.assertEquals(-1, cutOffTree(List.of(List.of(1, 2, 3), List.of(0, 0, 0), List.of(7, 6, 5))));
    }

    @Test
    public void test3() {
        Assert.assertEquals(6, cutOffTree(List.of(List.of(2, 3, 4), List.of(0, 0, 5), List.of(8, 7, 6))));
    }

    @Test
    public void test5() {
        Assert.assertEquals(-1, cutOffTree(List.of(List.of(0), List.of(0), List.of(6014))));
    }
}
