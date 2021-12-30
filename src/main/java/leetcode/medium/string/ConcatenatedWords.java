package leetcode.medium.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/concatenated-words/
public class ConcatenatedWords {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, (a, b) -> b.length() - a.length());
        List<String> results = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int substringCounter = 0;

            for (int j = words.length - 1; j > i; j--) {
                String substring = words[j];
                if (word.length() == substring.length()) {
                    break;
                } else if (word.contains(substring)) {
                    substringCounter++;
                }
            }

            if (substringCounter >= 2) {
                results.add(word);
            }
        }

        return results;
    }

    @Test
    public void test() {
        Assert.assertEquals(List.of("ab"), findAllConcatenatedWordsInADict(new String[] { "a", "b", "ab", "abc" }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(List.of("ratcatdogcat", "catsdogcats", "dogcatsdog"), findAllConcatenatedWordsInADict(new String[] { "cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat" }));
    }

    @Test
    public void test3() {
        Assert.assertEquals(List.of("catdog"), findAllConcatenatedWordsInADict(new String[] { "cat", "dog", "catdog" }));
    }
}
