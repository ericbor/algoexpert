package educative.mergeintervals.medium;

import educative.mergeintervals.Interval;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,6]
Output: [[1,3], [4,7], [8,12]]

Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,10]
Output: [[1,3], [4,12]]
 */
public class InsertInterval {
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int currentIndex = 0;
        for (Interval interval : intervals) {
            if (interval.start > newInterval.start) {
                intervals.add(currentIndex, newInterval);
                break;
            }
            currentIndex++;
        }

        LinkedList<Interval> merged = new LinkedList<>();
        for (Interval curr : intervals) {
            if (merged.isEmpty()) {
                merged.add(curr);
            } else if (merged.getLast().end < curr.start) {
                merged.add(curr);
            } else {
                merged.getLast().end = Math.max(merged.getLast().end, curr.end);
            }
        }

        return merged;
    }

    public static List<Interval> insert2(List<Interval> intervals, Interval newInterval) {
        List<Interval> mergedIntervals = new ArrayList<>();

        int i = 0;
        // skip (and add to output) all intervals that come before the 'newInterval'
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            mergedIntervals.add(intervals.get(i));
            i++;
        }

        // merge all intervals that overlap with 'newInterval'
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
            newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
            i++;
        }

        // insert the newInterval
        mergedIntervals.add(newInterval);

        // add all the remaining intervals to the output
        while (i < intervals.size()) {
            mergedIntervals.add(intervals.get(i));
            i++;
        }

        return mergedIntervals;
    }

    @Test
    public void verify() {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        Assert.assertEquals(List.of(new Interval(1, 3), new Interval(4, 7), new Interval(8, 12)), insert2(input, new Interval(4, 6)));

        List<Interval> input2 = new ArrayList<>();
        input2.add(new Interval(1, 3));
        input2.add(new Interval(5, 7));
        input2.add(new Interval(8, 12));
        Assert.assertEquals(List.of(new Interval(1, 3), new Interval(4, 12)), insert2(input2, new Interval(4, 10)));

        List<Interval> input3 = new ArrayList<>();
        input3.add(new Interval(2, 3));
        input3.add(new Interval(5, 7));
        Assert.assertEquals(List.of(new Interval(1, 4), new Interval(5, 7)), insert2(input3, new Interval(1, 4)));
    }
}
