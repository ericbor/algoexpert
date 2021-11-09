package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/
public class ManhattenDistance {
    public int nearestValidPoint2(int x, int y, int[][] points) {
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            int manDistanceA = Math.abs(x - a[0]) + Math.abs(y - a[1]);
            int manDistanceB = Math.abs(x - b[0]) + Math.abs(y - b[1]);

            if (manDistanceA == manDistanceB) {
                return a[0] - b[0];
            }

            return manDistanceA - manDistanceB;
        });

        for (int[] point : points) {
            if (point[0] == x || point[1] == y) {
                minHeap.add(point);
            }
        }

        if (minHeap.isEmpty()) {
            return -1;
        }

        int[] answer = minHeap.poll();
        if (answer[0] == x) {
            return 0;
        }

        return answer[0];
    }

    public int nearestValidPoint(int x, int y, int[][] points) {
        int index = -1;
        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            // valid point
            int[] point = points[i];
            if (point[0] == x || point[1] == y) {
                int currDist = Math.abs(point[0] - x) + Math.abs(point[1] - y);
                if (currDist < distance) {
                    distance = currDist;
                    index = i;
                }
            }
        }
        return index;
    }

    @Test
    public void test() {
        Assert.assertEquals(2, nearestValidPoint(3, 6, new int[][] { { 1, 3 }, { 9, 8 }, { 3, 8 }, { 3, 9 }, { 7, 4 }, { 3, 1 }, { 8, 1 } }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(2, nearestValidPoint(3, 4, new int[][] { { 1, 2 }, { 3, 1 }, { 2, 4 }, { 2, 3 }, { 4, 4 } }));
    }

    @Test
    public void test3() {
        Assert.assertEquals(0, nearestValidPoint(3, 4, new int[][] { { 3, 4 } }));
    }

    @Test
    public void test4() {
        Assert.assertEquals(-1, nearestValidPoint(3, 4, new int[][] { { 2, 3 } }));
    }
}
