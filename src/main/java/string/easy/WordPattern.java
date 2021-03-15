package string.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/word-pattern
public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        Map<Object, Integer> mapIndex = new HashMap<>();
        String[] words = s.split(" ");

        if (words.length != pattern.length()) {
            return false;
        }

        for (int i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            if (!mapIndex.containsKey(c)) {
                mapIndex.put(c, i);
            }

            if (!mapIndex.containsKey(word)) {
                mapIndex.put(word, i);
            }

            if (!mapIndex.get(c).equals(mapIndex.get(word))) {
                return false;
            }
        }

        return true;
    }

    @Test
    public void verify() {
        //Assert.assertTrue(wordPattern("abba", "dog cat cat dog"));
        Assert.assertFalse(wordPattern("abba", "dog cat cat fish"));
        //Assert.assertFalse(wordPattern("aaaa", "dog cat cat dog"));
        //Assert.assertFalse(wordPattern("abba", "dog dog dog dog"));
    }
}
