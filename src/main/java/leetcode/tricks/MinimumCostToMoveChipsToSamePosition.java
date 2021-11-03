package leetcode.tricks;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/
public class MinimumCostToMoveChipsToSamePosition {
    public int minCostToMoveChips(int[] position) {
        int evenCount = 0;
        int oddCount = 0;

        for (int i : position) {
            if (i % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        return Math.min(evenCount, oddCount);
    }

    @Test
    public void test() {
        Assert.assertEquals(1, minCostToMoveChips(new int[] { 1, 2, 3 }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(2, minCostToMoveChips(new int[] { 2, 2, 2, 3, 3 }));
    }

    @Test
    public void test3() {
        Assert.assertEquals(1, minCostToMoveChips(new int[] { 1, 1000000000 }));
    }
}
