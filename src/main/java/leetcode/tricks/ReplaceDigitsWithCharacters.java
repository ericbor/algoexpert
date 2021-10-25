package leetcode.tricks;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/replace-all-digits-with-characters/
public class ReplaceDigitsWithCharacters {
    public String replaceDigits(String s) {
        char[] arr = s.toCharArray();
        for (int i = 1; i < arr.length; i += 2) {
            int shift = (int) arr[i] - (int) '0';
            int asci = arr[i - 1];
            char c = (char) (asci + shift);

            arr[i] = c;
        }

        return String.valueOf(arr);
    }

    public char[] digitToLetter(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int num = (int) arr[i] - (int) '0';
            int asci = (int) 'a' - 1;
            char result = (char) (num + asci);

            arr[i] = result;
        }

        return arr;
    }

    @Test
    public void test() {
        Assert.assertEquals("abbdcfdhe", replaceDigits("a1b2c3d4e"));
    }

    @Test
    public void test2() {
        Assert.assertArrayEquals(new char[] { 'a', 'b', 'c' }, digitToLetter(new char[] { '1', '2', '3' }));
    }
}
