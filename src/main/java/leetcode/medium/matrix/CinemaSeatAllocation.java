package leetcode.medium.matrix;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/cinema-seat-allocation/
public class CinemaSeatAllocation {

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, List<Integer>> rowToSeatRes = new HashMap<>();

        for (int[] row : reservedSeats) {
            if (!rowToSeatRes.containsKey(row[0])) {
                rowToSeatRes.put(row[0], new ArrayList<>());
            }
            rowToSeatRes.get(row[0]).add(row[1]);
        }

        int result = (n - rowToSeatRes.size()) * 2;         // These rows do not contain any reservations

        for (List<Integer> row : rowToSeatRes.values()) { // Check possible family seating in each row
            boolean flag = false;

            // Check first possibility
            if (checkLeftAisle(row)) {
                result++;
                flag = true;
            }

            // Check second possibility
            if (checkRightAisle(row)) {
                result++;
                flag = true;
            }

            // Check middle seats only if first two are not used
            if (!flag && checkCentral(row)) {
                result++;
            }
        }

        return result;
    }

    private boolean checkLeftAisle(List<Integer> row) {
        for (int col = 2; col <= 5; col++) {
            if (row.contains(col)) {
                return false;
            }
        }

        return true;
    }

    private boolean checkRightAisle(List<Integer> row) {
        for (int col = 6; col <= 9; col++) {
            if (row.contains(col)) {
                return false;
            }
        }

        return true;
    }

    private boolean checkCentral(List<Integer> row) {
        for (int col = 4; col <= 7; col++) {
            if (row.contains(col)) {
                return false;
            }
        }

        return true;
    }

    @Test
    public void test() {
        Assert.assertEquals(4, maxNumberOfFamilies(3, new int[][] { { 1, 2 }, { 1, 3 }, { 1, 8 }, { 2, 6 }, { 3, 1 }, { 3, 10 } }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(2, maxNumberOfFamilies(2, new int[][] { { 2, 1 }, { 1, 8 }, { 2, 6 } }));
    }

    @Test
    public void test3() {
        Assert.assertEquals(4, maxNumberOfFamilies(4, new int[][] { { 4, 3 }, { 1, 4 }, { 4, 6 }, { 1, 7 } }));
    }
}
