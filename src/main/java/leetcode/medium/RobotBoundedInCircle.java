package leetcode.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/robot-bounded-in-circle/
public class RobotBoundedInCircle {
    public boolean isRobotBounded(String instructions) {

        // north = 0, east = 1, south = 2, west = 3
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // Initial position is in the center
        int x = 0;
        int y = 0;
        // facing north
        int idx = 0;

        for (char c : instructions.toCharArray()) {
            if (c == 'L') {
                idx = (idx + 3) % 4;
            } else if (c == 'R') {
                idx = (idx + 1) % 4;
            } else {
                x += directions[idx][0];
                y += directions[idx][1];
            }
        }

        // after one cycle:
        // robot returns into initial position
        // or robot doesn't face north
        return (x == 0 && y == 0) || (idx != 0);
    }

    @Test
    public void test() {
        Assert.assertTrue(isRobotBounded("LLGRL"));
    }

    @Test
    public void tes4() {
        Assert.assertTrue(isRobotBounded("GGLLGG"));
    }

    @Test
    public void test2() {
        Assert.assertFalse(isRobotBounded("GG"));
    }

    @Test
    public void test3() {
        Assert.assertTrue(isRobotBounded("GL"));
    }
}
