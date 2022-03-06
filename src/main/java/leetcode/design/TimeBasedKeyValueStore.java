package leetcode.design;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeBasedKeyValueStore {
    private final Map<String, TreeMap<Integer, String>> map = new HashMap<>();

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new TreeMap<>());
        }
        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> treeMap = map.get(key);
        if (treeMap == null) {
            return "";
        }
        Integer floor = treeMap.floorKey(timestamp);
        if (floor == null) {
            return "";
        }

        return treeMap.get(floor);
    }

    @Test
    public void test() {
        set("foo", "bar", 1);
        Assert.assertEquals("bar", get("foo", 1));
        Assert.assertEquals("bar", get("foo", 3));

        set("foo", "bar2", 4);
        Assert.assertEquals("bar2", get("foo", 4));
        Assert.assertEquals("bar2", get("foo", 5));
    }
}
