package educative.topkelements.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

/*
Given an array of points in a 2D2D plane, find ‘K’ closest points to the origin.

Input: points = [[1,2],[1,3]], K = 1
Output: [[1,2]]
Explanation: The Euclidean distance between (1, 2) and the origin is sqrt(5).
The Euclidean distance between (1, 3) and the origin is sqrt(10).
Since sqrt(5) < sqrt(10), therefore (1, 2) is closer to the origin.

Input: point = [[1, 3], [3, 4], [2, -1]], K = 2
Output: [[1, 3], [2, -1]]
 */
public class KClosestPointsToOrigin {
    public int[][] findClosestPoints(int[][] points, int k) {
        if (k == points.length) {
            return points;
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> getEuclidianDistance(b) - getEuclidianDistance(a));

        for (int i = 0; i < k; i++) {
            maxHeap.add(points[i]);
        }

        for (int j = k; j < points.length; j++) {

            if (getEuclidianDistance(points[j]) < getEuclidianDistance(maxHeap.peek())) {
                maxHeap.poll();
                maxHeap.add(points[j]);
            }
        }
        return maxHeap.toArray(new int[0][0]);
    }

    private int getEuclidianDistance(int[] arr) {
        return arr[0] * arr[0] + arr[1] * arr[1];
    }

    @Test
    public void main() {
        Assert.assertArrayEquals(new int[][] { { 1, 2 } }, findClosestPoints(new int[][] { { 1, 2 }, { 1, 3 } }, 1));
    }

    @Test
    public void main2() {
        Assert.assertArrayEquals(new int[][] { { 1, 3 }, { 2, -1 } }, findClosestPoints(new int[][] { { 1, 3 }, { 3, 4 }, { 2, -1 } }, 2));
    }
}
