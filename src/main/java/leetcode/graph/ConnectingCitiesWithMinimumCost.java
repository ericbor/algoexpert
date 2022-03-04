package leetcode.graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/connecting-cities-with-minimum-cost/
public class ConnectingCitiesWithMinimumCost {
    public int minimumCost(int n, int[][] connections) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] connection : connections) {
            int city1 = connection[0];
            int city2 = connection[1];
            int cost = connection[2];

            graph.computeIfAbsent(city1, key -> new ArrayList<>());
            graph.computeIfAbsent(city2, key -> new ArrayList<>());

            graph.get(city1).add(new int[] { city2, cost });
            graph.get(city2).add(new int[] { city1, cost });
        }

        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minHeap.add(new int[] { 1, 0 }); // {1=city, 0=cost} Start with city 1 (there are N cities labedl from 1 to N)

        boolean[] visited = new boolean[n + 1]; // cities start from 1, not 0, that's why we need array n+1 (index 0 won't be used)

        int cost = 0;
        int numOfCitiesVisited = 0;
        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();

            if (visited[curr[0]]) {
                continue;
            }

            visited[curr[0]] = true;
            cost += curr[1];
            numOfCitiesVisited++;// not all node may be visited.

            List<int[]> neighbors = graph.get(curr[0]);
            for (int[] neighbor : neighbors) {
                if (!visited[neighbor[0]]) {
                    minHeap.add(neighbor);
                }
            }
        }

        return numOfCitiesVisited == n ? cost : -1;
    }

    @Test
    public void test() {
        Assert.assertEquals(6, minimumCost(4, new int[][] { { 1, 2, 1 }, { 1, 3, 2 }, { 3, 4, 4 }, { 1, 4, 3 } }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(6, minimumCost(3, new int[][] { { 1, 2, 5 }, { 1, 3, 6 }, { 2, 3, 1 } }));
    }

    @Test
    public void test3() {
        Assert.assertEquals(-1, minimumCost(4, new int[][] { { 1, 2, 3 }, { 3, 4, 4 } }));
    }
}
