package leetcode.tricks;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/replace-all-digits-with-characters/
public class ReplaceDigitsWithCharacters {
    public String replaceDigits(String s) {
        char[] arr = s.toCharArray();
        for(int i = 1; i < arr.length; i += 2) {
            int shift = (int) arr[i] - (int) '0';
            int asci = arr[i - 1];
            char c = (char) (asci + shift);

            arr[i] = c;
        }

        return String.valueOf(arr);
    }

    @Test
    public void test() {
        Assert.assertEquals("abbdcfdhe", replaceDigits("a1b2c3d4e"));
    }
}
