package array;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/median-of-two-sorted-arrays
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int index1 = 0;
        int index2 = 0;
        int med1 = 0;
        int med2 = 0;

        for (int i = 0; i <= (nums1.length + nums2.length) / 2; i++) {
            med1 = med2;
            if (index1 == nums1.length) {
                med2 = nums2[index2];
                index2++;
            } else if (index2 == nums2.length) {
                med2 = nums1[index1];
                index1++;
            } else if (nums1[index1] < nums2[index2]) {
                med2 = nums1[index1];
                index1++;
            } else {
                med2 = nums2[index2];
                index2++;
            }
        }

        // the median is the average of two numbers
        if ((nums1.length + nums2.length) % 2 == 0) {
            return (float) (med1 + med2) / 2;
        }

        return med2;
    }

    @Test
    public void test() {
        Assert.assertEquals(2.0, findMedianSortedArrays(new int[]{1, 3}, new int[]{2}), 2);
    }

    @Test
    public void test2() {
        Assert.assertEquals(2.5, findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}), 2);
    }
}
