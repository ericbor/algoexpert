package leetcode.easy.matrix;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/flipping-an-image/
public class FlippingImage {
    public int[][] flipAndInvertImage(int[][] image) {
        for (int[] row : image) {
            int start = 0;
            int end = row.length - 1;
            while (start < end) {
                if (row[start] != row[end]) {
                    swap(row, start, end);
                }
                start++;
                end--;
            }

            for (int j = 0; j < row.length; j++) {
                row[j] ^= 1;
            }
        }

        return image;
    }

    public int[][] flipAndInvertImage2(int[][] image) {
        for (int[] row : image) {
            int start = 0;
            int end = row.length - 1;
            while (start <= end) {
                if (row[start] == row[end]) {
                    row[start] ^= 1;
                    row[end] = row[start];
                }
                start++;
                end--;
            }
        }

        return image;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    @Test
    public void test() {
        int[][] image = { { 1, 1, 0 }, { 1, 0, 1 }, { 0, 0, 0 } };
        int[][] expected = { { 1, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
        Assert.assertArrayEquals(expected, flipAndInvertImage(image));
    }

    @Test
    public void test2() {
        int[][] image = { { 1, 1, 0 }, { 1, 0, 1 }, { 0, 0, 0 } };
        int[][] expected = { { 1, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
        Assert.assertArrayEquals(expected, flipAndInvertImage2(image));
    }

    @Test
    public void test3() {
        int[][] image = { { 1, 1, 0, 0 }, { 1, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 0, 1, 0 } };
        int[][] expected = { { 1, 1, 0, 0 }, { 0, 1, 1, 0 }, { 0, 0, 0, 1 }, { 1, 0, 1, 0 } };
        Assert.assertArrayEquals(expected, flipAndInvertImage(image));
    }

    @Test
    public void test4() {
        int[][] image = { { 1, 1, 0, 0 }, { 1, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 0, 1, 0 } };
        int[][] expected = { { 1, 1, 0, 0 }, { 0, 1, 1, 0 }, { 0, 0, 0, 1 }, { 1, 0, 1, 0 } };
        Assert.assertArrayEquals(expected, flipAndInvertImage2(image));
    }
}
