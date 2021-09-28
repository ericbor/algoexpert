package educative.mergeintervals.medium;

import educative.mergeintervals.Interval;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
Intervals: [[1,4], [2,5], [7,9]] ... Output: [[1,5], [7,9]]
Explanation: Since the first two intervals [1,4] and [2,5] overlap, we merged them into one [1,5].

Intervals: [[6,7], [2,4], [5,9]] ... Output: [[2,4], [5,9]]
Explanation: Since the intervals [6,7] and [5,9] overlap, we merged them into one [5,9].
 */
public class MergeIntervals {
    public static List<Interval> merge(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(a -> a.start));
        LinkedList<Interval> merged = new LinkedList<>();

        for (Interval interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty()) {
                merged.add(interval);
            } else if(merged.getLast().end < interval.start) {
                merged.add(interval);
            } else {
                // otherwise, there is overlap, so we merge the current and previous intervals.
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }
        return merged;
    }

    @Test
    public void verify() {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        Assert.assertEquals(List.of(new Interval(1, 5), new Interval(7, 9)), merge(input));

        List<Interval> input2 = new ArrayList<>();
        input2.add(new Interval(6, 7));
        input2.add(new Interval(2, 4));
        input2.add(new Interval(5, 9));
        Assert.assertEquals(List.of(new Interval(2, 4), new Interval(5, 9)), merge(input2));

        List<Interval> input3 = new ArrayList<>();
        input3.add(new Interval(1, 4));
        input3.add(new Interval(2, 6));
        input3.add(new Interval(3, 5));
        Assert.assertEquals(List.of(new Interval(1, 6)), merge(input3));
    }
}
