package string;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/reverse-words-in-a-string-ii/
public class ReverseWordsInStringII {
    public void reverseWords(char[] s) {
        // reverse the whole string
        reverse(s, 0, s.length - 1);

        // reverse each word
        reverseEachWord(s);
    }

    private void reverse(char[] s, int left, int right) {
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;

            left++;
            right--;
        }
    }

    private void reverseEachWord(char[] s) {
        int start = 0;
        int end = 0;

        while (start < s.length) {
            // go to the end of the word
            while (end < s.length && s[end] != ' ') {
                ++end;
            }
            // reverse the word
            reverse(s, start, end - 1);
            // move to the next word
            start = end + 1;
            ++end;
        }
    }

    @Test
    public void test() {
        char[] arr = { 't', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e' };
        reverseWords(arr);

        Assert.assertArrayEquals(new char[] { 'b', 'l', 'u', 'e', ' ', 'i', 's', ' ', 's', 'k', 'y', ' ', 't', 'h', 'e' }, arr);
    }
}
