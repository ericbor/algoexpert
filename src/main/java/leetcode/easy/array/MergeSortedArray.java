package leetcode.easy.array;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/merge-sorted-array/
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;

        for (int i = m + n - 1; i >= 0; i--) {
            if(p2 < 0) {
                break;
            }

            if (p1 >= 0 &&  nums1[p1] >= nums2[p2]) {
                nums1[i] = nums1[p1];
                p1--;
            } else {
                nums1[i] = nums2[p2];
                p2--;
            }
        }
    }

    @Test
    public void test2() {
        int[] arr = { 2, 0 };
        merge(arr, 1, new int[] { 1 }, 1);
        Assert.assertArrayEquals(new int[] { 1, 2 }, arr);
    }

    @Test
    public void test3() {
        int[] arr = { 0 };
        merge(arr, 0, new int[] { 1 }, 1);
        Assert.assertArrayEquals(new int[] { 1 }, arr);
    }

    @Test
    public void test4() {
        int[] arr = { 1, 2, 3, 0, 0, 0 };
        merge(arr, 3, new int[] { 2, 5, 6 }, 3);
        Assert.assertArrayEquals(new int[] { 1, 2, 2, 3, 5, 6 }, arr);
    }
}
