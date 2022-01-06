package leetcode.graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//https://leetcode.com/problems/number-of-operations-to-make-network-connected/
public class NumberOfOperationsToMakeNetworkConnected {
    private final Map<Integer, List<Integer>> graph = new HashMap<>();

    public int makeConnected(int n, int[][] connections) {
        //For N nodes N-1 edges are required for complete connection.
        if (connections.length < n - 1) {
            return -1;
        }

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] connection : connections) {
            int pc1 = connection[0];
            int pc2 = connection[1];
            graph.get(pc1).add(pc2);
            graph.get(pc2).add(pc1);
        }

        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, visited);
                count++;
            }
        }

        // Minimum number of edges required to connect C components
        return count - 1;
    }

    private void bfs(int i, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);

        while (!queue.isEmpty()) {
            int node = queue.remove();
            if (visited[node]) {
                continue;
            }

            visited[node] = true;
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                }
            }
        }
    }

    @Test
    public void test() {
        Assert.assertEquals(2, makeConnected(6, new int[][] { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 2 }, { 1, 3 } }));
    }

    @Test
    public void test3() {
        Assert.assertEquals(1, makeConnected(4, new int[][] { { 0, 1 }, { 0, 2 }, { 1, 2 } }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(-1, makeConnected(6, new int[][] { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 2 } }));
    }
}
