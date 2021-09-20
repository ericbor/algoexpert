package educative.twopointers.easy;

import org.junit.Assert;
import org.junit.Test;

////https://www.educative.io/courses/grokking-the-coding-interview/mEEA22L5mNA
public class RemoveElement {
    public static int remove(int[] arr, int key) {
        int nextElement = 0; // index of the next element which is not 'key'
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != key) {
                arr[nextElement] = arr[i];
                nextElement++;
            }
        }

        return nextElement;
    }

    @Test
    public void verify() {
        Assert.assertEquals(4, remove(new int[] { 3, 2, 3, 6, 3, 10, 9, 3 }, 3));//output -> {2,6,10,9, ... }
        Assert.assertEquals(2, remove(new int[] { 2, 11, 2, 2, 1 }, 2));//output -> {11, 1 ...}
    }
}
