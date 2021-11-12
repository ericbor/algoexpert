package leetcode.tricks;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/
public class MinimumValueInStepByStepSum {
    public int minStartValue(int[] nums) {
        int min = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            min = Math.min(min, sum);
        }

        //min + x = 1;
        //x = 1 - min
        int startValue = 1 - min;

        return startValue;
    }

    @Test
    public void test() {
        Assert.assertEquals(129, minStartValue(new int[] { -22, -29, -21, 0, -4, -26, 10, -11, -14, -11 }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(5, minStartValue(new int[] { -3, 2, -3, 4, 2 }));
    }

    @Test
    public void test3() {
        Assert.assertEquals(1, minStartValue(new int[] { 1, 2 }));
    }

    @Test
    public void test4() {
        Assert.assertEquals(5, minStartValue(new int[] { 1, -2, -3 }));
    }

    @Test
    public void test5() {
        Assert.assertEquals(1, minStartValue(new int[] { 2, 3, 5, -5, -1 }));
    }

    @Test
    public void test6() {
        Assert.assertEquals(1882, minStartValue(new int[] { -30, 88, 59, -11, -90, -95, -4, 9, 17, -43, 98, -78, 8, -75, -99, -78, -82, -42, 43, 72, 82, -98, 16, -12, -62, -27, -80, -49, -85, 48, -59, 12, -85, 15, -48, -60, 38, 71, -56, 53, -29, 51, -40, 33, -95, -50, -5, -41, -20, 55, -29, -21, -2, -98, 26, 59, 65, -40, 24, -2, -47, 90, -86, -90, -62, 75, -80, -87, -15, 5, -96, -27, -9, -55, 37, -44, -49, -85, -77, 28, -34, -80, -19, -98, -26, -72, 64 }));
    }
}
