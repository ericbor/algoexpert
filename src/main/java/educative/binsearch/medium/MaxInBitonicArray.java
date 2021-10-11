package educative.binsearch.medium;

import org.junit.Assert;
import org.junit.Test;

/*
Find the maximum value in a given Bitonic array. An array is considered bitonic if it is monotonically increasing and then monotonically decreasing.
Monotonically increasing or decreasing means that for any index i in the array arr[i] != arr[i+1].

Input: [1, 3, 8, 12, 4, 2] ... Output: 12
Input: [3, 8, 3, 1] ... Output: 8
Input: [1, 3, 8, 12] ... Output: 12
Input: [10, 9, 8] ... Output: 10
 */
public class MaxInBitonicArray {
    public static int findMax(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end){
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        // at the end of the while loop, 'start == end'
        return arr[start];
    }

    @Test
    public void main() {
        Assert.assertEquals(12, findMax(new int[] { 1, 3, 8, 12, 4, 2 }));
    }

    @Test
    public void main2() {
        Assert.assertEquals(8, findMax(new int[] { 3, 8, 3, 1 }));
    }

    @Test
    public void main3() {
        Assert.assertEquals(12, findMax(new int[] { 1, 3, 8, 12 }));
    }

    @Test
    public void main4() {
        Assert.assertEquals(10, findMax(new int[] { 10, 9, 8 }));
    }
}
