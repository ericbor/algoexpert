package leetcode.amazon.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/minimum-time-to-type-word-using-special-typewriter/
public class MinimumTimeToTypeWordUsingTypewriter {
    public int minTimeToType2(String word) {

        int seconds = 0;
        if (word.charAt(0) == 'a') {
            seconds++;
        } else {
            word = "a" + word;
        }
        char[] letters = word.toCharArray();

        for (int i = 1; i < letters.length; i++) {
            int currentPosition = (int) letters[i - 1] - (int) 'a' + 1;
            int nextPosition = (int) letters[i] - (int) 'a' + 1;

            int movesClockwise = Math.abs(currentPosition - nextPosition);
            int movesCounterClockwise = 26 - movesClockwise;
            int moves = Math.min(movesClockwise, movesCounterClockwise);

            seconds += moves;
            seconds++;
        }

        return seconds;
    }

    public int minTimeToType(String word) {
        int seconds = 0;
        int prev = 1; //position at `a`

        for (int i = 0; i < word.length(); ++i) {
            int cur = (int)word.charAt(i) - (int)'a' + 1;

            int movesClockwise = Math.abs(cur - prev);
            int movesCounterClockwise = 26 - movesClockwise;
            int moves = Math.min(movesClockwise, movesCounterClockwise);

            //count moves
            seconds += moves;
            //count print
            seconds++;

            prev = cur;
        }
        return seconds;
    }

    @Test
    public void test() {
        Assert.assertEquals(5, minTimeToType("abc"));
    }

    @Test
    public void test2() {
        Assert.assertEquals(7, minTimeToType("bza"));
    }

}
