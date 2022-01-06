package leetcode.graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        int[] indegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {

            List<Integer> courseList = map.getOrDefault(prerequisite[0], new ArrayList<>());
            courseList.add(prerequisite[1]);
            map.put(prerequisite[0], courseList);

            indegree[prerequisite[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        int count = numCourses;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (map.containsKey(current)) {
                List<Integer> coursePrerequisites = map.get(current);
                for (int i : coursePrerequisites) {
                    indegree[i]--;
                    if (indegree[i] == 0) {
                        queue.add(i);
                    }
                }
            }

            count--;
        }

        return count == 0;
    }

    @Test
    public void test() {
        Assert.assertTrue(canFinish(5, new int[][] { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 1, 4 }, { 3, 4 } }));
    }

    @Test
    public void test3() {
        Assert.assertTrue(canFinish(2, new int[][] { { 1, 0 } }));
    }

    @Test
    public void test2() {
        Assert.assertFalse(canFinish(2, new int[][] { { 1, 0 }, { 0, 1 } }));
    }

}
