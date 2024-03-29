package educative.twopointers.medium;

import org.junit.Assert;
import org.junit.Test;

/*
Minimum Window Sort (medium)#
Given an array, find the length of the smallest subarray in it which when sorted will sort the whole array.

Input: [1, 2, 5, 3, 7, 10, 9, 12] ... Output: 5
Explanation: We need to sort only the subarray [5, 3, 7, 10, 9] to make the whole array sorted

Input: [1, 3, 2, 0, -1, 7, 10] ... Output: 5
Explanation: We need to sort only the subarray [1, 3, 2, 0, -1] to make the whole array sorted

Input: [1, 2, 3] ... Output: 0
Explanation: The array is already sorted

Input: [3, 2, 1] ... Output: 3
Explanation: The whole array needs to be sorted.
 */
public class ShortestWindowSort {
    public static int sort(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        // find the first number out of sorting order from the beginning
        while(low < arr.length - 1 && arr[low] <= arr[low + 1]) {
            low++;
        }
        // if the array is sorted
        if(low == arr.length - 1) {
            return 0;
        }
        // find the first number out of sorting order from the end
        while(high > 0 && arr[high] >= arr[high - 1]) {
            high--;
        }

        // find the maximum and minimum of the subarray
        int subarrayMax = Integer.MIN_VALUE;
        int subarrayMin = Integer.MAX_VALUE;
        for(int k = low; k < high; k++) {
            subarrayMax = Math.max(subarrayMax, arr[k]);
            subarrayMin = Math.min(subarrayMin, arr[k]);
        }

        // extend the subarray to include any number which is bigger than the minimum of the subarray
        while (low > 0 && arr[low - 1] > subarrayMin) {
            low--;
        }
        // extend the subarray to include any number which is smaller than the maximum of the subarray
        while(high < arr.length - 1 && arr[high + 1] < subarrayMax) {
            high++;
        }

        return high - low + 1;
    }


    @Test
    public void verify() {
        Assert.assertEquals(5, sort(new int[] { 1, 2, 5, 3, 7, 10, 9, 12 }));
        Assert.assertEquals(5, sort(new int[] { 1, 3, 2, 0, -1, 7, 10 }));
        Assert.assertEquals(0, sort(new int[] { 1, 2, 3 }));
        Assert.assertEquals(3, sort(new int[] { 3, 2, 1 }));
    }
}
