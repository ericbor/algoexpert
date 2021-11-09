package leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/sort-array-by-increasing-frequency/
public class SortArrayByIncreasingFrequency {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Queue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((e1, e2) -> {
            if(e1.getValue() == e2.getValue()) {
                return e2.getValue() - e1.getValue();
            }

            return e1.getValue() - e2.getValue();
        });

        heap.addAll(map.entrySet());

        int[] results = new int[nums.length];
        for(int i = 0; i < results.length; i++) {
            results[i] = heap.poll().getKey();
        }

        return results;
    }
}
