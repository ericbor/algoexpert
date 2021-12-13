package leetcode.medium.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring2(String s) {

        Queue<Character> queue = new LinkedList<>();
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (queue.contains(curr)) {
                longest = Math.max(longest, queue.size());
                while (queue.contains(curr)) {
                    queue.poll();
                }
            }
            queue.add(curr);
        }

        return Math.max(longest, queue.size());
    }

    public int lengthOfLongestSubstring4(String s) {
        int longest = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        int start = 0;
        for (int j = 0; j < s.length(); j++) {
            char curr = s.charAt(j);
            if (map.containsKey(curr)) {
                start = Math.max(map.get(curr), start);
            }

            longest = Math.max(longest, j - start + 1);
            map.put(curr, j + 1);
        }
        return longest;
    }

    public int lengthOfLongestSubstring(String s) {
        int[] chars = new int[128];

        int left = 0;
        int right = 0;

        int longest = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            chars[r]++;

            while (chars[r] > 1) {
                char l = s.charAt(left);
                chars[l]--;
                left++;
            }

            longest = Math.max(longest, right - left + 1);

            right++;
        }
        return longest;
    }

    @Test
    public void test() {
        Assert.assertEquals(6, lengthOfLongestSubstring("asjrgapa"));
    }

    @Test
    public void test5() {
        Assert.assertEquals(3, lengthOfLongestSubstring("dvdf"));
    }

    @Test
    public void test4() {
        Assert.assertEquals(1, lengthOfLongestSubstring("   "));
    }

    @Test
    public void test3() {
        Assert.assertEquals(1, lengthOfLongestSubstring(" "));
    }

    @Test
    public void test2() {
        Assert.assertEquals(3, lengthOfLongestSubstring("pwwkew"));
    }
}
