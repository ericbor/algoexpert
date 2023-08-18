package array;

import org.junit.Assert;
import org.junit.Test;

public class SwapArray {
    public static void swap(char[] arr, int offset) {
        int n = arr.length;

        reverse(arr, 0, offset - 1); // Reverse the first part of the array
        reverse(arr, offset, n - 1); // Reverse the second part of the array
        reverse(arr, 0, n - 1); // Reverse the whole array
    }

    public static void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    @Test
    public void test() {
        char[] arr = {'a', 'b', 'c', '1', '2', '3', '4'};
        swap(arr, 3);
        Assert.assertArrayEquals(new char[]{'1', '2', '3', '4', 'a', 'b', 'c'}, arr);
    }

}
