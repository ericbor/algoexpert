package leetcode.graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//https://leetcode.com/problems/course-schedule-ii/
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] p : prerequisites) {
            graph.put(p[1], new ArrayList<>());
        }

        int[] outdegree = new int[numCourses];
        // Create the adjacency list representation of the graph
        for (int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]);

            // Record in-degree of each vertex
            outdegree[p[0]]++;
        }

        // Add all vertices with 0 in-degree to the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (outdegree[i] == 0) {
                queue.add(i);
            }
        }

        int i = 0;
        // Process until the Q becomes empty
        int[] topologicalOrder = new int[numCourses];
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topologicalOrder[i] = node;
            i++;

            // Reduce the in-degree of each neighbor by 1
            if (graph.containsKey(node)) {
                for (int course : graph.get(node)) {
                    outdegree[course]--;

                    // If in-degree of a course becomes 0, add it to the Q
                    if (outdegree[course] == 0) {
                        queue.add(course);
                    }
                }
            }
        }

        // Check to see if topological sort is possible or not.
        if (i == numCourses) {
            return topologicalOrder;
        }

        return new int[0];
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[] { 2, 4, 3, 1, 0 }, findOrder(5, new int[][] { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 1, 4 }, { 3, 4 } }));
    }

    @Test
    public void test4() {
        Assert.assertArrayEquals(new int[] { 0, 1, 2, 3 }, findOrder(4, new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } }));
    }

    @Test
    public void test2() {
        Assert.assertArrayEquals(new int[] { 0, 1 }, findOrder(2, new int[][] { { 1, 0 } }));
    }

    @Test
    public void test3() {
        Assert.assertArrayEquals(new int[] { 0 }, findOrder(1, new int[][] {}));
    }

    @Test
    public void test5() {
        Assert.assertArrayEquals(new int[] {}, findOrder(2, new int[][] {{1,0}, {0,1}}));
    }
}
