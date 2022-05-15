package string.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/add-strings
public class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();

        int carry = 0;
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;

        while (p1 >= 0 || p2 >= 0) {
            int x1 = p1 >= 0 ? (int) num1.charAt(p1) - (int) '0' : 0;
            int x2 = p2 >= 0 ? (int) num2.charAt(p2) - (int) '0' : 0;

            int value = x1 + x2 + carry;
            int reminder = value % 10;
            sb.append(reminder);

            carry = value / 10;
            p1--;
            p2--;
        }

        if (carry != 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }

    @Test
    public void verify() {
        Assert.assertEquals("130", addStrings("1", "129"));
    }

    @Test
    public void verify2() {
        Assert.assertEquals("450", addStrings("124", "326"));
    }

    @Test
    public void verify3() {
        Assert.assertEquals("1021", addStrings("22", "999"));
    }
}
