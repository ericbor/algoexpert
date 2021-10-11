package educative.binsearch.medium;

import org.junit.Assert;
import org.junit.Test;

/*
Input: [10, 15, 1, 3, 8], key = 15
Output: 1

Input: [4, 5, 7, 9, 10, -1, 2], key = 10
Output: 4
 */
public class SearchRotatedArray {
    public static int search(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (key == arr[mid]) {
                return mid;
            }

            if (arr[start] <= arr[mid]) { // left side is sorted in ascending order
                if (key >= arr[start] && key < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else { // right side is sorted in ascending order
                if (key > arr[mid] && key < arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    @Test
    public void main() {
        Assert.assertEquals(1, search(new int[] { 10, 15, 1, 3, 8 }, 15));
    }

    @Test
    public void main2() {
        Assert.assertEquals(4, search(new int[] { 4, 5, 7, 9, 10, -1, 2 }, 10));
    }
}
