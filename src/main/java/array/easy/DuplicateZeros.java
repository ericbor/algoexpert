package array.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/duplicate-zeros/
public class DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0) {
                for (int j = arr.length - 1; j > i; j--) {
                    arr[j] = arr[j - 1];
                }
                i += 1;
            }
        }

    }

    @Test
    public void verify() {
        int[] arr = { 1, 0, 2, 3, 0, 4, 5, 0 };
        duplicateZeros(arr);
        Assert.assertArrayEquals(new int[] { 1, 0, 0, 2, 3, 0, 0, 4 }, arr);

    }
}
