package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/add-strings/
public class AddStrings {
    public String addStrings2(String num1, String num2) {
        if(num1.length() > num2.length()) {
            return add(num1.toCharArray(), num2.toCharArray());
        }

        return add(num2.toCharArray(), num1.toCharArray());
    }

    private String add(char[] arr1, char[] arr2) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        int lengthDiff = arr1.length - arr2.length;
        for(int i = arr2.length - 1; i >= 0; i--) {
            int digit1 = (int)arr1[i + lengthDiff] - (int)'0';
            int digit2 = (int)arr2[i] - (int)'0';

            int sum = digit1 + digit2 + carry;
            if(sum > 9) {
                sum %= 10;
                carry = 1;
            } else {
                carry = 0;
            }

            sb.insert(0, sum);
        }

        if(arr1.length > arr2.length) {
            int index = arr1.length - arr2.length - 1;
            for(int i = index; i >= 0; i--) {
                int digit = (int)arr1[i] - (int)'0';
                int sum = digit + carry;
                if(sum > 9) {
                    sum %= 10;
                    carry = 1;
                } else {
                    carry = 0;
                }

                sb.insert(0, sum);
            }
        }

        if(carry != 0) {
            sb.insert(0, carry);
        }

        return sb.toString();
    }

    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();

        int carry = 0;
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        while (p1 >= 0 || p2 >= 0) {
            int x1 = p1 >= 0 ? num1.charAt(p1) - '0' : 0;
            int x2 = p2 >= 0 ? num2.charAt(p2) - '0' : 0;
            int value = (x1 + x2 + carry) % 10;
            carry = (x1 + x2 + carry) / 10;
            res.append(value);
            p1--;
            p2--;
        }

        if (carry != 0)
            res.append(carry);

        return res.reverse().toString();
    }

    @Test
    public void test() {
        Assert.assertEquals("533", addStrings("456", "77"));
    }

    @Test
    public void test2() {
        Assert.assertEquals("0", addStrings("0", "0"));
    }

    @Test
    public void test3() {
        Assert.assertEquals("134", addStrings("11", "123"));
    }
}
