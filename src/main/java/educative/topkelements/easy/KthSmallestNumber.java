package educative.topkelements.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
Given an unsorted array of numbers, find Kth smallest number in it.
Please note that it is the Kth smallest number in the sorted order, not the Kth distinct element.

Input: [1, 5, 12, 2, 11, 5], K = 3 ... Output: 5
Explanation: The 3rd smallest number is '5', as the first two smaller numbers are [1, 2].

Input: [1, 5, 12, 2, 11, 5], K = 4 ... Output: 5
Explanation: The 4th smallest number is '5', as the first three small numbers are [1, 2, 5].

Input: [5, 12, 11, -1, 12], K = 3 ... Output: 11
Explanation: The 3rd smallest number is '11', as the first two small numbers are [5, -1].
 */
public class KthSmallestNumber {
    public static int findKthSmallestNumber(int[] nums, int k) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < k; i++) {
            maxHeap.add(nums[i]);
        }

        for (int j = k; j < nums.length; j++) {
            if (nums[j] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.add(nums[j]);
            }
        }

        return maxHeap.peek();
    }

    @Test
    public void main() {
        Assert.assertEquals(5, findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 3));
    }

    @Test
    public void main2() {
        Assert.assertEquals(5, findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 4));
    }

    @Test
    public void main3() {
        Assert.assertEquals(11, findKthSmallestNumber(new int[] { 5, 12, 11, -1, 12 }, 3));
    }
}
