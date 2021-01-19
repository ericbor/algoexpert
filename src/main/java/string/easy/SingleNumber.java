package string.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

//https://leetcode.com/problems/single-number/
public class SingleNumber {

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> storage = new HashMap<>();

        for (int i : nums) {
            if (storage.get(i) != null) {
                int counter = storage.get(i);
                counter++;
                storage.put(i, counter);
            } else {
                storage.put(i, 1);
            }
        }

        Optional<Integer> result = storage.entrySet()
            .stream()
            .filter(entry -> Objects.equals(entry.getValue(), 1))
            .map(Map.Entry::getKey)
            .findAny();

        return result.get();
    }

    @Test
    public void verify() {
        Assert.assertEquals(4, singleNumber(new int[] { 4, 1, 2, 1, 2 }));
    }
}
