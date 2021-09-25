package educative.fastslowpointers.hard;

import org.junit.Assert;
import org.junit.Test;

/*
Suppose the array contains a number ‘M’ at a particular index.
-if ‘M’ is positive - move forward ‘M’ indices
-if ‘M’ is negative - move backwards ‘M’ indices.

The array is circular which means two things:
- If, while moving forward, we reach the end of the array, we will jump to the first element to continue the movement.
- If, while moving backward, we reach the beginning of the array, we will jump to the last element to continue the movement.
- The cycle should have more than one element
- should follow one direction which means the cycle should not contain both forward and backward movements.

Input: [1, 2, -1, 2, 2] ... Output: true
Explanation: The array has a cycle among indices: 0 -> 1 -> 3 -> 0

Input: [2, 1, -1, -2] ... Output: false
Explanation: The array does not have any cycle.
 */
public class CircularArrayLoop {
    public static boolean loopExists(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean isForward = arr[i] >= 0;
            int slow = i;
            int fast = i;

            // if slow or fast becomes '-1' this means we can't find cycle for this number
            do {
                slow = findNextIndex(arr, isForward, slow);// move one step for slow pointer
                fast = findNextIndex(arr, isForward, fast);// move one step for fast pointer
                if (fast != -1) {
                    fast = findNextIndex(arr, isForward, fast); // move another step for fast pointer
                }
            } while (slow != -1 && fast != -1 && slow != fast);

            if (slow != -1 && slow == fast) {
                return true;
            }
        }
        return false;
    }

    private static int findNextIndex(int[] arr, boolean isForward, int currentIndex) {
        boolean direction = arr[currentIndex] >= 0;
        if (isForward != direction) {
            return -1; // change in direction, return -1
        }

        int nextIndex = (currentIndex + arr[currentIndex]) % arr.length;
        if (nextIndex < 0) {
            nextIndex += arr.length; // wrap around for negative numbers
        }

        // one element cycle, return -1
        if (nextIndex == currentIndex) {
            nextIndex = -1;
        }

        return nextIndex;
    }

    @Test
    public void verify() {
        Assert.assertTrue(loopExists(new int[] { 1, 2, -1, 2, 2 }));
        Assert.assertTrue(loopExists(new int[] { 2, 2, -1, 2 }));
        Assert.assertFalse(loopExists(new int[] { 2, 1, -1, -2 }));
    }

}
