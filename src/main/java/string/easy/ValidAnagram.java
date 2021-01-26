package string.easy;

import org.junit.Assert;
import org.junit.Test;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int sCount = (int) s.charAt(i) - (int) 'a';
            int tCount = (int) t.charAt(i) - (int) 'a';
            counter[sCount]++;
            counter[tCount]--;
        }

        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void verify() {
        Assert.assertTrue(isAnagram("anagram", "nagaram"));
    }
}
