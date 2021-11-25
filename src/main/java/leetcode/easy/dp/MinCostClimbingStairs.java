package leetcode.easy.dp;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/min-cost-climbing-stairs/
public class MinCostClimbingStairs {

    public int minCostClimbingStairs2(int[] cost) {
        int[] minCost = new int[cost.length + 1];

        // Start iteration from step 2, since the minimum cost of reaching step 0 and step 1 is 0
        for (int i = 2; i < minCost.length; i++) {
            int takeOneStep = minCost[i - 1] + cost[i - 1];
            int takeTwoSteps = minCost[i - 2] + cost[i - 2];

            minCost[i] = Math.min(takeOneStep, takeTwoSteps);
        }

        // The final element in minimumCost refers to the top floor
        return minCost[minCost.length - 1];
    }

    private final Map<Integer, Integer> memo = new HashMap<>();

    public int minCostClimbingStairs(int[] cost) {
        return minimumCost(cost.length, cost);
    }

    private int minimumCost(int i, int[] cost) {
        // Base case, we are allowed to start at either step 0 or step 1
        if (i <= 1) {
            return 0;
        }

        // Check if we have already calculated minimumCost(i)
        if (memo.containsKey(i)) {
            return memo.get(i);
        }

        // If not, cache the result in our hash map and return it
        int downOne = cost[i - 1] + minimumCost(i - 1, cost);
        int downTwo = cost[i - 2] + minimumCost(i - 2, cost);
        memo.put(i, Math.min(downOne, downTwo));
        return memo.get(i);
    }

    @Test
    public void test() {
        Assert.assertEquals(6, minCostClimbingStairs(new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(15, minCostClimbingStairs(new int[] { 10, 15, 20 }));
    }
}
