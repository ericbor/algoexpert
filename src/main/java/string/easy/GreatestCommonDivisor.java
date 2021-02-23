package string.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/greatest-common-divisor-of-strings
public class GreatestCommonDivisor {
    public String gcdOfStrings(String str1, String str2) {
        if (str2.isEmpty()) {
            return "";
        }

        if (str1.length() < str2.length()) {
            return gcdOfStrings(str2, str1);
        }

        if (str1.startsWith(str2)) {
            String reminder = str1.substring(str2.length());
            if (reminder.isEmpty()) {
                return str2;
            }
            return gcdOfStrings(str2, reminder);
        } else {
            String subs1 = str1.substring(0, str1.length() - 1);
            String subs2 = str2.substring(0, str2.length() - 1);

            return gcdOfStrings(subs1, subs2);
        }
    }

    @Test
    public void verify() {
        //Assert.assertEquals("ABC", gcdOfStrings("ABCABC", "ABC"));
        Assert.assertEquals("AB", gcdOfStrings("ABABAB", "ABAB"));
    }
}
