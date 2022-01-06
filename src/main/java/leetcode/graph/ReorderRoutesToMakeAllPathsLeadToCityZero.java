package leetcode.graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

//https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/
public class ReorderRoutesToMakeAllPathsLeadToCityZero {
    public int minReorder(int n, int[][] connections) {
        Set<String> edgeDirection = new HashSet<>();
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] connection : connections) {
            int source = connection[0];
            int destination = connection[1];
            //storing the direction as "source,destination"
            String edge = source + "," + destination;
            edgeDirection.add(edge);
            graph.computeIfAbsent(source, k -> new HashSet<>());
            graph.computeIfAbsent(destination, k -> new HashSet<>());
            graph.get(source).add(destination);
            graph.get(destination).add(source);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        boolean[] visited = new boolean[n];
        visited[0] = true;

        int count = 0;
        while (!queue.isEmpty()) {
            int connection = queue.poll();

            for (int neighbor : graph.get(connection)) {

                if (visited[neighbor]) {
                    continue;
                }
                //else set visited to true.
                visited[neighbor] = true;
                //e.g. If neighbor does not point to 0 direction
                if (!edgeDirection.contains(neighbor + "," + connection)) {
                    count++;
                }
                queue.add(neighbor);
            }
        }

        return count;
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
