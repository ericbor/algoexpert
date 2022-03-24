package leetcode.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class DesignHitCounter {
    private final Queue<Integer> hits = new LinkedList<>();

    public void hit(int timestamp) {
        hits.add(timestamp);
    }

    public int getHits(int timestamp) {
        while (!hits.isEmpty()) {
            int diff = timestamp - hits.peek();
            if (diff >= 300) {
                hits.poll();
            } else {
                break;
            }
        }

        return hits.size();
    }

    @Test
    public void test() {
        hit(1);
        hit(2);
        hit(3);
        Assert.assertEquals(3, getHits(4));
        hit(300);
        Assert.assertEquals(4, getHits(300));
        Assert.assertEquals(2, getHits(302));
    }
}
