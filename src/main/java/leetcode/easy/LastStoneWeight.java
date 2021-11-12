package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/last-stone-weight/
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        /*if(stones.length == 1) {
            return stones[0];
        }*/

        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for(int stone: stones) {
            maxHeap.add(stone);
        }

        while(!maxHeap.isEmpty() && maxHeap.size() > 1) {
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();
            int diff = stone1 - stone2;
            if(diff > 0) {
                maxHeap.add(diff);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }

    @Test
    public void test() {
        Assert.assertEquals(1, lastStoneWeight(new int[]{2,7,4,1,8,1}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(1, lastStoneWeight(new int[]{1}));
    }
}
