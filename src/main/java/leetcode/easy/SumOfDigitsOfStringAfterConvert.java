package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/sum-of-digits-of-string-after-convert/
public class SumOfDigitsOfStringAfterConvert {
    public int getLucky(String s, int k) {

        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()) {
            int num = (int)c - (int)'a' + 1;
            sb.append(num);
        }

        String result = sb.toString();
        while(k > 0) {

            result = sumDigits(result);

            k--;
        }

        return Integer.parseInt(result);
    }

    private String sumDigits(String sb) {
        char first = sb.charAt(0);
        int sum = (int)first - (int)'0';

        for(int i = 1; i < sb.length(); i++) {
            char next = sb.charAt(i);
            int nextDigit = (int)next - (int)'0';
            sum += nextDigit;
        }

        return String.valueOf(sum);
    }

    @Test
    public void test() {
        Assert.assertEquals(6, getLucky("leetcode", 2));
    }
}
