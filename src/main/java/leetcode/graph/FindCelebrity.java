package leetcode.graph;

//https://leetcode.com/problems/find-the-celebrity/
public class FindCelebrity {
    public int findCelebrity(int n) {
        int[] indegree = new int[n];
        int[] outdegree = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && knows(i, j)) {
                    outdegree[i]++;
                    indegree[j]++;
                }
            }
        }

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == n - 1 && outdegree[i] == 0) {
                return i;
            }
        }

        return -1;
    }

    private boolean knows(int i, int j) {
        return false;//implementation is in LeetCode
    }
}
