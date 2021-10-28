package leetcode.easy.binarysearch;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/peak-index-in-a-mountain-array/
public class PeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }

    @Test
    public void test() {
        Assert.assertEquals(1, peakIndexInMountainArray(new int[] { 3, 5, 3, 2, 0 }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(5, peakIndexInMountainArray(new int[] { 18, 29, 38, 59, 98, 100, 99, 98, 90 }));
    }
}
