package leetcode.easy.design;

import org.junit.Assert;

//https://leetcode.com/problems/design-hashmap/
public class MyHashMap {
    private final MapBucket[] buckets;
    private final int keySpace;

    public MyHashMap() {
        this.keySpace = 2069;
        buckets = new MapBucket[keySpace];

        for (int i = 0; i < keySpace; i++) {
            buckets[i] = new MapBucket();
        }
    }

    protected int hash(int key) {
        return key % keySpace;
    }

    public void put(int key, int value) {
        int hashKey = hash(key);
        buckets[hashKey].update(key, value);
    }

    public int get(int key) {
        int hashKey = hash(key);

        return buckets[hashKey].get(key);
    }

    public void remove(int key) {
        int hashKey = hash(key);
        buckets[hashKey].remove(key);
    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1, 10);
        map.put(2, 20);
        Assert.assertEquals(10, map.get(1));
        Assert.assertEquals(-1, map.get(3));
        map.put(2, 23);
        Assert.assertEquals(23, map.get(2));
        map.remove(2);
        Assert.assertEquals(-1, map.get(2));
    }
}
