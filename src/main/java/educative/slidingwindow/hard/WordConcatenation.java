package educative.slidingwindow.hard;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://www.educative.io/courses/grokking-the-coding-interview/N8nMBvDQJ0m
public class WordConcatenation {
    public static List<Integer> findWordConcatenation(String str, String[] words) {
        Map<String, Integer> wordFrequencyMap = new HashMap<>();
        for (String word : words) {
            wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
        }

        List<Integer> resultIndices = new ArrayList<>();
        int wordsCount = words.length;
        int wordLength = words[0].length();

        for (int i = 0; i <= str.length() - wordsCount * wordLength; i++) {
            Map<String, Integer> wordsSeen = new HashMap<>();
            for (int j = 0; j < wordsCount; j++) {
                int nextWordIndex = i + j * wordLength;
                // get the next word from the string
                String word = str.substring(nextWordIndex, nextWordIndex + wordLength);
                if (!wordFrequencyMap.containsKey(word)) { // break if we don't need this word
                    break;
                }

                wordsSeen.put(word, wordsSeen.getOrDefault(word, 0) + 1); // add the word to the 'wordsSeen' map

                // no need to process further if the word has higher frequency than required
                if (wordsSeen.get(word) > wordFrequencyMap.getOrDefault(word, 0)) {
                    break;
                }

                if (j + 1 == wordsCount) {// store index if we have found all the words
                    resultIndices.add(i);
                }
            }
        }

        return resultIndices;
    }

    @Test
    public void verify() {
        Assert.assertEquals(List.of(0, 3), findWordConcatenation("catfoxcat", new String[] { "cat", "fox" }));
        //Assert.assertEquals(List.of(3), findWordConcatenation("catcatfoxfox", new String[] { "cat", "fox" }));
    }
}
