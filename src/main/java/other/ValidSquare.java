package other;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/valid-square
public class ValidSquare {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        if (isSame(p1,p2) || isSame(p1,p3) || isSame(p1,p4) || isSame(p2,p3) || isSame(p3,p4) || isSame(p2,p4)) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        set.add(dis(p1,p2));
        set.add(dis(p1,p3));
        set.add(dis(p1,p4));
        set.add(dis(p2,p3));
        set.add(dis(p2,p4));
        set.add(dis(p3,p4));

        return set.size() == 2;
    }
    private Map<Integer, Integer> map = new HashMap<>();
    public boolean validSquare2(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] points = {p1,p2,p3,p4};
        for(int i = 0; i < points.length; i++) {
            for(int j = i + 1; j < points.length; j++) {
                int[] x = points[i];
                int[] y = points[j];
                int distance = dis(x, y);
                map.put(distance, map.getOrDefault(distance, 0) + 1);
            }
        }

        if(map.size() != 2 || map.containsKey(0)) {
            return false;
        }

        return map.containsValue(2) && map.containsValue(4);
    }

    private void updateMap(int[] x, int[] y) {
        int distance = dis(x, y);
        map.put(distance, map.getOrDefault(distance, 0) + 1);
    }

    private boolean isSame(int[] p1, int[] p2) {
        return p1[0] == p2[0] && p1[1] == p2[1];
    }

    private int dis(int[] p1, int[] p2) {
        return (p1[0]-p2[0]) * (p1[0]-p2[0]) + (p1[1]-p2[1]) * (p1[1]-p2[1]);
    }

    @Test
    public void test() {
        Assert.assertTrue(validSquare(new int[]{0,0}, new int[]{1,1}, new int[]{1,0}, new int[]{0,1}));
        Assert.assertTrue(validSquare2(new int[]{0,0}, new int[]{1,1}, new int[]{1,0}, new int[]{0,1}));
    }

    @Test
    public void test2() {
        Assert.assertFalse(validSquare(new int[]{0,0}, new int[]{1,1}, new int[]{0,0}, new int[]{1,1}));
        Assert.assertFalse(validSquare2(new int[]{0,0}, new int[]{1,1}, new int[]{0,0}, new int[]{1,1}));
    }

    @Test
    public void testWithoutIsSameFails() {
        Assert.assertFalse(validSquare(new int[]{0,0}, new int[]{1,1}, new int[]{0,0}, new int[]{0,0}));
        Assert.assertFalse(validSquare2(new int[]{0,0}, new int[]{1,1}, new int[]{0,0}, new int[]{0,0}));
    }
}
