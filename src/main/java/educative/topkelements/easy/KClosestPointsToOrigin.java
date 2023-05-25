package educative.topkelements.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
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
    public static List<Point> findClosestPoints(Point[] points, int k) {
        ArrayList<Point> result = new ArrayList<>();

        Queue<Point> maxHeap = new PriorityQueue<>((p1, p2) -> p2.distFromOrigin() - p1.distFromOrigin());

        for (Point point : points) {
            maxHeap.add(point);

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        return new ArrayList<>(maxHeap);
    }

    @Test
    public void main() {
        Assert.assertEquals(List.of(new Point(1, 2)), findClosestPoints(new Point[]{new Point(1, 2), new Point(1, 3)}, 1));
    }

    @Test
    public void main2() {
        Assert.assertEquals(List.of(new Point(1, 3), new Point(2, -1)), findClosestPoints(new Point[]{new Point(1, 3), new Point(3, 4), new Point(2, -1)}, 2));
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int distFromOrigin() {
        // ignoring sqrt
        return (x * x) + (y * y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
