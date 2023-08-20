package other;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

//https://leetcode.com/problems/roman-to-integer/
public class RomanToInteger {
    private final Map<Character, Integer> map = Map.of('M', 1000, 'D', 500, 'C', 100, 'L', 50, 'X', 10, 'V', 5, 'I', 1);

    public int romanToInt(String s) {

        int result = 0;
        int prev = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int curr = map.get(s.charAt(i));

            if (curr < prev) {
                result -= curr;
            } else {
                result += curr;
            }
            prev = curr;
        }
        return result;
    }

    @Test
    public void test() {
        Assert.assertEquals(3, romanToInt("III"));
    }

    @Test
    public void test2() {
        //L = 50, V= 5, III = 3.
        Assert.assertEquals(58, romanToInt("LVIII"));
    }

    @Test
    public void test3() {
        //M = 1000, CM = 900, XC = 90 and IV = 4.
        Assert.assertEquals(1994, romanToInt("MCMXCIV"));
    }
}
