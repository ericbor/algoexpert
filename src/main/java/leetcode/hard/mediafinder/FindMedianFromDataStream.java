package leetcode.hard.mediafinder;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/find-median-from-data-stream/
public class FindMedianFromDataStream {

    private final MedianFinder medianFinder = new MedianFinder();

    @Test
    public void test() {
        medianFinder.addNum(40);
        Assert.assertEquals(40.0, medianFinder.findMedian(), 1);
        medianFinder.addNum(12);
        Assert.assertEquals(26.0, medianFinder.findMedian(), 1);
        medianFinder.addNum(16);
        Assert.assertEquals(16.0, medianFinder.findMedian(), 1);

        medianFinder.addNum(14);
        Assert.assertEquals(15.0, medianFinder.findMedian(), 1);
        medianFinder.addNum(35);
        Assert.assertEquals(16.0, medianFinder.findMedian(), 1);
        medianFinder.addNum(19);
        Assert.assertEquals(17.5, medianFinder.findMedian(), 1);

        medianFinder.addNum(34);
        Assert.assertEquals(19.0, medianFinder.findMedian(), 1);
        medianFinder.addNum(35);
        Assert.assertEquals(26.5, medianFinder.findMedian(), 1);
        medianFinder.addNum(28);
        Assert.assertEquals(28.0, medianFinder.findMedian(), 1);

        medianFinder.addNum(35);
        Assert.assertEquals(31.0, medianFinder.findMedian(), 1);
        medianFinder.addNum(26);
        Assert.assertEquals(28.0, medianFinder.findMedian(), 1);
        medianFinder.addNum(6);
        Assert.assertEquals(27.0, medianFinder.findMedian(), 1);

        medianFinder.addNum(8);
        Assert.assertEquals(26.0, medianFinder.findMedian(), 1);
        medianFinder.addNum(2);
        Assert.assertEquals(22.5, medianFinder.findMedian(), 1);
        medianFinder.addNum(14);
        Assert.assertEquals(19.0, medianFinder.findMedian(), 1);
        medianFinder.addNum(25);
        Assert.assertEquals(22.0, medianFinder.findMedian(), 1);

        medianFinder.addNum(25);
        Assert.assertEquals(25.0, medianFinder.findMedian(), 1);
        medianFinder.addNum(4);
        Assert.assertEquals(22.0, medianFinder.findMedian(), 1);
        medianFinder.addNum(33);
        Assert.assertEquals(25.0, medianFinder.findMedian(), 1);
        medianFinder.addNum(18);
        Assert.assertEquals(22.0, medianFinder.findMedian(), 1);

        medianFinder.addNum(10);
        Assert.assertEquals(19.0, medianFinder.findMedian(), 1);
        medianFinder.addNum(14);
        Assert.assertEquals(18.5, medianFinder.findMedian(), 1);
        medianFinder.addNum(27);
        Assert.assertEquals(19.0, medianFinder.findMedian(), 1);
        medianFinder.addNum(3);
        Assert.assertEquals(18.5, medianFinder.findMedian(), 1);

        medianFinder.addNum(35);
        Assert.assertEquals(19.0, medianFinder.findMedian(), 1);
        medianFinder.addNum(13);
        Assert.assertEquals(18.5, medianFinder.findMedian(), 1);
        medianFinder.addNum(24);
        Assert.assertEquals(19.0, medianFinder.findMedian(), 1);
        medianFinder.addNum(27);
        Assert.assertEquals(21.5, medianFinder.findMedian(), 1);
        medianFinder.addNum(14);
        Assert.assertEquals(19.0, medianFinder.findMedian(), 1);

        medianFinder.addNum(5);
        Assert.assertEquals(18.5, medianFinder.findMedian(), 1);
        medianFinder.addNum(0);
        Assert.assertEquals(18.0, medianFinder.findMedian(), 1);
        medianFinder.addNum(38);
        Assert.assertEquals(18.5, medianFinder.findMedian(), 1);

        medianFinder.addNum(19);
        Assert.assertEquals(19.0, medianFinder.findMedian(), 1);
        medianFinder.addNum(25);
        Assert.assertEquals(19.0, medianFinder.findMedian(), 1);
        medianFinder.addNum(11);
        Assert.assertEquals(19.0, medianFinder.findMedian(), 1);

        medianFinder.addNum(14);
        Assert.assertEquals(18.5, medianFinder.findMedian(), 1);
        medianFinder.addNum(31);
        Assert.assertEquals(19.0, medianFinder.findMedian(), 1);
        medianFinder.addNum(30);
        Assert.assertEquals(19.0, medianFinder.findMedian(), 1);
        medianFinder.addNum(11);
        Assert.assertEquals(19.0, medianFinder.findMedian(), 1);
        medianFinder.addNum(31);
        Assert.assertEquals(19.0, medianFinder.findMedian(), 1);
        medianFinder.addNum(0);
        Assert.assertEquals(19.0, medianFinder.findMedian(), 1);
    }
}
