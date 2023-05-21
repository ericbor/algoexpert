package matrix;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/concatenated-words
public class ConcatenatedWords {
    Set<String> dictionary;

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        dictionary = new HashSet<>(Arrays.asList(words));
        List<String> results = new ArrayList<>();

        for (String word : words) {
            boolean[] visited = new boolean[word.length()];
            if (dfs(word, 0, visited)) {
                results.add(word);
            }
        }

        return results;
    }

    private boolean dfs(String word, int index, boolean[] visited) {
        if (index >= word.length()) {
            return true;
        }
        if (visited[index]) {
            return false;
        }

        visited[index] = true;
        int k = index == 0 ? 1 : 0;
        for (int i = word.length() - k; i > index; i--) {
            String sub = word.substring(index, i);
            if (dictionary.contains(sub)) {
                if (dfs(word, i, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    @Test
    public void test() {
        Assert.assertEquals(List.of("catsdogcats", "dogcatsdog", "ratcatdogcat"), findAllConcatenatedWordsInADict(new String[]{"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"}));
    }
}
