package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

//https://leetcode.com/problems/assign-cookies/
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;
        int j = 0;

        int counter = 0;

        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                counter++;
                i++;
            }
            j++;
        }

        return counter;
    }

    @Test
    public void test() {
        Assert.assertEquals(6, findContentChildren(new int[] { 1, 2, 3, 4, 5, 6 }, new int[] { 1, 1, 9, 8, 7, 5, 4, 3, 2, 1 }));
    }

    @Test
    public void test3() {
        Assert.assertEquals(1, findContentChildren(new int[] { 1, 2, 3 }, new int[] { 1, 1 }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(2, findContentChildren(new int[] { 1, 2 }, new int[] { 1, 2, 3 }));
    }
}
