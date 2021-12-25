package leetcode.medium.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/reorganize-string/
public class ReorganizeString {
    public String reorganizeString2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Queue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
        maxHeap.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder(s.length());
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> currEntry = maxHeap.poll();
            char currChar = currEntry.getKey();

            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == currChar) {
                if (maxHeap.isEmpty()) {
                    return "";
                } else {
                    Map.Entry<Character, Integer> nextEntry = maxHeap.poll();
                    sb.append(nextEntry.getKey());
                    updateHeap(nextEntry, maxHeap);

                    maxHeap.add(currEntry);
                }
            } else {
                sb.append(currChar);
                updateHeap(currEntry, maxHeap);
            }
        }

        return sb.toString();
    }

    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Queue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
        maxHeap.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder(s.length());
        while (maxHeap.size() > 1) {
            Map.Entry<Character, Integer> first = maxHeap.poll();
            Map.Entry<Character, Integer> second = maxHeap.poll();

            sb.append(first.getKey());
            sb.append(second.getKey());
            updateHeap(first, maxHeap);
            updateHeap(second, maxHeap);
        }

        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> last = maxHeap.poll();
            if(last.getValue() > 1) {
                return "";
            }

            sb.append(last.getKey());
        }

        return sb.toString();
    }

    private void updateHeap(Map.Entry<Character, Integer> entry, Queue<Map.Entry<Character, Integer>> heap) {
        int newValue = entry.getValue() - 1;
        if (newValue > 0) {
            entry.setValue(newValue);
            heap.add(entry);
        }
    }

    @Test
    public void test() {
        Assert.assertEquals("vovlv", reorganizeString("vvvlo"));
    }

    @Test
    public void test3() {
        Assert.assertEquals("aba", reorganizeString("aab"));
    }

    @Test
    public void test2() {
        Assert.assertEquals("", reorganizeString("aaab"));
    }
}
