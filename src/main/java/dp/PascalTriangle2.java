package dp;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/pascals-triangle/
public class PascalTriangle2 {

    public List<Integer> getRow(int rowIndex) {

        LinkedList<List<Integer>> rows = new LinkedList<>();
        rows.add(List.of(1));

        for (int i = 0; i < rowIndex; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);

            List<Integer> prevRow = rows.getLast();
            for (int k = 0; k < prevRow.size() - 1; k++) {
                int val = prevRow.get(k) + prevRow.get(k + 1);
                row.add(val);
            }

            row.add(1);

            rows.add(row);
        }

        return rows.getLast();
    }

    public List<Integer> getRow2(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);

        for (int i = 0; i < rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
            row.add(1);
        }

        return row;
    }

    @Test
    public void test() {
        Assert.assertEquals(List.of(1, 3, 3, 1), getRow(3));
        Assert.assertEquals(List.of(1, 3, 3, 1), getRow2(3));
    }
}
