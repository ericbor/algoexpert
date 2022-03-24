package leetcode.medium.matrix;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/count-servers-that-communicate/
public class CountServersThatCommunicate {

    public int countServers(int[][] grid) {
        int[] rows = new int[grid.length];
        int[] cols = new int[grid[0].length];

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    rows[row]++;
                    cols[col]++;
                }
            }
        }

        int count = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1 && (rows[row] > 1 || cols[col] > 1)) {
                    count++;
                }
            }
        }

        return count;
    }

    @Test
    public void test() {
        Assert.assertEquals(3, countServers(new int[][] { { 1, 0, 0, 1, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0 } }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(3, countServers(new int[][] { { 1, 0 }, { 1, 1 } }));
    }

    @Test
    public void test4() {
        Assert.assertEquals(0, countServers(new int[][] { { 1, 0 }, { 0, 1 } }));
    }

    @Test
    public void test3() {
        Assert.assertEquals(4, countServers(new int[][] { { 1, 1, 0, 0 }, { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 1 } }));
    }
}
