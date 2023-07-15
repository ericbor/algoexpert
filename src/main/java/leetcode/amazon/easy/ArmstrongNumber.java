package leetcode.amazon.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/armstrong-number/
public class ArmstrongNumber {
    public boolean isArmstrong(int n) {
        if (n < 10) {
            return true;
        }

        int power = String.valueOf(n).toCharArray().length;

        int num = n;
        int sum = 0;
        while (num > 0) {
            int reminder = num % 10;

            sum += (int) Math.pow(reminder, power);

            //sum += reminder * reminder * reminder;
            num /= 10;
        }

        return sum == n;
    }

    @Test
    public void test() {
        Assert.assertTrue(isArmstrong(1634));
        Assert.assertTrue(isArmstrong(2));
        Assert.assertTrue(isArmstrong(153));
        Assert.assertFalse(isArmstrong(123));
    }
}
