package other;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/the-number-of-full-rounds-you-have-played/
public class NumberOfFullRoundsYouHavePlayed {
    public int numberOfRounds(String startTime, String finishTime) {
        int start = getMinutes(startTime);
        int end = getMinutes(finishTime);
        if (start > end) {
            end += 24 * 60;
        }

        double fromEndGames = end / 15.00;
        double fromStartGames = start / 15.00;

        return (int) Math.floor(fromEndGames) - (int) Math.ceil(fromStartGames);
    }

    private int getMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    @Test
    public void test() {
        Assert.assertEquals(22, numberOfRounds("21:30", "03:00"));
    }

    @Test
    public void test2() {
        Assert.assertEquals(1, numberOfRounds("09:31", "10:14"));
    }

    @Test
    public void test3() {
        Assert.assertEquals(1, numberOfRounds("09:45", "10:15"));
    }
}
