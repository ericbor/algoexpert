package other;

import org.junit.Assert;

//https://leetcode.com/problems/design-hit-counter/
public class HitCounter {
    private static final int FIVE_MINUTES_SIZE = 5 * 60;

    private final int[] queue;
    private int index;

    public HitCounter() {
        queue = new int[FIVE_MINUTES_SIZE];
    }

    public void hit(int timestamp) {
        queue[index % FIVE_MINUTES_SIZE] = timestamp;
        index++;
    }

    public int getHits(int timestamp) {
        int counter = 0;
        int i = index > 0 ? index - 1 : 0;

        while (queue[i] > 0 && timestamp - queue[i] < FIVE_MINUTES_SIZE) {
            counter++;
            i = i - 1 >= 0 ? i - 1 : queue.length - 1;
        }

        return counter;
    }

    public static void main(String[] args) {
        HitCounter hitCounter = new HitCounter();
        hitCounter.hit(1);       // hit at timestamp 1.
        hitCounter.hit(2);       // hit at timestamp 2.
        hitCounter.hit(3);       // hit at timestamp 3.
        Assert.assertEquals(3, hitCounter.getHits(4));   // get hits at timestamp 4, return 3.
        hitCounter.hit(300);     // hit at timestamp 300.
        Assert.assertEquals(4, hitCounter.getHits(300));
        Assert.assertEquals(3, hitCounter.getHits(301));
        Assert.assertEquals(0, hitCounter.getHits(1500));
    }
}
