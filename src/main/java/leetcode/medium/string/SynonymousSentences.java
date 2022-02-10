package leetcode.medium.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

//https://leetcode.com/problems/synonymous-sentences/
public class SynonymousSentences {
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> pair : synonyms) {
            String w1 = pair.get(0), w2 = pair.get(1);
            connect(graph, w1, w2);
            connect(graph, w2, w1);
        }
        // BFS
        Set<String> ans = new TreeSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(text);

        while (!queue.isEmpty()) {
            String out = queue.poll();
            ans.add(out); // Add to result
            String[] words = out.split("\\s");

            for (int i = 0; i < words.length; i++) {
                if (!graph.containsKey(words[i])) {
                    continue;
                }
                for (String synonym : graph.get(words[i])) { // Replace words[i] with its synonym
                    words[i] = synonym;
                    String newText = String.join(" ", words);
                    if (!ans.contains(newText)) {
                        queue.add(newText);
                    }
                }
            }
        }

        return new ArrayList<>(ans);
    }

    private void connect(Map<String, List<String>> graph, String v1, String v2) {
        graph.putIfAbsent(v1, new LinkedList<>());
        graph.get(v1).add(v2);
    }

    @Test
    public void test() {
        Assert.assertEquals(List.of("I am cheerful today but was sad yesterday", "I am cheerful today but was sorrow yesterday", "I am happy today but was sad yesterday", "I am happy today but was sorrow yesterday", "I am joy today but was sad yesterday", "I am joy today but was sorrow yesterday"),
            generateSentences(List.of(List.of("happy", "joy"), List.of("sad", "sorrow"), List.of("joy", "cheerful")), "I am happy today but was sad yesterday"));
    }
}
