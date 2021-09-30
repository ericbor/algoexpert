package educative.mergeintervals.medium;

import educative.mergeintervals.Interval;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
Given a list of intervals representing the start and end time of ‘N’ meetings, find the minimum number of rooms required to hold all the meetings.

Meetings: [[1,4], [2,5], [7,9]] ... Output: 2
Explanation: Since [1,4] and [2,5] overlap, we need two rooms to hold these two meetings. [7,9] can occur in any of the two rooms later.

Meetings: [[6,7], [2,4], [8,12]] ... Output: 1
Explanation: None of the meetings overlap, therefore we only need one room to hold all meetings.
 */
public class MinimumMeetingRooms {

    public static int findMinimumMeetingRooms(List<Interval> meetings) {
        if (meetings == null || meetings.isEmpty()) {
            return 0;
        }
        meetings.sort(Comparator.comparingInt(a -> a.start));

        int minRooms = 0;
        PriorityQueue<Interval> minHeap = new PriorityQueue<>(meetings.size(), Comparator.comparingInt(a -> a.end));
        for (Interval meeting : meetings) {
            // remove all meetings that have ended
            while (!minHeap.isEmpty() && meeting.start >= minHeap.peek().end) {
                minHeap.poll();
            }
            // add the current meeting into the minHeap
            minHeap.offer(meeting);
            // all active meeting are in the minHeap, so we need rooms for all of them.
            minRooms = Math.max(minRooms, minHeap.size());
        }
        return minRooms;
    }

    @Test
    public void verify() {
        List<Interval> input = Arrays.asList(new Interval(4, 5), new Interval(2, 3), new Interval(2, 4), new Interval(3, 5));
        Assert.assertEquals(2, findMinimumMeetingRooms(input));

/*        List<Interval> input2 = Arrays.asList(new Interval(1, 4), new Interval(2, 5), new Interval(7, 9));
        Assert.assertEquals(2, findMinimumMeetingRooms(input2));

        List<Interval> input3 = Arrays.asList(new Interval(6, 7), new Interval(2, 4), new Interval(8, 12));
        Assert.assertEquals(1, findMinimumMeetingRooms(input3));

        List<Interval> input4 = Arrays.asList(new Interval(1, 4), new Interval(2, 3), new Interval(3, 6));
        Assert.assertEquals(2, findMinimumMeetingRooms(input4));*/
    }
}
