package array.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

//https://leetcode.com/problems/kth-largest-element-in-an-array
public class KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
        for(int num: nums) {
            minHeap.add(num);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }

    public int findKthLargest_2(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int num: nums) {
            list.add(num);
        }

        return quickSelect(list, k);
    }

    public int quickSelect(List<Integer> nums, int k) {
        int pivotIndex = new Random().nextInt(nums.size());
        int pivot = nums.get(pivotIndex);

        List<Integer> left = new ArrayList<>();
        List<Integer> mid = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int num: nums) {
            if (num > pivot) {
                left.add(num);
            } else if (num < pivot) {
                right.add(num);
            } else {
                mid.add(num);
            }
        }

        if (k <= left.size()) {
            return quickSelect(left, k);
        }

        if (left.size() + mid.size() < k) {
            return quickSelect(right, k - left.size() - mid.size());
        }

        return pivot;
    }

    @Test
    public void test() {
        Assert.assertEquals(5, findKthLargest(new int[]{3,2,1,5,6,4}, 2));
        Assert.assertEquals(5, findKthLargest_2(new int[]{3,2,1,5,6,4}, 2));
    }

    @Test
    public void test2() {
        Assert.assertEquals(4, findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
        Assert.assertEquals(4, findKthLargest_2(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
}
