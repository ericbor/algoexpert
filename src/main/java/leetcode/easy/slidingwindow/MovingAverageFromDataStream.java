package leetcode.easy.slidingwindow;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/moving-average-from-data-stream/
public class  MovingAverageFromDataStream {
    int windowSize;
    int windowSum;
    Queue<Integer> queue = new LinkedList<>();

    public MovingAverageFromDataStream() {
    }

/*    public double next(int val) {
        list.add(val);

        int sum = 0;
        int start = Math.max(0, list.size() - windowSize);
        for (int i = start; i < list.size(); i++) {
            sum += list.get(i);
        }

        int divideBy = Math.min(list.size(), windowSize);

        return sum * 1.0 / divideBy;
    }*/

    /*public double next(int val) {
        queue.add(val);
        if (queue.size() > windowSize) {
            queue.poll();
        }

        int sum = 0;
        for (int num : queue) {
            sum += num;
        }

        int divideBy = Math.min(queue.size(), windowSize);

        return sum * 1.0 / divideBy;
    }*/

    public double next(int val) {
        // calculate the new sum by shifting the window
        queue.add(val);
        int head = queue.size() > windowSize ? queue.poll() : 0;

        windowSum = windowSum - head + val;

        int divideBy = Math.min(queue.size(), windowSize);
        return windowSum * 1.0 / divideBy;
    }

    @Test
    public void test() {
        MovingAverageFromDataStream ma = new MovingAverageFromDataStream();
        ma.windowSize = 3;

        Assert.assertEquals(1.0, ma.next(1), 2);
        Assert.assertEquals(5.5, ma.next(10), 2);
        Assert.assertEquals(4.66667, ma.next(3), 2);
        Assert.assertEquals(6.0, ma.next(5), 2);
    }
}
