package educative.twoheaps.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

//https://www.educative.io/courses/grokking-the-coding-interview/3Yj2BmpyEy4
public class MedianOfAStream {
    private final PriorityQueue<Integer> maxHeap; //containing first half of numbers
    private final PriorityQueue<Integer> minHeap; //containing second half of numbers

    public MedianOfAStream() {
        maxHeap = new PriorityQueue<>(Comparator.naturalOrder());
        minHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void insertNum(int num) {
        if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        // either both the heaps will have equal number of elements or max-heap will have one
        // more element than the min-heap
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            // we have even number of elements, take the average of middle two elements
            return maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
        }
        // because max-heap will have one more element than the min-heap
        return maxHeap.peek();
    }

    @Test
    public void main() {
        MedianOfAStream medianOfAStream = new MedianOfAStream();
        medianOfAStream.insertNum(3);
        medianOfAStream.insertNum(1);
        Assert.assertEquals(2.0, medianOfAStream.findMedian(), 0);

        medianOfAStream.insertNum(5);
        Assert.assertEquals(3.0, medianOfAStream.findMedian(), 0);
        medianOfAStream.insertNum(4);
        Assert.assertEquals(3.5, medianOfAStream.findMedian(), 0);
    }
}
