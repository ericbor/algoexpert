package educative.binsearch.medium;

import org.junit.Assert;
import org.junit.Test;

/*
Input: [1, 3, 8, 4, 3], key=4
Output: 3

Input: [3, 8, 3, 1], key=8
Output: 1

Input: [1, 3, 8, 12], key=12
Output: 3

Input: [10, 9, 8], key=10
Output: 0
 */
public class SearchBitonicArray {
    public static int search(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (key == arr[mid]) {
                return mid;
            }

            if (arr[mid] < arr[mid + 1]) {
                if (key > arr[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (key > arr[mid]) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }
        }

        return -1;
    }

    @Test
    public void main() {
        Assert.assertEquals(3, search(new int[] { 1, 3, 8, 4, 3 }, 4));
    }

    @Test
    public void main2() {
        Assert.assertEquals(1, search(new int[] { 3, 8, 3, 1 }, 8));
    }

    @Test
    public void main3() {
        Assert.assertEquals(3, search(new int[] { 1, 3, 8, 12 }, 12));
    }

    @Test
    public void main4() {
        Assert.assertEquals(0, search(new int[] { 10, 9, 8 }, 10));
    }
}
