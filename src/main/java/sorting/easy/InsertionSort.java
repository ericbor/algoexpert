package sorting.easy;

import org.junit.Assert;
import org.junit.Test;

public class InsertionSort {
    public static int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i;
            while (j > 0 && array[j] < array[j - 1]) {
                swap(j, j - 1, array);
                j--;
            }
        }
        return array;
    }

    private static void swap(int i, int k, int[] array) {
        int tmp = array[i];
        array[i] = array[k];
        array[k] = tmp;
    }

    @Test
    public void verify() {
        Assert.assertArrayEquals(new int[] { 2, 3, 5, 5, 6, 8, 9 }, insertionSort(new int[] { 8, 5, 2, 9, 5, 6, 3 }));
    }
}
