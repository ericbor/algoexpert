package leetcode.graph;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/maximal-network-rank/
public class MaximalNetworkRank {
    public int maximalNetworkRank(int n, int[][] roads) {
        boolean[][] roadExists = new boolean[n][n];
        int [] indegree = new int[n];

        for(int[] road: roads) {
            int city1 = road[0];
            int city2 = road[1];

            //mark road exist, between two cities
            roadExists[city1][city2] = true;
            roadExists[city2][city1] = true;

            //increment the count of numbers of connected city
            indegree[city1]++;
            indegree[city2]++;
        }

        int maxRank = 0;
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                int rank = indegree[i] + indegree[j];

                if(roadExists[i][j]) {
                    rank--;
                }

                maxRank = Math.max(maxRank, rank);
            }
        }

        return maxRank;
    }

    @Test
    public void test() {
        Assert.assertEquals(4, maximalNetworkRank(4, new int[][]{{0,1}, {0,3}, {1,2}, {1,3}}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(5, maximalNetworkRank(5, new int[][]{{0,1}, {0,3}, {1,2}, {1,3}, {2,3}, {2,4}}));
    }

    @Test
    public void test3() {
        Assert.assertEquals(5, maximalNetworkRank(8, new int[][]{{0,1}, {1,2}, {2,3}, {2,4}, {5,6}, {5,7}}));
    }
}
