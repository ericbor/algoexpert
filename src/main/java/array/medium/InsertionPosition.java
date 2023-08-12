package array.medium;

import org.junit.Assert;
import org.junit.Test;

public class InsertionPosition {
    public void insert(int[] arr, int val) {
        int position = -1;
        for (int i = 0; i < arr.length; i++) {
            if (val < arr[i]) {
                position = i;
                break;
            }
        }

        if (position == -1) {
            arr[arr.length - 1] = val;
        } else {
            for (int j = position; j < arr.length; j++) {
                int tmp = arr[j];
                arr[j] = val;
                val = tmp;
            }
        }
    }

    private void swap(int[] arr, int val, int poistion) {
        arr[poistion] = val;
    }

    @Test
    public void test2() {
        int[] arr = {7, 9, 10, 11, 12};
        insert(arr, 8);
        Assert.assertArrayEquals(new int[]{7, 8, 9, 10, 11}, arr);
    }

    @Test
    public void test() {
        int[] arr = {1, 5, 7, 9, 10};
        insert(arr, 8);
        Assert.assertArrayEquals(new int[]{1, 5, 7, 8, 9}, arr);
    }

    @Test
    public void test3() {
        int[] arr = {1, 2, 3, 4, 5};
        insert(arr, 100);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 100}, arr);
    }

    @Test
    public void test4() {
        int[] arr = {1, 3, 3, 5, 6};
        insert(arr, 2);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 3, 5}, arr);
    }

    @Test
    public void test5() {
        int[] arr = {3, 3, 3, 5, 6};
        insert(arr, 2);
        Assert.assertArrayEquals(new int[]{2, 3, 3, 3, 5}, arr);
    }
}
