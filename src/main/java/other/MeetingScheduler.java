package other;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

//https://leetcode.com/problems/meeting-scheduler/editorial/
public class MeetingScheduler {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Queue<int[]> timeslots = new PriorityQueue<>((slot1, slot2) -> slot1[0] - slot2[0]);

        for (int[] slot: slots1) {
            if (slot[1] - slot[0] >= duration) {
                timeslots.offer(slot);
            }
        }
        for (int[] slot: slots2) {
            if (slot[1] - slot[0] >= duration) {
                timeslots.offer(slot);
            }
        }

        while (timeslots.size() > 1) {
            int[] slot1 = timeslots.poll();
            int[] slot2 = timeslots.peek();
            if (slot1[1] >= slot2[0] + duration) {
                return new ArrayList<>(Arrays.asList(slot2[0], slot2[0] + duration));
            }
        }

        return new ArrayList<>();
    }

    @Test
    public void test() {
        Assert.assertEquals(List.of(60, 68), minAvailableDuration(new int[][]{{10,50},{60,120},{140,210}}, new int[][]{{0,15},{60,70}}, 8));
    }
}
