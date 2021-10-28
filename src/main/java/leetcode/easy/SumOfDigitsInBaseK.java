package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/sum-of-digits-in-base-k/
public class SumOfDigitsInBaseK {
    public int sumBase(int n, int k) {

        int toBase = n;

        if(k != 10) {
            //toBase = n;
            StringBuilder sb = new StringBuilder();

            while(n > 0) {
                int reminder = n % k;
                sb.append(reminder);
                n /= k;
            }

            toBase = Integer.parseInt(sb.toString());
        }

        int sum = 0;
        while(toBase > 0) {
            int reminder = toBase % 10;
            sum += reminder;
            toBase /= 10;
        }

        return sum;
    }

    @Test
    public void test() {
        Assert.assertEquals(12, sumBase(48,7));
    }

    @Test
    public void test2() {
        Assert.assertEquals(9, sumBase(34,6));
    }

    @Test
    public void test3() {
        Assert.assertEquals(1, sumBase(10,10));
    }
}
