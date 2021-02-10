package string.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/uncommon-words-from-two-sentences/
public class UncommonWords {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> wordCounter = new HashMap<>();

        for (String word : A.split(" ")) {
            if (wordCounter.containsKey(word)) {
                wordCounter.put(word, wordCounter.get(word) + 1);
            } else {
                wordCounter.put(word, 1);
            }
        }

        for (String word : B.split(" ")) {
            if (wordCounter.containsKey(word)) {
                wordCounter.put(word, wordCounter.get(word) + 1);
            } else {
                wordCounter.put(word, 1);
            }
        }

        List<String> results = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCounter.entrySet()) {
            if (entry.getValue() == 1) {
                results.add(entry.getKey());
            }
        }

        return results.toArray(new String[0]);
    }
}
