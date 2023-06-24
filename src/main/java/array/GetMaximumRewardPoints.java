package array;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

//https://leetcode.com/discuss/interview-question/2836695/Diabolocom-Backend-Hiring-Test-or-Hackerrank-OA-or-2022-or-Task-Completion-or-Job-Scheduling
public class GetMaximumRewardPoints {
    public int getMaximumRewardPoints(int K, int[] reward_1, int[] reward_2) {
        Queue<int[]> heap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < reward_1.length; i++) {
            heap.add(new int[]{i, reward_1[i] - reward_2[i]});
        }

        int maxReward = 0;

        for (int i = 0; i < K; i++) {
            int index = heap.poll()[0];
            maxReward += reward_1[index];
        }

        while (!heap.isEmpty()) {
            int index = heap.poll()[0];
            maxReward += reward_2[index];
        }

        return maxReward;
    }

    @Test
    public void test() {
        Assert.assertEquals(21, getMaximumRewardPoints(3, new int[]{5, 4, 3, 2, 1}, new int[]{1, 2, 3, 4, 5}));
    }
}
