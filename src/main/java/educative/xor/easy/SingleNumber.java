package educative.xor.easy;

import org.junit.Assert;
import org.junit.Test;

/*
n a non-empty array of integers, every number appears twice except for one, find that single number.

Input: 1, 4, 2, 1, 3, 2, 3
Output: 4

Input: 7, 9, 7
Output: 9
 */
public class SingleNumber {
    public static int findSingleNumber(int[] arr) {
        int result = 0;
        for (int num : arr) {
            result = result ^ num;
        }
        return result;
    }

    @Test
    public void main() {
        Assert.assertEquals(4, findSingleNumber(new int[] { 1, 4, 2, 1, 3, 2, 3 }));
    }

    @Test
    public void main2() {
        Assert.assertEquals(9, findSingleNumber(new int[] { 7, 9, 7 }));
    }
}
