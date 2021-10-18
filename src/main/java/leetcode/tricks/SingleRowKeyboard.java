package leetcode.tricks;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/single-row-keyboard/
public class SingleRowKeyboard {
    public int calculateTime(String keyboard, String word) {
        Map<Character, Integer> keyboardMap = new HashMap<>();
        for(int i = 0; i < keyboard.length(); i++){
            keyboardMap.put(keyboard.charAt(i), i);
        }

        int result = 0;
        int prevIdx = 0;
        for (char c : word.toCharArray()) {

            int currIdx = keyboardMap.get(c);
            int currSteps = Math.abs(prevIdx - currIdx);
            result += currSteps;

            prevIdx = currIdx;
        }

        return result;
    }

    public int calculateTime2(String keyboard, String word) {
        int[] keyIndices = new int[26];

        // Get the index for each key.
        for (int i = 0; i < keyboard.length(); i++) {
            int idx = keyboard.charAt(i) - 'a';
            keyIndices[idx] = i;
        }


        int result = 0;
        int prevIdx = 0;
        for (char c : word.toCharArray()) {
            // Add the distance from previous index to current letter's index to the result.
            int currIdx = keyIndices[c - 'a'];
            int currSteps = Math.abs(prevIdx - currIdx);
            result += currSteps;

            // Update the previous index to current index for next iteration.
            prevIdx = currIdx;
        }
        return result;
    }

    @Test
    public void test() {
        Assert.assertEquals(4, calculateTime2( "abcdefghijklmnopqrstuvwxyz", "cba"));
        Assert.assertEquals(74, calculateTime2( "abcdefghijklmnopqrstuvwxyz", "leetcode"));
        Assert.assertEquals(73, calculateTime2( "pqrstuvwxyzabcdefghijklmno", "leetcode"));
    }
}
