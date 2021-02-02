package array.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

//https://leetcode.com/problems/high-five/
public class HighFive {
    private int K;

    public int[][] highFive(int[][] items) {
        this.K = 5;
        Map<Integer, Queue<Integer>> allScores = new TreeMap<>();
        for (int[] item : items) {
            int studentId = item[0];
            int score = item[1];
            if (!allScores.containsKey(studentId)) {
                //max heap
                allScores.put(studentId, new PriorityQueue<>((x, y) -> y - x));
            }
            allScores.get(studentId).add(score);
        }

        List<int[]> solution = new ArrayList<>();
        for (int studentId : allScores.keySet()) {
            int sum = 0;
            //obtain the top k scores (k = 5)
            for (int i = 0; i < this.K; i++) {
                sum += allScores.get(studentId).poll();
            }
            solution.add(new int[] { studentId, sum / K });
        }

        int[][] solutionArray = new int[solution.size()][];

        return solution.toArray(solutionArray);
    }

    @Test
    public void verify() {
        Assert.assertArrayEquals(new int[][] { { 1, 87 }, { 2, 88 } }, highFive(new int[][] { { 1, 91 }, { 1, 92 }, { 2, 93 }, { 2, 97 }, { 1, 60 }, { 2, 77 }, { 1, 65 }, { 1, 87 }, { 1, 100 }, { 2, 100 }, { 2, 76 } }));
    }
}
