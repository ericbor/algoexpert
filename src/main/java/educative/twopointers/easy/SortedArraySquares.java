package educative.twopointers.easy;

import org.junit.Assert;
import org.junit.Test;

//https://www.educative.io/courses/grokking-the-coding-interview/R1ppNG3nV9R
public class SortedArraySquares {
    public static int[] makeSquares(int[] arr) {
        int[] squares = new int[arr.length];

        int left = 0;
        int right = arr.length - 1;
        int highestIndex = arr.length - 1;
        while( left <= right) {
            int leftSquare = arr[left] * arr[left];
            int rightSquare = arr[right] * arr[right];

            if(rightSquare > leftSquare) {
                squares[highestIndex] = rightSquare;
                right--;
            } else {
                squares[highestIndex] = leftSquare;
                left++;
            }
            highestIndex--;
        }

        return squares;
    }

    @Test
    public void verify() {
        Assert.assertArrayEquals(new int[] { 1, 1, 4, 4, 9 }, makeSquares(new int[] { -2, -1, 1, 2, 3 }));
        Assert.assertArrayEquals(new int[] { 0, 1, 1, 4, 9 }, makeSquares(new int[] { -3, -1, 0, 1, 2 }));
    }
}
