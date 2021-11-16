package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/reverse-only-letters/
public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String s) {

        char[] arr = s.toCharArray();
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            if (Character.isLetter(arr[start]) && Character.isLetter(arr[end])) {
                swap(arr, start, end);
                start++;
                end--;
            } else if (!Character.isLetter(arr[start])) {
                start++;
            } else if (!Character.isLetter(arr[end])){
                end--;
            }
        }

        return String.valueOf(arr);
    }

    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    @Test
    public void test() {
        Assert.assertEquals("j-Ih-gfE-dCba", reverseOnlyLetters("a-bC-dEf-ghIj"));
    }
}
