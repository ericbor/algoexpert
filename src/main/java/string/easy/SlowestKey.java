package string.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/slowest-key/
public class SlowestKey {

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char maxKeyPressed = keysPressed.charAt(0);
        int maxDuration = releaseTimes[0];

        for (int i = 1; i < releaseTimes.length; i++) {
            int currentDuration = releaseTimes[i] - releaseTimes[i - 1];
            if (currentDuration > maxDuration) {
                maxDuration = currentDuration;
                maxKeyPressed = keysPressed.charAt(i);
            } else if (currentDuration == maxDuration) {
                if (keysPressed.charAt(i) > maxKeyPressed) {
                    maxKeyPressed = keysPressed.charAt(i);
                }
            }
        }

        return maxKeyPressed;
    }

    @Test
    public void verify() {
        Assert.assertEquals('c', slowestKey(new int[] { 9, 29, 49, 50 }, "cbcd"));
    }

}
