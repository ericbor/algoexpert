package educative.twopointers.easy;

import org.junit.Assert;
import org.junit.Test;

//https://www.educative.io/courses/grokking-the-coding-interview/mEEA22L5mNA
public class RemoveDuplicates {
    public static int remove(int[] arr) {
        int nextNonDuplicate = 1; // index of the next non-duplicate element
        for (int i = 1; i < arr.length; i++) {
            int previousNum = arr[nextNonDuplicate - 1];
            int currentNum = arr[i];

            if (previousNum != currentNum) {
                //swap
                arr[nextNonDuplicate] = arr[i];
                nextNonDuplicate++;
            }
        }

        return nextNonDuplicate;
    }

    @Test
    public void verify() {
        Assert.assertEquals(4, remove(new int[] { 2, 3, 3, 3, 6, 9, 9 }));//output -> {2,3,6,9, ... }
        Assert.assertEquals(2, remove(new int[] { 2, 2, 2, 11 }));//output -> {2,11, ...}
    }
}
