package array.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SmallestDifference {
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        int pointerOne = 0;
        int pointerTwo = 0;
        int[] result = new int[2];
        int smallest = Integer.MAX_VALUE;
        int current;

        while (pointerOne < arrayOne.length && pointerTwo < arrayTwo.length) {
            int numOne = arrayOne[pointerOne];
            int numTwo = arrayTwo[pointerTwo];

            if (numOne < numTwo) {
                current = numTwo - numOne;
                pointerOne++;
            } else if (numTwo < numOne) {
                current = numOne - numTwo;
                pointerTwo++;
            } else {
                return new int[] { numOne, numTwo };
            }

            if (current < smallest) {
                smallest = current;
                result[0] = numOne;
                result[1] = numTwo;
            }
        }

        return result;
    }

    @Test
    public void verify() {
        int[] arrayOne = {-1, 5, 10, 20, 28, 3};
        int[] arrayTwo = {26, 134, 135, 15, 17};
        int[] expecetd = {28, 26};
        Assert.assertArrayEquals(expecetd, smallestDifference(arrayOne, arrayTwo));
    }
}
