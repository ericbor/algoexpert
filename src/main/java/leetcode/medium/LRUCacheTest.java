package leetcode.medium;

import org.junit.Assert;
import org.junit.Test;

public class LRUCacheTest {
    private final LRUCache cache = new LRUCache(2);
    private final LRUCache2 cache2 = new LRUCache2(2);
    private final LRUCache3 cache3 = new LRUCache3(2);

    @Test
    public void test() {
        cache.put(1, 111);
        cache.put(2, 222);
        Assert.assertEquals(111, cache.get(1));
        cache.put(3, 333);
        Assert.assertEquals(-1, cache.get(2));
        cache.put(4, 444);
        Assert.assertEquals(-1, cache.get(1));
        Assert.assertEquals(333, cache.get(3));
        Assert.assertEquals(444, cache.get(4));
    }

    @Test
    public void test2() {
        cache2.put(1, 111);
        cache2.put(2, 222);
        Assert.assertEquals(111, cache2.get(1));
        cache2.put(3, 333);
        Assert.assertEquals(-1, cache2.get(2));
        cache2.put(4, 444);
        Assert.assertEquals(-1, cache2.get(1));
        Assert.assertEquals(333, cache2.get(3));
        Assert.assertEquals(444, cache2.get(4));
    }

    @Test
    public void test3() {
        cache3.put(1, 111);
        cache3.put(2, 222);
        Assert.assertEquals(111, cache3.get(1));
        cache3.put(3, 333);
        Assert.assertEquals(-1, cache3.get(2));
        cache3.put(4, 444);
        Assert.assertEquals(-1, cache3.get(1));
        Assert.assertEquals(333, cache3.get(3));
        Assert.assertEquals(444, cache3.get(4));
    }
}
