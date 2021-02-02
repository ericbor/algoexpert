package array.easy;

import org.junit.Assert;
import org.junit.Test;

public class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int wealth = Integer.MIN_VALUE;

        for (int[] account : accounts) {
            int result = 0;
            for (int i : account) {
                result += i;
            }

            if (result > wealth) {
                wealth = result;
            }
        }

        return wealth;
    }

    @Test
    public void verify() {
        int[][] arr = { { 2, 8, 7 }, { 7, 1, 3 }, { 1, 9, 5 } };
        Assert.assertEquals(17, maximumWealth(arr));
    }
}
