package leetcode.hard;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/sliding-window-maximum/
public class SlidingWindowMaximum {

    public int[] maxSlidingWindow2(int[] nums, int k) {
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int start = 0;
        int currMax = Integer.MIN_VALUE;
        int[] results = new int[nums.length / k * k];
        int i = 0;

        for (int end = 0; end < nums.length; end++) {
            maxHeap.add(nums[end]);

            if (maxHeap.size() == k) {
                results[i] = maxHeap.peek();
                i++;

                maxHeap.remove(nums[start]);
                start++;
            }
        }

        return results;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        // assume nums is not null
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }

        int[] result = new int[nums.length - k + 1]; // number of windows
        Deque<Integer> win = new ArrayDeque<>(); // stores indices

        for (int i = 0; i < nums.length; ++i) {
            // remove indices that are out of bound
            while (win.size() > 0 && win.peekFirst() <= i - k) {
                win.pollFirst();
            }

            // remove indices whose corresponding values are less than nums[i]
            while (win.size() > 0 && nums[win.peekLast()] < nums[i]) {
                win.pollLast();
            }

            // add nums[i]
            win.offerLast(i);
            // add to result
            if (i >= k - 1) {
                result[i - k + 1] = nums[win.peekFirst()];
            }
        }
        return result;
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[] { 3, 3, 5, 5, 6, 7 }, maxSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3));
    }

    @Test
    public void test2() {
        Assert.assertArrayEquals(new int[] { 1, -1 }, maxSlidingWindow(new int[] { 1, -1 }, 1));
    }

    @Test
    public void test3() {
        Assert.assertArrayEquals(new int[] { 1 }, maxSlidingWindow(new int[] { 1 }, 1));
    }
}
