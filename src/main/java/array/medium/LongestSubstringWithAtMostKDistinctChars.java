package array.medium;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
public class LongestSubstringWithAtMostKDistinctChars {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();

        int start = 0;
        int maxSubstring = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while (map.size() > k) {
                char atStart = s.charAt(start);
                int val = map.get(atStart);
                val--;
                if (val > 0) {
                    map.put(atStart, val);
                } else {
                    map.remove(atStart);
                }
                start++;
            }

            maxSubstring = Math.max(maxSubstring, i - start + 1);
        }

        return maxSubstring;
    }
}
