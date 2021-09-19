package educative.slidingwindow.hard;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NoRepeatSubstring {
    public static int findLength(String str) {
        int longestSubstring = Integer.MIN_VALUE;
        List<Character> charsList = new ArrayList<>();

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char leftChar = str.charAt(windowEnd);
            if (charsList.contains(leftChar)) {
                charsList.clear();
            }
            charsList.add(leftChar);

            longestSubstring = Math.max(longestSubstring, charsList.size());
        }

        return longestSubstring;
    }

    public static int findLength2(String str) {
        int windowStart = 0;
        int longestSubstring = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();
        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            // if the map already contains the 'rightChar', shrink the window from the beginning so that
            // we have only one occurrence of 'rightChar'
            if (charIndexMap.containsKey(rightChar)) {
                // this is tricky; in the current window, we will not have any 'rightChar' after its previous index
                // and if 'windowStart' is already ahead of the last index of 'rightChar', we'll keep 'windowStart'
                windowStart = Math.max(windowStart, charIndexMap.get(rightChar) + 1);
            }
            charIndexMap.put(rightChar, windowEnd); // insert the 'rightChar' into the map
            longestSubstring = Math.max(longestSubstring, windowEnd - windowStart + 1); // remember the maximum length so far
        }

        return longestSubstring;
    }

    @Test
    public void verify() {
        Assert.assertEquals(3, findLength2("aabccbb"));
        //Assert.assertEquals(3, findLength("aabccbb"));
        //Assert.assertEquals(3, findLength("abccde"));
    }
}
