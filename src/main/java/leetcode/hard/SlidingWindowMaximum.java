package leetcode.hard;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

//https://leetcode.com/problems/sliding-window-maximum/
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow2(int[] nums, int k) {
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int start = 0;
        int[] results = new int[nums.length / k * k];
        int i = 0;

        for (int num : nums) {
            maxHeap.add(num);

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
        if (nums == null || k <= 0) {
            return new int[0];
        }

        int[] results = new int[nums.length - k + 1];
        int start = 0;
        // store index
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // remove numbers out of range k
            int range = i - k + 1;
            while (!queue.isEmpty() && queue.peek() < range) {
                queue.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }

            // queue contains index... results contains content
            queue.add(i);
            if (i >= k - 1) {
                results[start] = nums[queue.peek()];
                start++;
            }
        }

        return results;
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{3, 3, 5, 5, 6, 7}, maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
        Assert.assertArrayEquals(new int[]{3, 3, 5, 5, 6, 7}, maxSlidingWindow2(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));

    }

    @Test
    public void test2() {
        Assert.assertArrayEquals(new int[]{1, -1}, maxSlidingWindow(new int[]{1, -1}, 1));
    }

    @Test
    public void test3() {
        Assert.assertArrayEquals(new int[]{1}, maxSlidingWindow(new int[]{1}, 1));
    }
}
