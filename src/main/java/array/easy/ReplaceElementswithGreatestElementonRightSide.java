package array.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
public class ReplaceElementswithGreatestElementonRightSide {
    //Time: O(n), Space: O(n)
    public int[] replaceElements(int[] arr) {
        int maxValue = -1;
        int[] resuls = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            resuls[i] = maxValue;
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }

        return resuls;
    }

    //Time: O(n), Space: O(1)
    public int[] replaceElements2(int[] arr) {
        int maxValue = -1;

        for (int i = arr.length - 1; i >= 0; i--) {
            int tmp = arr[i];
            arr[i] = maxValue;
            if (tmp > maxValue) {
                maxValue = tmp;
            }
        }

        return arr;
    }

    @Test
    public void verify() {
        Assert.assertArrayEquals(new int[] { 18, 6, 6, 6, 1, -1 }, replaceElements(new int[] { 17, 18, 5, 4, 6, 1 }));
    }

    @Test
    public void verify2() {
        Assert.assertArrayEquals(new int[] { 18, 6, 6, 6, 1, -1 }, replaceElements2(new int[] { 17, 18, 5, 4, 6, 1 }));
    }
}
