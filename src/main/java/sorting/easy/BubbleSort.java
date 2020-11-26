package sorting.easy;

import org.junit.Assert;
import org.junit.Test;

public class BubbleSort {
    public static int[] bubbleSort(int[] array) {
        boolean isSorted = false;
        int counter = 0;

        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1 - counter; i++) {
                if (array[i] > array[i + 1]) {
                    swap(i, i + 1, array);
                    isSorted = false;
                }
            }
            counter++;
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
        Assert.assertArrayEquals(new int[] { 2, 3, 5, 5, 6, 8, 9 }, bubbleSort(new int[] { 8, 5, 2, 9, 5, 6, 3 }));
    }
}
