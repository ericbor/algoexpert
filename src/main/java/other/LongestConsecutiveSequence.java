package other;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/longest-consecutive-sequence
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int maxConsequtive = 1;
        if(nums.length == 1) {
            return maxConsequtive;
        }

        Map<Integer, Integer> set = new HashMap<>();
        for(int num: nums) {
            set.put(num, 0);
        }
        Queue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
        minHeap.addAll(set.keySet());


        int prev = minHeap.poll();
        int currConsequtive = maxConsequtive;
        while(!minHeap.isEmpty()) {
            int curr = minHeap.poll();
            if(prev + 1 == curr) {
                currConsequtive++;
            } else {
                currConsequtive = 1;
            }
            prev = curr;

            maxConsequtive = Math.max(maxConsequtive, currConsequtive);
        }

        return maxConsequtive;
    }

    @Test
    public void test() {
        Assert.assertEquals(4, longestConsecutive(new int[]{100,4,200,1,3,2}));
    }
}
