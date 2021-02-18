package string.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/path-crossing/
public class PathCrossing {
    public boolean isPathCrossing(String path) {
        Set<String> visitedPoints = new HashSet<>();
        visitedPoints.add("00");

        int x = 0;
        int y = 0;
        for (char c : path.toCharArray()) {
            if (c == 'N') {
                y++;
            } else if (c == 'S') {
                y--;
            } else if (c == 'E') {
                x++;
            } else if (c == 'W') {
                x--;
            }

            if (!visitedPoints.add(String.valueOf(x) + y)) {
                return true;
            }
        }

        return false;
    }

    @Test
    public void verify() {
        Assert.assertFalse(isPathCrossing("NES"));
        Assert.assertTrue(isPathCrossing("NESWW"));
    }
}
