package leetcode.easy.binarysearch;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

//https://leetcode.com/problems/find-the-distance-value-between-two-arrays
public class DistanceValueBetweenTwoArrays {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int results = 0;

        for (int num : arr1) {
            int close = findClosest(arr2, num);

            if (Math.abs(num - close) > d) {
                results++;
            }
        }

        return results;
    }

    int findClosest(int[] arr, int target) {
        int d = Integer.MAX_VALUE;

        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return arr[mid];
            }

            if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

            int firstDiff = Math.abs(target - arr[mid]);
            int secondDiff = Math.abs(target - d);
            if (firstDiff < secondDiff) {
                d = arr[mid];
            }
        }

        return d;
    }

    @Test
    public void test() {
        Assert.assertEquals(2, findTheDistanceValue(new int[] { 4, 5, 8 }, new int[] { 10, 9, 1, 8 }, 2));
    }

    @Test
    public void test2() {
        Assert.assertEquals(2, findTheDistanceValue(new int[] { 1, 4, 2, 3 }, new int[] { -4, -3, 6, 10, 20, 30 }, 3));
    }

    @Test
    public void test3() {
        Assert.assertEquals(1, findTheDistanceValue(new int[] { 2, 1, 100, 3 }, new int[] { -5, -2, 10, -3, 7 }, 6));
    }
}
