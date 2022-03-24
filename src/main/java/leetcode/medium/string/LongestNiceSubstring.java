package leetcode.medium.string;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/longest-nice-substring/
public class LongestNiceSubstring {
    public String longestNiceSubstring(String s) {
        int maxLength = Integer.MIN_VALUE;
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String str = s.substring(i, j);
                if (str.length() > maxLength && isNice(str)) {
                    maxLength = str.length();
                    result = str;
                }
            }
        }

        return result;
    }

    private boolean isNice(String str) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }

        for (char c : set) {
            if (Character.isUpperCase(c)) {
                if (!set.contains(Character.toLowerCase(c))) {
                    return false;
                }
            } else {
                if (!set.contains(Character.toUpperCase(c))) {
                    return false;
                }
            }
        }

        return true;
    }
}
