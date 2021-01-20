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
        Map<Integer, Boolean> storage = new HashMap<>();

        for (int i : nums) {
            if (storage.get(i) != null) {
                storage.put(i, Boolean.FALSE);
            } else {
                storage.put(i, Boolean.TRUE);
            }
        }

        Optional<Integer> result = storage.entrySet()
            .stream()
            .filter(entry -> Objects.equals(entry.getValue(), Boolean.TRUE))
            .map(Map.Entry::getKey)
            .findAny();

        return result.get();
    }

    @Test
    public void verify() {
        Assert.assertEquals(4, singleNumber(new int[] { 4, 1, 2, 1, 2 }));
    }
}
