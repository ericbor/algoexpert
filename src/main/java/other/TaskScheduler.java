package other;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/task-scheduler/description/
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        if(n == 0) {
            return tasks.length;
        }

        Map<Character, Integer> map = new HashMap<>();
        for(char c: tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b-a);
        maxHeap.addAll(map.values());
        int maxFreq = maxHeap.poll();
        int totalIdleTime = (maxFreq - 1) * n;

        while(!maxHeap.isEmpty()) {
            int currFreq = maxHeap.poll();
            if(currFreq == maxFreq) {
                totalIdleTime -= currFreq;
                totalIdleTime++;
            } else {
                totalIdleTime -= currFreq;
            }
        }

        if(totalIdleTime > 0) {
            return totalIdleTime + tasks.length;
        }

        return tasks.length;
    }

    @Test
    public void test() {
        Assert.assertEquals(8, leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
    }
    @Test
    public void test2() {
        Assert.assertEquals(16, leastInterval(new char[]{'A','A','A','A','A','A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2));
    }
}
