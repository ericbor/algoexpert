package educative.topkelements.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*
Given an unsorted array of numbers, find the top ‘K’ frequently occurring numbers in it.

Input: [1, 3, 5, 12, 11, 12, 11], K = 2 ... Output: [12, 11]
Explanation: Both '11' and '12' apeared twice.

Input: [5, 12, 11, 3, 11], K = 2 ... Output: [11, 5] or [11, 12] or [11, 3]
Explanation: Only '11' appeared twice, all other numbers appeared once.
 */
public class TopKFrequentNumbers {
    public static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        Queue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((e1, e2) -> e1.getValue() - e2.getValue());

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        List<Integer> topNumbers = new ArrayList<>(k);
        while (!minHeap.isEmpty()) {
            topNumbers.add(minHeap.poll().getKey());
        }

        return topNumbers;
    }

    @Test
    public void main() {
        Assert.assertEquals(List.of(12, 11), findTopKFrequentNumbers(new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2));
    }

    @Test
    public void main2() {
        List<Integer> result = findTopKFrequentNumbers(new int[] { 5, 12, 11, 3, 11 }, 2);
        Assert.assertEquals(2, result.size());
        Assert.assertTrue(result.contains(11));
    }
}
