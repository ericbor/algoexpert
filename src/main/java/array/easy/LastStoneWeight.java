package array.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/last-stone-weight/
public class LastStoneWeight {
    //Time: O (n log n), Space: O(n)
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            queue.add(stone);
        }

        while (queue.size() > 1) {
            int stoneA = queue.poll();
            int stoneB = queue.poll();

            if (stoneA > stoneB) {
                queue.add(stoneA - stoneB);
            }
        }

        return queue.isEmpty() ? 0 : queue.peek();
    }

    @Test
    public void verify() {
        Assert.assertEquals(1, lastStoneWeight(new int[] { 2, 7, 4, 1, 8, 1 }));
        Assert.assertEquals(0, lastStoneWeight(new int[] { 2, 2 }));
    }
}
