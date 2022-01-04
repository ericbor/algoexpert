package leetcode.graph;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/find-the-town-judge/
public class FindTownJudge {
    public int findJudge2(int n, int[][] trust) {
        if(trust.length < n - 1) {
            return -1;
        }

        int[] outdegrees = new int[n + 1];
        int[] indegrees = new int[n + 1];

        for (int[] relation : trust) {
            outdegrees[relation[0]]++;
            indegrees[relation[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (indegrees[i] == n - 1 && outdegrees[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    public int findJudge(int n, int[][] trust) {
        if (trust.length < n - 1) {
            return -1;
        }

        int[] trustScores = new int[n + 1];

        for (int[] relation : trust) {
            trustScores[relation[0]]--;
            trustScores[relation[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (trustScores[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        Assert.assertEquals(3, findJudge(4, new int[][] { { 1, 3 }, { 1, 4 }, { 2, 3 }, { 2, 4 }, { 4, 3 } }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(2, findJudge(2, new int[][] { { 1, 2 } }));
    }

    @Test
    public void test3() {
        Assert.assertEquals(3, findJudge(3, new int[][] { { 1, 3 }, { 2, 3 } }));
    }

    @Test
    public void test4() {
        Assert.assertEquals(-1, findJudge(3, new int[][] { { 1, 3 }, { 2, 3 }, { 3, 1 } }));
    }

    @Test
    public void test5() {
        Assert.assertEquals(-1, findJudge(3, new int[][] { { 1, 2 }, { 2, 3 } }));
    }
}
