package leetcode.medium.array;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/container-with-most-water/
public class ContainerWithMostWater {
    public int maxArea2(int[] height) {
        int maxArea = Integer.MIN_VALUE;

        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int currLevel = Math.min(height[i], height[j]);
                int currMaxArea = currLevel * (j - i);
                maxArea = Math.max(maxArea, currMaxArea);
            }
        }

        return maxArea;
    }

    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int maxArea = Integer.MIN_VALUE;

        while (start < end) {
            int currLevel = Math.min(height[start], height[end]);
            int currMaxArea = currLevel * (end - start);

            maxArea = Math.max(maxArea, currMaxArea);
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }

        return maxArea;
    }

    @Test
    public void test() {
        Assert.assertEquals(49, maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(1, maxArea(new int[] { 1, 1 }));
    }

    @Test
    public void test3() {
        Assert.assertEquals(2, maxArea(new int[] { 1, 2, 1 }));
    }
}
