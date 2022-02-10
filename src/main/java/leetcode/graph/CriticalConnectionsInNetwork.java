package leetcode.graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/critical-connections-in-a-network/
public class CriticalConnectionsInNetwork {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        Map<Integer, List<Integer>> graph = new HashMap<>(n);

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (List<Integer> connection : connections) {
            graph.get(connection.get(0)).add(connection.get(1));
            graph.get(connection.get(1)).add(connection.get(0));
        }

        Set<List<Integer>> connectionsSet = new HashSet<>(connections);
        int[] rank = new int[n];
        Arrays.fill(rank, -2);
        dfs(graph, 0, 0, rank, connectionsSet);
        return new ArrayList<>(connectionsSet);
    }

    int dfs(Map<Integer, List<Integer>> graph, int node, int depth, int[] rank, Set<List<Integer>> connectionsSet) {
        if (rank[node] >= 0) {
            return rank[node]; // already visited node. return its rank
        }
        rank[node] = depth;
        int minDepthFound = depth; // can be Integer.MAX_VALUE also.
        for (Integer neighbor : graph.get(node)) {
            if (rank[neighbor] == depth - 1) { // ignore parent
                continue;
            }
            int minDepth = dfs(graph, neighbor, depth + 1, rank, connectionsSet);
            minDepthFound = Math.min(minDepthFound, minDepth);
            if (minDepth <= depth) {
                // to avoid the sorting just try to remove both combinations. of (x,y) and (y,x)
                connectionsSet.remove(Arrays.asList(node, neighbor));
                connectionsSet.remove(Arrays.asList(neighbor, node));
            }
        }
        return minDepthFound;
    }

    @Test
    public void test() {
        Assert.assertEquals(List.of(List.of(1, 3)), criticalConnections(4, List.of(List.of(0, 1), List.of(1, 2), List.of(2, 0), List.of(1, 3))));
    }

    @Test
    public void test2() {
        Assert.assertEquals(List.of(List.of(0, 1)), criticalConnections(2, List.of(List.of(0, 1))));
    }
}
