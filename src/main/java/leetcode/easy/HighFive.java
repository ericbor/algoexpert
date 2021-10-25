package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/high-five/
public class HighFive {
    public int[][] highFive(int[][] items) {
        Map<Integer, Queue<Integer>> map = new HashMap<>();

        for (int[] item : items) {
            int id = item[0];
            int score = item[1];

            if (!map.containsKey(id)) {
                Queue<Integer> queue = new PriorityQueue<>((a, b) -> a - b);
                map.put(id, queue);
            }

            map.get(id).add(score);

            if(map.get(id).size() > 5) {
                map.get(id).poll();
            }
        }

        int[][] results = new int[map.size()][2];
        int i = 0;
        for (int id : map.keySet()) {
            int sum = 0;
            Queue<Integer> queue = map.get(id);
            while(!queue.isEmpty()) {
                sum += queue.poll();
            }
            int average = sum / 5;
            results[i][0] = id;
            results[i][1] = average;
            i++;
        }

        return results;
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[][] { { 1, 87 }, { 2, 88 } }, highFive(new int[][] { { 1, 91 }, { 1, 92 }, { 2, 93 }, { 2, 97 }, { 1, 60 }, { 2, 77 }, { 1, 65 }, { 1, 87 }, { 1, 100 }, { 2, 100 }, { 2, 76 } }));
    }
}
