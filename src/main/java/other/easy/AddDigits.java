package other.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/add-digits/
public class AddDigits {
    public int addDigits(int num) {

        int result = 0;
        while(num > 0) {
            int reminder = num % 10;
            result += reminder;
            num /= 10;

            if(num == 0 && result > 9) {
                num = result;
                result = 0;
            }
        }

        return result;
    }

    public int addDigits2(int num) {
        if(num == 0) {
            return 0;
        }

        if(num % 9 == 0) {
            return 9;
        }

        return num % 9;
    }

    @Test
    public void verify() {
        //Assert.assertEquals(2, addDigits(38));
        Assert.assertEquals(2, addDigits2(38));
    }
}
