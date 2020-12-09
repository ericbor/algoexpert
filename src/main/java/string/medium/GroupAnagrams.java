package string.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(List<String> words) {
        Map<String, List<String>> storage = new HashMap<>();

        for (String word : words) {
            String sortedWord = sort(word);

            if (storage.get(sortedWord) != null) {
                storage.get(sortedWord).add(word);
            } else {
                List<String> anagrams = new ArrayList<>();
                anagrams.add(word);
                storage.put(sortedWord, anagrams);
            }
        }

        return new ArrayList<>(storage.values());
    }

    private static String sort(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);

        return new String(chars);
    }

    @Test
    public void verify() {
        Assert.assertEquals("zab", groupAnagrams(Arrays.asList("yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp")));
    }
}
