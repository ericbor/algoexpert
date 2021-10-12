package educative.topkelements.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
Given an unsorted array of numbers, find the ‘K’ largest numbers in it.

Input: [3, 1, 5, 12, 2, 11], K = 3 ... Output: [5, 12, 11]
Input: [5, 12, 11, -1, 12], K = 3 ... Output: [12, 11, 12]
 */
public class KLargestNumbers {
    public static List<Integer> findKLargestNumbers(int[] nums, int k) {
        Queue<Integer> minHeap = new PriorityQueue<>(Comparator.naturalOrder());
        for (int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }
        for (int j = k; j < nums.length; j++) {
            if (nums[j] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(nums[j]);
            }
        }

        return new ArrayList<>(minHeap);
    }

    @Test
    public void main() {
        Assert.assertEquals(List.of(5, 12, 11), findKLargestNumbers(new int[] { 3, 1, 5, 12, 2, 11 }, 3));
    }

    @Test
    public void main2() {
        Assert.assertEquals(List.of(11, 12, 12), findKLargestNumbers(new int[] { 5, 12, 11, -1, 12 }, 3));
    }
}
