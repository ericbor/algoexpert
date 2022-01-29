package leetcode.easy.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/sliding-window-maximum/
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow_2(int[] nums, int k) {
        if (nums.length * k == 0) {
            return new int[0];
        }

        int[] output = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            output[i] = max;
        }
        return output;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }

        int[] results = new int[nums.length - k + 1];
        int ri = 0;
        // store index
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // remove numbers out of range k
            while (!queue.isEmpty() && queue.peek() < i - k + 1) {
                queue.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }

            // queue contains index... results contains content
            queue.add(i);
            if (i >= k - 1) {
                results[ri] = nums[queue.peek()];
                ri++;
            }
        }

        return results;
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[] { 3, 3, 5, 5, 6, 7 }, maxSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3));
    }

    @Test
    public void test2() {
        Assert.assertArrayEquals(new int[] { 3, 3, -1, 5, 5, 6, 7 }, maxSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 2));
    }
}
