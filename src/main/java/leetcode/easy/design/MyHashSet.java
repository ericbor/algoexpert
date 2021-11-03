package leetcode.easy.design;

import org.junit.Assert;

//https://leetcode.com/problems/design-hashset
public class MyHashSet {
    private final Bucket[] buckets;
    private final int keyRange;

    public MyHashSet() {
        this.keyRange = 769;
        this.buckets = new Bucket[keyRange];

        for (int i = 0; i < keyRange; i++) {
            buckets[i] = new Bucket();
        }
    }

    protected int hash(int key) {
        return key % keyRange;
    }

    public void add(int key) {
        int bucketIndex = hash(key);
        buckets[bucketIndex].insert(key);
    }

    public void remove(int key) {
        int bucketIndex = hash(key);
        buckets[bucketIndex].delete(key);
    }

    public boolean contains(int key) {
        int bucketIndex = hash(key);
        return buckets[bucketIndex].exists(key);
    }

    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(770);
        hashSet.add(2);
        Assert.assertTrue(hashSet.contains(1));
        Assert.assertFalse(hashSet.contains(3));
        hashSet.add(2);
        Assert.assertTrue(hashSet.contains(2));
        hashSet.remove(2);
        Assert.assertFalse(hashSet.contains(2));
    }
}
