package leetcode.easy.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/number-of-equivalent-domino-pairs/
public class NumberOfEquivalentDominoPairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String, Integer> hash = new HashMap<>();

        for (int[] domino : dominoes) {
            Arrays.sort(domino);
            String key = "" + domino[0] + domino[1];
            hash.put(key, hash.getOrDefault(key, 0) + 1);
        }

        int count = 0;

        for (int pairs : hash.values()) {
            int handshakes = 0;
            for (int i = pairs - 1; i >= 1; i--) {
                handshakes += i;
            }

            count += handshakes;
        }

        return count;
    }

    @Test
    public void test() {
        Assert.assertEquals(1, numEquivDominoPairs(new int[][] { { 1, 2 }, { 2, 1 }, { 3, 4 }, { 5, 6 } }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(3, numEquivDominoPairs(new int[][] { { 1, 2 }, { 1, 2 }, { 1, 1 }, { 1, 2 }, { 2, 2 } }));
    }

    @Test
    public void test3() {
        Assert.assertEquals(4, numEquivDominoPairs(new int[][] { { 1, 2 }, { 1, 2 }, { 1, 1 }, { 1, 2 }, { 1, 1 }, { 4, 4 } }));
    }

    @Test
    public void test4() {
        Assert.assertEquals(15, numEquivDominoPairs(new int[][] { { 2, 1 }, { 1, 2 }, { 1, 2 }, { 1, 2 }, { 2, 1 }, { 1, 1 }, { 1, 2 }, { 2, 2 } }));
    }
}
