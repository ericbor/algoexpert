package leetcode.tricks;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/add-digits/
public class AddDigits {
    public int addDigits(int num) {
        int digitalRoot = 0;
        while (num > 0) {
            digitalRoot += num % 10;
            num /= 10;

            if(num == 0 && digitalRoot > 9) {
                num = digitalRoot;
                digitalRoot = 0;
            }
        }

        return digitalRoot;
    }

    public int addDigits2(int num) {
        if (num == 0) {
            return 0;
        }
        if (num % 9 == 0) {
            return 9;
        }

        return num % 9;
    }

    @Test
    public void test() {
        Assert.assertEquals(2, addDigits(38));
        Assert.assertEquals(2, addDigits2(38));
    }

    @Test
    public void test2() {
        Assert.assertEquals(0, addDigits(0));
    }
}
