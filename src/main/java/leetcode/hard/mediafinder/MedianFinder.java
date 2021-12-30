package leetcode.hard.mediafinder;

import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {
    private final Queue<Integer> minHeap;
    private final Queue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        if (minHeap.size() == maxHeap.size()) {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        } else {
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        }

        return ((double) maxHeap.peek() + minHeap.peek()) / 2;
    }
}
