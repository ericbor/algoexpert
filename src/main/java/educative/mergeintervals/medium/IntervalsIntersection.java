package educative.mergeintervals.medium;

import educative.mergeintervals.Interval;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/*
Input: arr1=[[1, 3], [5, 6], [7, 9]], arr2=[[2, 3], [5, 7]]
Output: [2, 3], [5, 6], [7, 7]

Input: arr1=[[1, 3], [5, 7], [9, 12]], arr2=[[5, 10]]
Output: [5, 7], [9, 10]
 */
public class IntervalsIntersection {
    public static Interval[] merge(Interval[] arr1, Interval[] arr2) {
        List<Interval> intervalsIntersection = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (i < arr1.length || j < arr2.length) {
            Interval a = arr1[i];
            Interval b = arr2[j];
            if (a.end >= b.start) {
                int interStart = Math.max(a.start, b.start);
                int interEnd = Math.min(a.end, b.end);
                intervalsIntersection.add(new Interval(interStart, interEnd));
            }

            if (i + 1 == arr1.length && j + 1 == arr2.length) {
                break;
            } else {
                if (arr1.length > i + 1) {
                    i++;
                }
                if (arr2.length > j + 1) {
                    j++;
                }
            }
        }

        return intervalsIntersection.toArray(new Interval[intervalsIntersection.size()]);
    }

    /*
    arr1=[[1, 3], [5, 6], [7, 9]], arr2=[[2, 3], [5, 7]]
     */
    public static Interval[] merge2(Interval[] arr1, Interval[] arr2) {
        List<Interval> intersections = new ArrayList();
        int i = 0;
        int j = 0;

        while (i < arr1.length && j < arr2.length) {
            Interval a = arr1[i];//[1,3],[1,3],[5,6],[7,9]
            Interval b = arr2[j];//[2,3],[5,7],[5,7]
            // Let's check if arr1[i] intersects arr2[j].
            // lo - the startpoint of the intersection
            // hi - the endpoint of the intersection
            int lo = Math.max(a.start, b.start);//2, 5, 5, 7
            int hi = Math.min(a.end, b.end);//3, 3, 6, 7
            if (lo <= hi) {// 2 <= 3 (y), 5 <=3 (n), 5<=6 (y), 7<=7 (y)
                intersections.add(new Interval(lo, hi));
            }

            // Remove the interval with the smallest endpoint
            if (a.end < b.end) {// 3<3 (n) j++, 3<7 (y) i++, 6<7 (y) i++, 9 < 7 (n) j++
                i++;
            } else {
                j++;
            }
        }

        return intersections.toArray(new Interval[intersections.size()]);
    }

    @Test
    public void verify() {
        Interval[] input1 = { new Interval(1, 3), new Interval(5, 6), new Interval(7, 9) };
        Interval[] input2 = { new Interval(2, 3), new Interval(5, 7) };
        Assert.assertArrayEquals(new Interval[] { new Interval(2, 3), new Interval(5, 6), new Interval(7, 7) }, merge2(input1, input2));

        Interval[] input3 = new Interval[] { new Interval(1, 3), new Interval(5, 7), new Interval(9, 12) };
        Interval[] input4 = new Interval[] { new Interval(5, 10) };
        Assert.assertArrayEquals(new Interval[] { new Interval(5, 7), new Interval(9, 10) }, merge2(input3, input4));
    }
}
