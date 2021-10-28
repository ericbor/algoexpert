package leetcode.easy;

import org.junit.Assert;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

//https://leetcode.com/problems/number-of-recent-calls/
public class NumberOfRecentCalls {
    private final List<Integer> list = new LinkedList<>();

    public NumberOfRecentCalls() {

    }

    public int ping(int t) {
        list.add(t);

        int from = t - 3000;
        int to = t;

        int withingRangeCounter = 0;

        ListIterator<Integer> li = list.listIterator(list.size());
        while (li.hasPrevious()) {
            int prev = li.previous();
            if (prev >= from && prev <= to) {
                withingRangeCounter++;
            } else {
                list.remove(prev);
            }
        }

        return withingRangeCounter;
    }

    public static void main(String[] args) {
        NumberOfRecentCalls recentCalls = new NumberOfRecentCalls();
        Assert.assertEquals(1, recentCalls.ping(1));
        Assert.assertEquals(2, recentCalls.ping(100));
        Assert.assertEquals(3, recentCalls.ping(3001));
        Assert.assertEquals(3, recentCalls.ping(3002));
    }
}
