package matrix;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/shortest-distance-from-all-buildings/
public class ShortestDistanceFromAllBuildings {

    public int shortestDistance(int[][] grid) {

        int totalHouses = 0;
        for (int row = 0; row < grid.length; ++row) {
            for (int col = 0; col < grid[0].length; ++col) {
                if (grid[row][col] == 1) {
                    totalHouses++;
                }
            }
        }

        // Find the min distance sum for each empty cell.
        int minDistance = Integer.MAX_VALUE;
        for (int row = 0; row < grid.length; ++row) {
            for (int col = 0; col < grid[0].length; ++col) {
                if (grid[row][col] == 0) {
                    minDistance = Math.min(minDistance, bfs(grid, row, col, totalHouses));
                }
            }
        }

        // If it is impossible to reach all houses from any empty cell, then return -1.
        if (minDistance == Integer.MAX_VALUE) {
            return -1;
        }

        return minDistance;
    }

    private int bfs(int[][] grid, int row, int col, int totalHouses) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { row, col });

        // Keep track of visited cells.
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[row][col] = true;

        int steps = 0;
        int distanceSum = 0;
        int housesReached = 0;
        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!queue.isEmpty() && housesReached != totalHouses) {
            for (int i = queue.size(); i > 0; --i) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];

                // If this cell is a house, then add the distance from source to this cell and we go past from this cell.
                if (grid[r][c] == 1) {
                    distanceSum += steps;
                    housesReached++;
                    continue;
                }

                for (int[] dir : directions) {
                    int nextRow = r + dir[0];
                    int nextCol = c + dir[1];
                    if (nextRow >= 0 && nextCol >= 0 && nextRow < grid.length && nextCol < grid[0].length) {
                        if (!visited[nextRow][nextCol] && grid[nextRow][nextCol] != 2) {
                            visited[nextRow][nextCol] = true;
                            queue.add(new int[] { nextRow, nextCol });
                        }
                    }
                }
            }

            steps++;
        }

        // If we did not reach all houses, then any cell visited also cannot reach all houses.
        // Set all cells visted to 2 so we do not check them again and return MAX_VALUE.
        if (housesReached != totalHouses) {
            for (row = 0; row < grid.length; row++) {
                for (col = 0; col < grid[0].length; col++) {
                    if (grid[row][col] == 0 && visited[row][col]) {
                        grid[row][col] = 2;
                    }
                }
            }
            return Integer.MAX_VALUE;
        }

        // If we have reached all houses then return the total distance calculated.
        return distanceSum;
    }

    @Test
    public void test() {
        Assert.assertEquals(7, shortestDistance(new int[][] { { 1, 0, 2, 0, 1 }, { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0 } }));
    }
}
