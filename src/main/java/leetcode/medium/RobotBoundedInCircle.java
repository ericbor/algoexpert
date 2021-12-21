package leetcode.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/robot-bounded-in-circle/
public class RobotBoundedInCircle {
    public boolean isRobotBounded(String instructions) {

        Map<String, String> directions = new HashMap<>();
        directions.put("NN", "north");
        directions.put("NL", "east");
        directions.put("NR", "west");
        directions.put("LL", "south");
        directions.put("LR", "north");
        directions.put("RR", "south");
        directions.put("RL", "north");

        int distance = 0;
        StringBuilder sb = new StringBuilder("N");
        String lastDirection = "";
        for(char c: instructions.toCharArray()) {
            if(c == 'G') {
                sb.append(sb.substring(sb.length() - 1));
            } else {
                sb.append(c);
            }

            lastDirection = sb.substring(sb.length() - 2);
            if("north".equals(directions.get(lastDirection))) {
                distance++;
            } else if("south".equals(directions.get(lastDirection))) {
                distance--;
            }
        }

        return !"north".equals(directions.get(lastDirection)) || distance <= 0;

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
