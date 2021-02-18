package array.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

//https://leetcode.com/problems/meeting-rooms/
public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length < 2) {
            return true;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < intervals.length - 1; i++) {
            int meetingEnd = intervals[i][1];
            int nextMeetingStart = intervals[i + 1][0];

            if (meetingEnd > nextMeetingStart) {
                return false;
            }
        }

        return true;
    }

    @Test
    public void verify() {
        Assert.assertFalse(canAttendMeetings(new int[][] { { 0, 30 }, { 5, 10 }, { 15, 20 } }));
        Assert.assertTrue(canAttendMeetings(new int[][] { { 7, 10 }, { 2, 4 } }));
        Assert.assertTrue(canAttendMeetings(new int[][] {}));
        Assert.assertFalse(canAttendMeetings(new int[][] { { 5, 8 }, { 6, 8 } }));
        Assert.assertFalse(canAttendMeetings(new int[][] { { 6, 15 }, { 13, 20 }, { 6, 17 } }));
        Assert.assertFalse(canAttendMeetings(new int[][] { { 19, 20 }, { 1, 10 }, { 5, 14 } }));
        Assert.assertTrue(canAttendMeetings(new int[][] { { 13, 15 }, { 1, 13 } }));
        Assert.assertFalse(canAttendMeetings(new int[][] { { 0, 30 }, { 60, 240 }, { 90, 120 } }));
    }
}
