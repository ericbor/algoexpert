package leetcode.graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/number-of-provinces/
public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];

        int provinceCount = 0;
        for(int i = 0; i < isConnected.length; i++) {
            if(!visited[i]) {
                bfs(i, visited, isConnected);
                provinceCount++;
            }
        }

        return provinceCount;
    }

    private void bfs(int i, boolean[] visited, int[][] isConnected) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);

        while(!queue.isEmpty()) {
            int curr = queue.poll();

            if(!visited[curr]) {
                visited[curr] = true;

                for(int j = 0; j < isConnected[curr].length; j++) {
                    if(curr != j && isConnected[curr][j] > 0) {
                        queue.add(j);
                    }
                }
            }
        }
    }

    @Test
    public void test() {
        Assert.assertEquals(3, findCircleNum(new int[][]{{1,0,0}, {0,1,0}, {0,0,1}}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(2, findCircleNum(new int[][]{{1,1,0}, {1,1,0}, {0,0,1}}));
    }
}
