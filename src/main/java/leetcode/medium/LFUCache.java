package leetcode.medium;

import org.junit.Assert;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {
    private final int capacity;
    private int minFreq = 0;
    private final Map<String, Integer> keyToVal = new HashMap<>();
    private final Map<String, Integer> keyToFreq = new HashMap<>();
    private final Map<Integer, LinkedHashSet<String>> freqToKeys = new HashMap<>();

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(String key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }

        int freq = keyToFreq.get(key);
        freqToKeys.get(freq).remove(key);
        if (freq == minFreq && freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);
            minFreq++;
        }

        // Increase key's freq by 1
        // Add this key to next freq's list
        putFreq(key, freq + 1);
        return keyToVal.get(key);
    }

    public void put(String key, int value) {
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            get(key); // Update key's count
            return;
        }

        if (keyToVal.size() == capacity) {
            // Evict LRU key from the minFreq list
            String keyToEvict = freqToKeys.get(minFreq).iterator().next();
            freqToKeys.get(minFreq).remove(keyToEvict);
            keyToVal.remove(keyToEvict);
        }

        minFreq = 1;
        putFreq(key, minFreq);    // Add new key and freq
        keyToVal.put(key, value); // Add new key and value
    }

    private void putFreq(String key, int freq) {
        keyToFreq.put(key, freq);
        freqToKeys.putIfAbsent(freq, new LinkedHashSet<>());
        freqToKeys.get(freq).add(key);
    }

    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(2);
        lfu.put("A", 1);   // cache=[1,_], cnt(1)=1
        lfu.put("B", 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
        Assert.assertEquals(1, lfu.get("A"));      // return 1
        // cache=[1,2], cnt(2)=1, cnt(1)=2
        lfu.put("C", 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
        // cache=[3,1], cnt(3)=1, cnt(1)=2
        Assert.assertEquals(-1, lfu.get("B"));// return -1 (not found)
        Assert.assertEquals(3, lfu.get("C"));// return 3
        // cache=[3,1], cnt(3)=2, cnt(1)=2
        lfu.put("D", 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
        // cache=[4,3], cnt(4)=1, cnt(3)=2
        Assert.assertEquals(-1, lfu.get("A")); // return -1 (not found)
        Assert.assertEquals(3, lfu.get("C"));  // return 3
        // cache=[3,4], cnt(4)=1, cnt(3)=3
        Assert.assertEquals(4, lfu.get("D"));// return 4
        // cache=[4,3], cnt(4)=2, cnt(3)=3
    }
}
