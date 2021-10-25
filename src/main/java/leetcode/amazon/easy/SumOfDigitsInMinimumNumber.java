package leetcode.amazon.easy;

import org.junit.Assert;
import org.junit.Test;

public class SumOfDigitsInMinimumNumber {
    public int sumOfDigits(int[] nums) {
        int minimum = 101;
        for (int num : nums) {
            minimum = Math.min(minimum, num);
        }

        int sum = 0;
        while (minimum > 0) {
            int reminder = minimum % 10;
            sum += reminder;
            minimum /= 10;
        }

        if (sum % 2 == 0) {
            return 1;
        }

        return 0;

    }

    @Test
    public void test() {
        Assert.assertEquals(0, sumOfDigits(new int[] { 34, 23, 1, 24, 75, 33, 54, 8 }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(1, sumOfDigits(new int[] { 99, 77, 33, 66, 55 }));
    }
}
