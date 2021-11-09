package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;


//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BestTimeBuyAndSellStock {
    public int maxProfit2(int[] prices) {

        int profit = 0;
        int minValue = Integer.MAX_VALUE;
        int minIndex = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        int maxIndex = Integer.MIN_VALUE;

        for(int i = 0; i < prices.length; i++) {
            if(prices[i] > maxValue) {
                maxValue = prices[i];
                maxIndex = i;
            }
            if(prices[i] < minValue) {
                minValue = prices[i];
                minIndex = i;
            }

            if(minIndex < maxIndex) {
                int currentProfit =  maxValue - minValue;
                profit = Math.max(profit, currentProfit);
            } else {
                maxValue = minValue;
                maxIndex = minIndex;
            }
        }

        return profit;
    }

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                int currentProfit = price - minPrice;
                maxProfit = Math.max(maxProfit, currentProfit);
            }
        }

        return maxProfit;
    }

    @Test
    public void test() {
        Assert.assertEquals(2, maxProfit(new int[] { 2, 4, 1 }));
        Assert.assertEquals(2, maxProfit2(new int[] { 2, 4, 1 }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(5, maxProfit(new int[] { 7,1,5,3,6,4 }));
        Assert.assertEquals(5, maxProfit2(new int[] { 7,1,5,3,6,4 }));
    }

    @Test
    public void test3() {
        Assert.assertEquals(0, maxProfit(new int[] { 7,6,4,3,1 }));
        Assert.assertEquals(0, maxProfit2(new int[] { 7,6,4,3,1 }));
    }
}
