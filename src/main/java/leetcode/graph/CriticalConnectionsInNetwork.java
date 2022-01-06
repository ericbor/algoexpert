package leetcode.graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/critical-connections-in-a-network/
public class CriticalConnectionsInNetwork {
    int[] discoveryTime;
    int [] low;
    int time = 1;
    private final List<List<Integer>> bridges = new ArrayList<>();
    private final Map<Integer,List<Integer>> edgeMap = new HashMap<>();

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        discoveryTime = new int[n];
        low = new int[n];

        for (int i = 0; i < n; i++) {
            edgeMap.put(i, new ArrayList<>());
        }
        for (List<Integer> conn : connections) {
            edgeMap.get(conn.get(0)).add(conn.get(1));
            edgeMap.get(conn.get(1)).add(conn.get(0));
        }

        dfs(0, -1);
        return bridges;
    }
    public void dfs(int curr, int prev) {
        discoveryTime[curr] = time;
        low[curr] = time;
        time++;

        for (int next : edgeMap.get(curr)) {
            if (discoveryTime[next] == 0) {
                dfs(next, curr);
                low[curr] = Math.min(low[curr], low[next]);
            } else if (next != prev) {
                low[curr] = Math.min(low[curr], discoveryTime[next]);
            }
            if (low[next] > discoveryTime[curr]) {
                bridges.add(Arrays.asList(curr, next));
            }
        }
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
