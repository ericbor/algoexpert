package leetcode.graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/find-if-path-exists-in-graph
public class FindIfPathExistsInGraph {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        boolean[] visited = new boolean[n];
        visited[start] = true;

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            if (currentVertex == end) {
                return true;
            }

            for (int[] edge : edges) {
                if (edge[0] == currentVertex && !visited[edge[1]]) {
                    visited[edge[1]] = true;
                    queue.add(edge[1]);
                } else if (edge[1] == currentVertex && !visited[edge[0]]) {
                    visited[edge[0]] = true;
                    queue.add(edge[0]);
                }
            }
        }

        return false;
    }

    @Test
    public void test() {
        Assert.assertTrue(validPath(3, new int[][] { { 0, 1 }, { 1, 2 }, { 2, 0 } }, 0, 2));
    }

    @Test
    public void test2() {
        Assert.assertFalse(validPath(6, new int[][] { { 0, 1 }, { 0, 2 }, { 3, 5 }, { 5, 4 }, { 4, 3 } }, 0, 5));
    }
}
