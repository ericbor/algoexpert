package array.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    //Time: O(numRows^2), Space: O(numRows^2)
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        //First base case: if user requests zero rows, they get zero rows
        if (numRows == 0) {
            return triangle;
        }

        //Second base case: first row is always 1
        triangle.add(List.of(1));

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum - 1);

            //The first row element is always 1
            row.add(1);

            //Each triangle element (other than the first and the last of each row)
            //is equal to the sum of the elements above-and-to-the-left and
            //above-and-to-the-right
            for (int i = 1; i < rowNum; i++) {
                int aboveAndToLeft = prevRow.get(i - 1);
                int aboveAndToRight = prevRow.get(i);
                int sum = aboveAndToLeft + aboveAndToRight;
                row.add(sum);
            }

            //The last row element is always 1
            row.add(1);

            triangle.add(row);
        }

        return triangle;
    }

    @Test
    public void verify() {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(List.of(1));
        triangle.add(List.of(1, 1));
        triangle.add(List.of(1, 2, 1));
        triangle.add(List.of(1, 3, 3, 1));
        triangle.add(List.of(1, 4, 6, 4, 1));
        Assert.assertEquals(triangle, generate(5));
    }
}
