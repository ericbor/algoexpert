package educative.slidingwindow.hard;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://www.educative.io/courses/grokking-the-coding-interview/YQ8N2OZq0VM
public class StringAnagrams {
    public static List<Integer> findStringAnagrams(String str, String pattern) {

        List<Character> patternLetters = new ArrayList<>();
        for (char c : pattern.toCharArray()) {
            patternLetters.add(c);
        }

        int windowStart = 0;
        List<Character> strLetters = new ArrayList<>();
        List<Integer> resultIndices = new ArrayList<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            strLetters.add(str.charAt(windowEnd));

            if (strLetters.size() == patternLetters.size()) {
                if (strLetters.containsAll(patternLetters)) {
                    resultIndices.add(windowStart);
                }
                char toRemove = str.charAt(windowStart);
                strLetters.remove(Character.valueOf(toRemove));
                windowStart++;
            }
        }

        return resultIndices;
    }

    public static List<Integer> findStringAnagrams2(String str, String pattern) {
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char chr : pattern.toCharArray()) {
            charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);
        }

        int windowStart = 0;
        int matched = 0;
        List<Integer> resultIndices = new ArrayList<>();
        // our goal is to match all the characters from the map with the current window
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            // decrement the frequency of the matched character
            if (charFrequencyMap.containsKey(rightChar)) {
                charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
                if (charFrequencyMap.get(rightChar) == 0) {
                    matched++;
                }
            }

            if (matched == charFrequencyMap.size()) { // have we found an anagram?
                resultIndices.add(windowStart);
            }

            if (windowEnd >= pattern.length() - 1) { // shrink the window
                char leftChar = str.charAt(windowStart);
                if (charFrequencyMap.containsKey(leftChar)) {
                    if (charFrequencyMap.get(leftChar) == 0) {
                        matched--; // before putting the character back, decrement the matched count
                    }
                    // put the character back
                    charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
                }
                windowStart++;
            }
        }

        return resultIndices;
    }

    @Test
    public void verify() {
        Assert.assertEquals(List.of(1, 2), findStringAnagrams("ppqp", "pq"));
        Assert.assertEquals(List.of(2, 3, 4), findStringAnagrams("abbcabc", "abc"));

        Assert.assertEquals(List.of(1, 2), findStringAnagrams2("ppqp", "pq"));
        Assert.assertEquals(List.of(2, 3, 4), findStringAnagrams2("abbcabc", "abc"));
    }
}
