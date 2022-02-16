package dp;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/pascals-triangle/
public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        // Base case; first row is always [1].
        triangle.add(List.of(1));

        for (int i = 1; i < numRows; i++) {
            List<Integer> prev = triangle.get(i - 1);
            List<Integer> curr = new ArrayList<>();

            // The first row element is always 1.
            curr.add(1);

            // Each triangle element (other than the first and last)
            // is equal to the sum of the elements above-and-to-the-left and above-and-to-the-right.
            for (int k = 1; k < i; k++) {
                int prev1 = prev.get(k - 1);
                int prev2 = prev.get(k);
                curr.add(prev1 + prev2);
            }

            // The last row element is always 1.
            curr.add(1);

            triangle.add(curr);
        }

        return triangle;
    }

    @Test
    public void test() {
        Assert.assertEquals(List.of(List.of(1), List.of(1, 1), List.of(1, 2, 1), List.of(1, 3, 3, 1), List.of(1, 4, 6, 4, 1)), generate(5));
    }
}
