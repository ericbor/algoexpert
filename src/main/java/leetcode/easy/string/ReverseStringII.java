package leetcode.easy.string;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/reverse-string-ii/
public class ReverseStringII {

    private void reverse(char[] arr, int from, int to) {
        int start = from;
        int end = to;

        while (end >= arr.length) {
            end--;
        }

        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        for (int start = 0; start < arr.length; start += 2 * k) {

            int from = start;
            int to = Math.min(start + k - 1, arr.length - 1);

            reverse(arr, from, to);
        }
        return new String(arr);
    }

    @Test
    public void test() {
        Assert.assertEquals("bacdfeg", reverseStr("abcdefg", 2));
    }

    @Test
    public void test2() {
        Assert.assertEquals("bacd", reverseStr("abcd", 2));
    }

    @Test
    public void test3() {
        Assert.assertEquals("bacdfegh", reverseStr("abcdefgh", 2));
    }

    @Test
    public void test4() {
        Assert.assertEquals("bacdfeghji", reverseStr("abcdefghij", 2));
    }

    @Test
    public void test5() {
        Assert.assertEquals("cbadefihgj", reverseStr("abcdefghij", 3));
    }

    @Test
    public void test6() {
        Assert.assertEquals("a", reverseStr("a", 2));
    }

    @Test
    public void test7() {
        Assert.assertEquals("cbadefg", reverseStr("abcdefg", 3));
    }

    @Test
    public void test8() {
        Assert.assertEquals("cbadefeg", reverseStr("abcdefge", 3));
    }

    @Test
    public void test9() {
        Assert.assertEquals("gfedcba", reverseStr("abcdefg", 8));
    }
}
