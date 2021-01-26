package array.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/solution/
public class BuySellStock2 {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }

    @Test
    public void verify() {
        Assert.assertEquals(5, maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
    }
}
