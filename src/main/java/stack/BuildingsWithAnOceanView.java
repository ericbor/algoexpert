package stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/buildings-with-an-ocean-view/
public class BuildingsWithAnOceanView {
    public int[] findBuildings(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.add(heights.length - 1);

        for (int i = heights.length - 2; i >= 0; i--) {
            if (heights[i] > heights[stack.peek()]) {
                stack.push(i);
            }
        }

        int size = stack.size();
        int[] results = new int[size];
        for (int i = 0; i < size; i++) {
            results[i] = stack.pop();
        }

        return results;
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[] { 0, 2, 3 }, findBuildings(new int[] { 4, 2, 3, 1 }));
    }
}
