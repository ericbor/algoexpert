package array.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/find-the-town-judge/
public class FindTownJudge {
    public int findJudge(int N, int[][] trust) {
        if (trust.length < N - 1) {
            return -1;
        }

        int[] indegrees = new int[N + 1];
        int[] outdegrees = new int[N + 1];

        for (int[] relation : trust) {
            outdegrees[relation[0]]++;
            indegrees[relation[1]]++;
        }

        for (int i = 1; i < N; i++) {
            if (indegrees[i] == N - 1 && outdegrees[i] == 0) {
                return i;
            }
        }

        return -1;
    }

    @Test
    public void verify() {
        Assert.assertEquals(3, findJudge(4, new int[][] { { 1, 3 }, { 1, 4 }, { 2, 3 }, { 2, 4 }, { 4, 3 } }));
    }
}
