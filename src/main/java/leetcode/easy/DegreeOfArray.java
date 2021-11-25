package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/degree-of-an-array/
public class DegreeOfArray {
    public int findShortestSubArray2(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(i);
                map.put(nums[i], list);
            }
        }

        Queue<Map.Entry<Integer, List<Integer>>> maxHeap = new PriorityQueue<>((e1, e2) -> {
            List<Integer> e1List = e1.getValue();
            List<Integer> e2List = e2.getValue();
            if (e1List.size() == e2List.size()) {
                int e1Pos = Math.abs(e1List.get(0) - e1List.get(e1List.size() - 1));
                int e2Pos = Math.abs(e2List.get(0) - e2List.get(e2List.size() - 1));
                return e1Pos - e2Pos;
            }
            return e2List.size() - e1List.size();
        });

        maxHeap.addAll(map.entrySet());
        List<Integer> result = maxHeap.poll().getValue();
        int pos = Math.abs(result.get(0) - result.get(result.size() - 1));

        return pos + 1;
    }

    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (left.get(x) == null) {
                left.put(x, i);
            }
            right.put(x, i);
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        int ans = nums.length;
        int degree = Collections.max(count.values());
        for (int x : count.keySet()) {
            if (count.get(x) == degree) {
                ans = Math.min(ans, right.get(x) - left.get(x) + 1);
            }
        }
        return ans;
    }

    @Test
    public void test() {
        Assert.assertEquals(2, findShortestSubArray(new int[] { 1, 2, 2, 3, 1 }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(6, findShortestSubArray(new int[] { 1, 2, 2, 3, 1, 4, 2 }));
    }
}
