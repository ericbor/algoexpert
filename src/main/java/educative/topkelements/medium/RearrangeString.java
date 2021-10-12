package educative.topkelements.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*
Given a string, find if its letters can be rearranged in such a way that no two same characters come next to each other.

Input: "aappp"
Output: "papap"

Input: "Programming"
Output: "rgmrgmPiano" or "gmringmrPoa" or "gmrPagimnor", etc.

Input: "aapa"
Output: ""
 */
public class RearrangeString {
    public static String rearrangeString(String str) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        Queue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
        maxHeap.addAll(frequencyMap.entrySet());

        Map.Entry<Character, Integer> previousEntry = null;
        StringBuilder sb = new StringBuilder(str.length());
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> currentEntry = maxHeap.poll();
            // add the previous entry back in the heap if its frequency is greater than zero
            if (previousEntry != null && previousEntry.getValue() > 0) {
                maxHeap.add(previousEntry);
            }

            // append the current character to the result string and decrement its count
            sb.append(currentEntry.getKey());
            currentEntry.setValue(currentEntry.getValue() - 1);
            previousEntry = currentEntry;
        }

        // if we were successful in appending all the characters to the result string, return it
        return sb.length() == str.length() ? sb.toString() : "";
    }

    @Test
    public void main() {
        Assert.assertEquals("papap", rearrangeString("aappp"));
    }

    @Test
    public void main2() {
        List<String> expectedTitlesList = Arrays.asList("rgmrgmPiano", "gmringmrPoa", "gmrPagimnor");
        Assert.assertTrue(expectedTitlesList.contains(rearrangeString("Programming")));
    }

    @Test
    public void main3() {
        Assert.assertEquals("", rearrangeString("aapa"));
    }
}
