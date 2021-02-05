package other.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class ArmstrongNumber {
    public boolean isArmstrong(int N) {
        List<Integer> stack = new LinkedList<>();
        int nCopy = N;

        while (nCopy > 0) {
            stack.add(nCopy % 10);
            nCopy /= 10;
        }

        int power = stack.size();
        int result = 0;
        for (int num : stack) {
            result += (int) Math.pow(num, power);
        }

        return N == result;
    }

    public boolean isArmstrong2(int n) {
        int power = String.valueOf(n).length();

        return n == getSumOfKthPowerOfDigits(n, power);

    }

    private int getSumOfKthPowerOfDigits(int number, int power) {
        int result = 0;
        while(number !=0) {
            int lastDigit = number % 10;
            result += (int) Math.pow(lastDigit, power);

            number /= 10;
        }

        return result;
    }

    @Test
    public void verify() {
        Assert.assertTrue( isArmstrong(153));
        Assert.assertFalse( isArmstrong(123));
        Assert.assertTrue( isArmstrong2(153));
        Assert.assertFalse( isArmstrong2(123));
    }
}
