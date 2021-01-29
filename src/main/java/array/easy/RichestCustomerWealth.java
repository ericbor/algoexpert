package array.easy;

import org.junit.Assert;
import org.junit.Test;

public class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int wealth = Integer.MIN_VALUE;

        int result = 0;
        for (int i = 0; i < accounts.length; i++) {
            for (int k = 0; k < accounts[i].length; k++) {
                result += accounts[i][k];
                if (k == accounts[i].length - 1) {
                    if (result > wealth) {
                        wealth = result;
                    }
                    result = 0;
                }
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
