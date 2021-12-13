package leetcode.hard;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/minimum-window-substring/
public class MinimumWindowSubstring {
    public String minWindow2(String s, String t) {

        if (s.isEmpty() || t.isEmpty()) {
            return "";
        }

        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int start = 0;
        int end = 0;
        int matchCounter = 0;

        // Dictionary which keeps a count of all the unique characters in the current window.
        Map<Character, Integer> sMap = new HashMap<>();

        // ans list of the form (window length, left, right)
        int[] ans = { -1, 0, 0 };

        while (end < s.length()) {
            char curr = s.charAt(end);
            sMap.put(curr, sMap.getOrDefault(curr, 0) + 1);

            if (tMap.containsKey(curr)) {
                if (sMap.get(curr).intValue() == tMap.get(curr).intValue()) {
                    matchCounter++;
                }
            }

            // Try and contract the window till the point where it ceases to be 'desirable'.
            while (start <= end && matchCounter == tMap.size()) {
                char charAtStart = s.charAt(start);
                // Save the smallest window until now.
                if (ans[0] == -1 || end - start + 1 < ans[0]) {
                    ans[0] = end - start + 1;
                    ans[1] = start;
                    ans[2] = end;
                }

                // The character at the position pointed by the `start` pointer is no longer a part of the window.
                sMap.put(charAtStart, sMap.get(charAtStart) - 1);
                if (tMap.containsKey(charAtStart)) {
                    if (sMap.get(charAtStart) < tMap.get(charAtStart)) {
                        matchCounter--;
                    }
                }

                start++;
            }

            end++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

    public String minWindow(String s, String t) {
        if (s == null || s.isEmpty() || t == null || t.isEmpty()) {
            return "";
        }

        int[] tMap = new int[128];
        for (char c : t.toCharArray()) {
            tMap[c]++;
        }

        int matchCounter = 0;
        int minLength = Integer.MAX_VALUE;
        String minSubstring = "";
        int start = 0;
        int end = 0;
        int[] sMap = new int[128];

        while (end < s.length()) {
            char curr = s.charAt(end);
            if (tMap[curr] > 0) {
                sMap[curr]++;
                if (sMap[curr] <= tMap[curr]) {
                    matchCounter++;
                }
            }


            while (matchCounter == t.length()) {
                if (end - start + 1 < minLength) {
                    minLength = end - start + 1;
                    minSubstring = s.substring(start, end + 1);
                }

                char charAtStart = s.charAt(start);
                if (tMap[charAtStart] > 0) {
                    sMap[charAtStart]--;
                    if (sMap[charAtStart] < tMap[charAtStart]) {
                        matchCounter--;
                    }
                }
                start++;
            }

            end++;
        }

        return minSubstring;
    }

    @Test
    public void test() {
        Assert.assertEquals("abba", minWindow("abba", "aba"));
    }

    @Test
    public void test7() {
        Assert.assertEquals("ba", minWindow("bba", "ab"));
    }

    @Test
    public void test6() {
        Assert.assertEquals("cwae", minWindow("cabwefgewcwaefgcf", "cae"));
    }

    @Test
    public void test5() {
        Assert.assertEquals("abc", minWindow("abc", "bca"));
    }

    @Test
    public void test4() {
        Assert.assertEquals("BANC", minWindow("ADOBECODEBANC", "ABC"));
    }

    @Test
    public void test2() {
        Assert.assertEquals("a", minWindow("a", "a"));
    }

    @Test
    public void test3() {
        Assert.assertEquals("", minWindow("a", "aa"));
    }
}
