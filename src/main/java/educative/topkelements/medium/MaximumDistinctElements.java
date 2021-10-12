package educative.topkelements.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*
Given an array of numbers and a number ‘K’, we need to remove ‘K’ numbers from the array such that we are left with maximum distinct numbers.

Input: [7, 3, 5, 8, 5, 3, 3], and K=2
Output: 3
Explanation: We can remove two occurrences of 3 to be left with 3 distinct numbers [7, 3, 8], we have to skip 5 because it is not distinct and appeared twice.

Another solution could be to remove one instance of '5' and '3' each to be left with three distinct numbers [7, 5, 8],
in this case, we have to skip 3 because it appeared twice.
 */
public class MaximumDistinctElements {
    public static int findMaximumDistinctElements(int[] nums, int k) {
        int distinct = 0;
        if (nums.length <= k) {
            return distinct;
        }

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        Queue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((e1, e2) -> e1.getValue() - e2.getValue());

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == 1) {
                distinct++;
            } else {
                minHeap.add(entry);
            }
        }

        // following a greedy approach, try removing the least frequent numbers first from the min-heap
        while (k > 0 && !minHeap.isEmpty()) {
            Map.Entry<Integer, Integer> entry = minHeap.poll();
            k -= entry.getValue() - 1;
            if (k >= 0) {
                distinct++;
            }
        }

        // if k > 0, this means we have to remove some distinct numbers
        if (k > 0) {
            distinct -= k;
        }

        return distinct;
    }

    @Test
    public void main() {
        Assert.assertEquals(3, findMaximumDistinctElements(new int[] { 7, 3, 5, 8, 5, 3, 3 }, 2));
    }

    @Test
    public void main2() {
        Assert.assertEquals(2, findMaximumDistinctElements(new int[] { 3, 5, 12, 11, 12 }, 3));
    }

    @Test
    public void main3() {
        Assert.assertEquals(3, findMaximumDistinctElements(new int[] { 1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5 }, 2));
    }
}
