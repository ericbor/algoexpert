package educative.binsearch.medium;

import org.junit.Assert;
import org.junit.Test;

public class RotationCountOfRotatedArray {
    public static int countRotations(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            // if mid is greater than the next element
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid + 1;
            }
            // if mid is smaller than the previous element
            if (mid > start && arr[mid - 1] > arr[mid]) {
                return mid;
            }

            if (arr[start] < arr[mid]) {// left side is sorted, so the pivot is on right side
                start = mid + 1;
            } else {// right side is sorted, so the pivot is on the left side
                end = mid - 1;
            }
        }
        return 0;// the array has not been rotated
    }

    @Test
    public void main() {
        Assert.assertEquals(2, countRotations(new int[] { 10, 15, 1, 3, 8 }));
    }

    @Test
    public void main2() {
        Assert.assertEquals(5, countRotations(new int[] { 4, 5, 7, 9, 10, -1, 2 }));
    }

    @Test
    public void main3() {
        Assert.assertEquals(0, countRotations(new int[] { 1, 3, 8, 10 }));
    }
}
