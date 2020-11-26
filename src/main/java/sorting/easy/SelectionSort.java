package sorting.easy;

import org.junit.Assert;
import org.junit.Test;

public class SelectionSort {
    public static int[] selectionSort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            int smallestIndex = i;
            for (int k = i + 1; k < array.length; k++) {
                if (array[k] < array[smallestIndex]) {
                    smallestIndex = k;
                }
            }

            swap(i, smallestIndex, array);
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
        Assert.assertArrayEquals(new int[] { 2, 3, 5, 5, 6, 8, 9 }, selectionSort(new int[] { 8, 5, 2, 9, 5, 6, 3 }));
    }
}
