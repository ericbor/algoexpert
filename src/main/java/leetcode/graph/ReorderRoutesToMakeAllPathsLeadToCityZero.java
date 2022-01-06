package leetcode.graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/
public class ReorderRoutesToMakeAllPathsLeadToCityZero {
    private final Map<Integer, List<Integer>> incoming = new HashMap<>();
    private final Map<Integer, List<Integer>> outgoing = new HashMap<>();
    private final Set<Integer> visited = new HashSet<>();
    int ans;

    public int minReorder(int n, int[][] connections) {
        ans = 0;

        for (int i = 0; i < n; i++) {
            incoming.put(i, new ArrayList<>());
            outgoing.put(i, new ArrayList<>());
        }

        for (int[] edge : connections) {
            incoming.get(edge[1]).add(edge[0]);
            outgoing.get(edge[0]).add(edge[1]);
        }

        dfs(0);
        return ans;
    }

    private void dfs(int v) {
        visited.add(v);
        for (int i : outgoing.get(v)) {
            if (!visited.contains(i)) {
                ans++;
                dfs(i);
            }
        }

        for (int i : incoming.get(v)) {
            if (!visited.contains(i)) {
                dfs(i);
            }
        }
    }

    @Test
    public void test() {
        Assert.assertEquals(3, minReorder(6, new int[][] { { 0, 1 }, { 1, 3 }, { 2, 3 }, { 4, 0 }, { 4, 5 } }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(2, minReorder(5, new int[][] { { 1, 0 }, { 1, 2 }, { 3, 2 }, { 3, 4 } }));
    }

    @Test
    public void test3() {
        Assert.assertEquals(0, minReorder(3, new int[][] { { 1, 0 }, { 2, 0 } }));
    }
}
