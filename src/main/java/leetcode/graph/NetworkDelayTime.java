package leetcode.graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/network-delay-time/
public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int i = 1; i <= n; i++ ) {
            graph.put(i, new ArrayList<>());
        }
        for(int[] t: times) {
            int from = t[0];
            int to = t[1];
            int time = t[2];

            graph.get(from).add(new int[]{to, time});
        }

        Queue<int[]> queue = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        queue.add(new int[]{k, 0});

        boolean[] visited = new boolean[n + 1];
        int totalTime = 0;
        int nodesVisited = 0;

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currNode = curr[0];
            int currTime = curr[1];

            if(visited[currNode]) {
                continue;
            }

            visited[currNode] = true;
            totalTime = currTime;
            nodesVisited++;

            for(int[] neighbor: graph.get(currNode)) {
                queue.add(new int[]{neighbor[0], totalTime + neighbor[1]});
            }
        }

        return n == nodesVisited ? totalTime : -1;
    }

    @Test
    public void test() {
        Assert.assertEquals(3, networkDelayTime(new int[][]{{1,2,1}, {2,3, 2}, {1,3,4}},3, 1));
    }

    @Test
    public void test2() {
        Assert.assertEquals(2, networkDelayTime(new int[][]{{2,1,1}, {2,3,1}, {3,4,1}},4, 2));
    }

    @Test
    public void test3() {
        Assert.assertEquals(1, networkDelayTime(new int[][]{{1,2,1}},2, 1));
    }

    @Test
    public void test4() {
        Assert.assertEquals(-1, networkDelayTime(new int[][]{{1,2,1}},2, 2));
    }

    @Test
    public void test5() {
        Assert.assertEquals(3, networkDelayTime(new int[][]{{1,2,1}, {2,1,3}},2, 2));
    }

    @Test
    public void test6() {
        Assert.assertEquals(2, networkDelayTime(new int[][]{{1,2,1}, {2,3, 2}, {1,3,2}},3, 1));
    }
}
