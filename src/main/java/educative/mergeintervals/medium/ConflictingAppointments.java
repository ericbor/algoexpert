package educative.mergeintervals.medium;

import educative.mergeintervals.Interval;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/*
Appointments: [[1,4], [2,5], [7,9]] ... Output: false
Explanation: Since [1,4] and [2,5] overlap, a person cannot attend both of these appointments.

Appointments: [[6,7], [2,4], [8,12]] ... Output: true
Explanation: None of the appointments overlap, therefore a person can attend all of them.
 */
public class ConflictingAppointments {
    public static boolean canAttendAllAppointments(Interval[] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a.start));

        for (int i = 1; i < intervals.length; i++) {
            Interval a = intervals[i - 1];
            Interval b = intervals[i];

            if (a.end > b.start) {
                return false;
            }
        }

        return true;
    }

    @Test
    public void verify() {
        Interval[] intervals = { new Interval(1, 4), new Interval(2, 5), new Interval(7, 9) };
        Assert.assertFalse(canAttendAllAppointments(intervals));

        Interval[] intervals1 = { new Interval(6, 7), new Interval(2, 4), new Interval(8, 12) };
        Assert.assertTrue(canAttendAllAppointments(intervals1));

        Interval[] intervals2 = { new Interval(4, 5), new Interval(2, 3), new Interval(3, 6) };
        Assert.assertFalse(canAttendAllAppointments(intervals2));
    }
}
