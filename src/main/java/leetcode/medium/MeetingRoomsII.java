package leetcode.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/meeting-rooms-ii/
public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        int roomsRequired = 1;
        if (intervals.length == 1) {
            return roomsRequired;
        }

        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });

        Queue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        for(int[] interval: intervals) {
            if(minHeap.isEmpty()) {
                minHeap.add(interval);
            } else {
                if(interval[0] < minHeap.peek()[1]) {
                    roomsRequired++;
                } else {
                    minHeap.poll();
                }
                minHeap.add(interval);
            }
        }

        return roomsRequired;
    }

    @Test
    public void test() {
        Assert.assertEquals(3, minMeetingRooms(new int[][] { { 9, 16 }, { 6, 16 }, { 1, 9 }, { 3, 15 } }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(2, minMeetingRooms(new int[][] { { 0, 30 }, { 5, 10 }, { 15, 20 } }));
    }

    @Test
    public void test3() {
        Assert.assertEquals(1, minMeetingRooms(new int[][] { { 7, 10 }, { 2, 4 } }));
    }
}
