package array.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
public class ReplaceElementswithGreatestElementonRightSide {

    //Time: O(n), Space: O(1)
    public int[] replaceElements2(int[] arr) {
        int maxValue = -1;

        for (int i = arr.length - 1; i >= 0; i--) {
            int tmp = arr[i];
            arr[i] = maxValue;

            maxValue = Math.max(maxValue, tmp);
        }

        return arr;
    }

    @Test
    public void verify() {
        Assert.assertArrayEquals(new int[] { -1 }, replaceElements2(new int[] { 400 }));
    }

    @Test
    public void verify2() {
        Assert.assertArrayEquals(new int[] { 18, 6, 6, 6, 1, -1 }, replaceElements2(new int[] { 17, 18, 5, 4, 6, 1 }));
    }
}
