package array.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/fruit-into-baskets
public class FruitIntoBaskets {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = Integer.MIN_VALUE;

        int start = 0;
        for (int i = 0; i < fruits.length; i++) {
            map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);

            while (map.size() > 2) {
                map.put(fruits[start], map.get(fruits[start]) - 1);
                if (map.get(fruits[start]) == 0) {
                    map.remove(fruits[start]);
                }
                start++;
            }

            count = Math.max(count, i - start + 1);
        }

        return count;
    }

    @Test
    public void test() {
        Assert.assertEquals(3, totalFruit(new int[]{1, 2, 1, 3, 2, 2, 1, 4}));
    }
}
