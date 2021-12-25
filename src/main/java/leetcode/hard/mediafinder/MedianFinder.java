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
        if (minHeap.isEmpty()) {
            minHeap.add(num);
        } else if (maxHeap.isEmpty()) {
            if (num <= minHeap.peek()) {
                maxHeap.add(num);
            } else {
                int tmp = minHeap.poll();
                minHeap.add(num);
                maxHeap.add(tmp);
            }
        } else if (minHeap.size() == maxHeap.size()) {
            if (num < maxHeap.peek()) {
                int tmp = maxHeap.poll();
                maxHeap.add(num);
                minHeap.add(tmp);
            } else if (num >= maxHeap.peek()) {
                minHeap.add(num);
            }
        } else {
            if (num <= maxHeap.peek() || num < minHeap.peek()) {
                maxHeap.add(num);
            } else {
                int tmp = minHeap.poll();
                minHeap.add(num);
                maxHeap.add(tmp);
            }
        }
    }

    public double findMedian() {
        if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        }

        return ((double) maxHeap.peek() + minHeap.peek()) / 2;
    }
}
