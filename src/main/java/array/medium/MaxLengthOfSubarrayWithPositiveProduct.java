package array.medium;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product/
public class MaxLengthOfSubarrayWithPositiveProduct {
    public int getMaxLen(int[] nums) {

        //hold currMin and currMax length
        int currMin = 0;
        int currMax = 0;
        //hold answer
        int globMax = 0;

        for (int num : nums) {
            //if current element is 0, restart curr max and min length
            if (num == 0) {
                currMax = 0;
                currMin = 0;
            } else {
                //if currMin length is zero. don't increment
                if (currMin > 0) {
                    currMin++;
                }
                currMax++;
                //if negative number found just reverse the currMin and currMax
                if (num < 0) {
                    int t = currMax;
                    currMax = currMin;
                    currMin = t;
                }
                //max of both currMax and globMax
                globMax = Math.max(globMax, currMax);
            }

        }
        return globMax;
    }

    @Test
    public void test() {
        Assert.assertEquals(4, getMaxLen(new int[] { 1, -2, -3, 4 }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(3, getMaxLen(new int[] { 0, 1, -2, -3, -4 }));
    }
}
