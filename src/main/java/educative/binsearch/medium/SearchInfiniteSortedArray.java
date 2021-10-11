package educative.binsearch.medium;

import org.junit.Assert;
import org.junit.Test;

/*
Given an infinite sorted array (or an array with unknown size), find if a given number ‘key’ is present in the array.
Write a function to return the index of the ‘key’ if it is present in the array, otherwise return -1.

Since it is not possible to define an array with infinite (unknown) size,
you will be provided with an interface ArrayReader to read elements of the array.
ArrayReader.get(index) will return the number at index; if the array’s size is smaller than the index, it will return Integer.MAX_VALUE.

Input: [4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30], key = 16
Output: 6

Input: [4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30], key = 11
Output: -1

 */
public class SearchInfiniteSortedArray {
    public static int search(ArrayReader reader, int key) {
        int start = 0;
        int end = 1;

        while (key > reader.get(end)) {
            int newStart = end + 1;
            end += (end - start + 1) * 2;
            start = newStart;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (key > reader.get(mid)) {
                start = mid + 1;
            } else if (key < reader.get(mid)) {
                end = mid - 1;
            } else { //key == reader.get(mid)
                return mid;
            }
        }
        return -1;
    }

    @Test
    public void main() {
        ArrayReader reader = new ArrayReader(new int[] { 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30 });
        Assert.assertEquals(6, search(reader, 16));

        ArrayReader reader2 = new ArrayReader(new int[] { 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30 });
        Assert.assertEquals(-1, search(reader2, 11));

        ArrayReader reader3 = new ArrayReader(new int[] { 1, 3, 8, 10, 15 });
        Assert.assertEquals(4, search(reader3, 15));

        ArrayReader reader4 = new ArrayReader(new int[] { 1, 3, 8, 10, 15 });
        Assert.assertEquals(-1, search(reader4, 200));
    }
}

class ArrayReader {
    int[] arr;

    ArrayReader(int[] arr) {
        this.arr = arr;
    }

    public int get(int index) {
        if (index >= arr.length) {
            return Integer.MAX_VALUE;
        }
        return arr[index];
    }
}
