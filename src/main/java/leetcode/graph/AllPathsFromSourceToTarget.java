package leetcode.graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/all-paths-from-source-to-target
public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<Integer> list = new ArrayList<>();
        list.add(0);

        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(list);

        List<List<Integer>> results = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> currList = queue.poll();

            int v = currList.get(currList.size() - 1);
            if (v == graph.length - 1) {
                results.add(currList);
                continue;
            }

            for (int i : graph[v]) {
                List<Integer> temp = new ArrayList<>(currList);
                temp.add(i);
                queue.add(temp);
            }
        }

        return results;
    }

    @Test
    public void test() {
        Assert.assertEquals(List.of(List.of(0, 1, 3), List.of(0, 2, 3)), allPathsSourceTarget(new int[][] { { 1, 2 }, { 3 }, { 3 }, {} }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(List.of(List.of(0, 4), List.of(0, 3, 4), List.of(0, 1, 4), List.of(0, 1, 3, 4), List.of(0, 1, 2, 3, 4)), allPathsSourceTarget(new int[][] { { 4, 3, 1 }, { 3, 2, 4 }, { 3 }, { 4 }, {} }));
    }
}
