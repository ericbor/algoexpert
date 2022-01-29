package leetcode.medium.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/asteroid-collision
public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int astr : asteroids) {
            if (astr > 0) {
                stack.push(astr);// Pushing all +ve asteroids
            } else {
                // Remove all positive asteroids before our current asteroid
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -astr) {
                    stack.pop();
                }

                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(astr);// Checking if the stack is empty or the recent asteriod is negative!
                } else if (stack.peek() == -astr) {
                    stack.pop(); // If recent asteriod <= our asteriod, We broke our outer loop if equal we pop it.
                }
            }
        }

        int[] output = new int[stack.size()];
        for (int i = output.length - 1; i >= 0; i--) {
            output[i] = stack.pop();
        }

        return output;
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[] { -2, -1, 1, 2 }, asteroidCollision(new int[] { -2, -1, 1, 2 }));
    }

    @Test
    public void test4() {
        Assert.assertArrayEquals(new int[] { 10 }, asteroidCollision(new int[] { 10, 2, -5 }));
    }

    @Test
    public void test3() {
        Assert.assertArrayEquals(new int[] { 5, 10 }, asteroidCollision(new int[] { 5, 10, -5 }));
    }

    @Test
    public void test2() {
        Assert.assertArrayEquals(new int[] {}, asteroidCollision(new int[] { 8, -8 }));
    }
}
