package leetcode.medium.heap;

import org.junit.Assert;
import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/minimum-cost-to-connect-sticks/
public class MinCostToConnectSticks {
    //O(N log N), O(N)
    public int connectSticks(int[] sticks) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int stick : sticks) {
            //Adding N elements to the priority queue will be O(N log N )
            minHeap.add(stick);
        }

        int minCost = 0;
        while (minHeap.size() > 1) {
            int currMinCost = minHeap.poll() + minHeap.poll();
            minCost += currMinCost;
            minHeap.add(currMinCost);
        }

        return minCost;
    }

    @Test
    public void test() {
        Assert.assertEquals(14, connectSticks(new int[] { 2, 4, 3 }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(30, connectSticks(new int[] { 1, 8, 3, 5 }));
    }

    @Test
    public void test3() {
        Assert.assertEquals(0, connectSticks(new int[] { 5 }));
    }

}
