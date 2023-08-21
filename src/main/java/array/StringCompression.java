package array;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/string-compression/
public class StringCompression {
    public int compress(char[] chars) {
        int ans = 0; // keep track of current position in compressed array
        int i = 0;

        // iterate through input array using i pointer
        while (i < chars.length) {
            char letter = chars[i]; // current character being compressed
            int count = 0; // count of consecutive occurrences of letter

            // count consecutive occurrences of letter in input array
            while (i < chars.length && chars[i] == letter) {
                ++count;
                ++i;
            }

            // write letter to compressed array
            chars[ans] = letter;
            ans++;

            if (count > 1) {
                for ( char c : String.valueOf(count).toCharArray()) {
                    chars[ans] = c;
                    ans++;
                }
            }
        }

        return ans;
    }

    @Test
    public void test2() {
        char[] arr = {'a'};
        Assert.assertEquals(1, compress(arr));
        Assert.assertArrayEquals(new char[]{'a'}, arr);
    }

    @Test
    public void test() {
        char[] arr = {'a','a','b','b','c','c','c'};
        Assert.assertEquals(6, compress(arr));
        Assert.assertArrayEquals(new char[]{'a','2','b','2','c','3', 'c'}, arr);
    }

}
