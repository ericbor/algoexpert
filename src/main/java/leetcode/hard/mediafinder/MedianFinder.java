package leetcode.hard.mediafinder;

import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {
    private final Queue<Integer> min;
    private final Queue<Integer> max;

    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        if (min.size() == max.size()) {
            max.add(num);
            min.add(max.poll());
        } else {
            min.add(num);
            max.add(min.poll());
        }
    }

    public double findMedian() {
        if (min.size() > max.size()) {
            return min.peek();
        }

        return ((double) max.peek() + min.peek()) / 2;
    }
}
