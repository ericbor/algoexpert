package leetcode.graph;

import leetcode.easy.design.Pair;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/cheapest-flights-within-k-stops/
public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int maxStops) {

        // Build the adjacency matrix
        int[][] adjMatrix = new int[n][n];
        for (int[] flight: flights) {
            adjMatrix[flight[0]][flight[1]] = flight[2];
        }

        // Shortest distances array
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);

        // Shortest steps array
        int[] currentStops = new int[n];
        Arrays.fill(currentStops, Integer.MAX_VALUE);

        distances[src] = 0;
        currentStops[src] = 0;

        // The priority queue would contain (node, cost, stops)
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minHeap.offer(new int[]{src, 0, 0});

        while (!minHeap.isEmpty()) {

            int[] info = minHeap.poll();
            int node = info[0];
            int stops = info[2];
            int cost = info[1];

            // If destination is reached, return the cost to get here
            if (node == dst) {
                return cost;
            }

            // If there are no more steps left, continue
            if (stops == maxStops + 1) {
                continue;
            }

            // Examine and relax all neighboring edges if possible
            for (int nei = 0; nei < n; nei++) {
                if (adjMatrix[node][nei] > 0) {
                    int dU = cost;
                    int dV = distances[nei];
                    int wUV = adjMatrix[node][nei];

                    // Better cost?
                    if (dU + wUV < dV) {
                        minHeap.offer(new int[]{nei, dU + wUV, stops + 1});
                        distances[nei] = dU + wUV;
                    } else if (stops < currentStops[nei]) {
                        // Better steps?
                        minHeap.offer(new int[]{nei, dU + wUV, stops + 1});
                    }
                    currentStops[nei] = stops;
                }
            }
        }

        return distances[dst] == Integer.MAX_VALUE? -1 : distances[dst];
    }

    public int findCheapestPrice_BFS(int n, int[][] flights, int src, int dst, int maxStops) {

        // Build the adjacency matrix
        int[][] adjMatrix = new int[n][n];
        for (int[] flight: flights) {
            adjMatrix[flight[0]][flight[1]] = flight[2];
        }

        // Shortest distances dictionary
        Map<Pair<Integer, Integer>, Long> distances = new HashMap<>();
        distances.put(new Pair<>(src, 0), 0L);

        // Number of stops done
        int stops = 0;

        // Final answer
        long ans = Long.MAX_VALUE;

        // BFS Queue
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);

        // Iterate until we exhaust maxStops+1 levels or the queue gets empty
        while (!queue.isEmpty() && stops < maxStops + 1) {

            // Iterate on current level
            int length = queue.size();
            for (int i = 0; i < length; ++i) {

                // Loop over neighbors of popped node
                int node = queue.poll();
                for (int nei = 0; nei < n; nei++) {

                    if (adjMatrix[node][nei] > 0) {

                        long dU = distances.getOrDefault(new Pair<>(node, stops), Long.MAX_VALUE);
                        long dV = distances.getOrDefault(new Pair<>(nei, stops + 1), Long.MAX_VALUE);
                        long wUV = adjMatrix[node][nei];

                        // No need to update the minimum cost if we have already exhausted our maxStops stops.
                        if (stops == maxStops && nei != dst) {
                            continue;
                        }

                        if (dU + wUV < dV) {
                            distances.put(new Pair<>(nei, stops + 1), dU + wUV);
                            queue.add(nei);

                            // If the neighbor is infact the destination, update the answer accordingly
                            if (nei == dst) {
                                ans = Math.min(ans, dU + wUV);
                            }
                        }
                    }
                }
            }

            stops++;
        }

        return ans == Long.MAX_VALUE ? -1 : (int) ans;
    }

    @Test
    public void test() {
        Assert.assertEquals(200, findCheapestPrice(3, new int[][]{{0,1,100}, {1,2,100}, {0,2,500}}, 0, 2, 1));
    }

    @Test
    public void test2() {
        Assert.assertEquals(500, findCheapestPrice(3, new int[][]{{0,1,100}, {1,2,100}, {0,2,500}}, 0, 2, 0));
    }

    @Test
    public void test3() {
        Assert.assertEquals(200, findCheapestPrice_BFS(3, new int[][]{{0,1,100}, {1,2,100}, {0,2,500}}, 0, 2, 1));
    }

    @Test
    public void test4() {
        Assert.assertEquals(500, findCheapestPrice_BFS(3, new int[][]{{0,1,100}, {1,2,100}, {0,2,500}}, 0, 2, 0));
    }
}
