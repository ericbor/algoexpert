package leetcode.easy.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

//https://leetcode.com/problems/isomorphic-strings/
public class IsomorphicStrings {

    public boolean isIsomorphic2(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        Queue<Map.Entry<Character, Integer>> sMaxHeap = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
        sMaxHeap.addAll(sMap.entrySet());

        Queue<Map.Entry<Character, Integer>> tMaxHeap = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
        tMaxHeap.addAll(tMap.entrySet());

        while (!sMaxHeap.isEmpty() && !tMaxHeap.isEmpty()) {
            int sSize = sMaxHeap.poll().getValue();
            int tSize = tMaxHeap.poll().getValue();
            if (sSize != tSize) {
                return false;
            }
        }

        return true;
    }

    public boolean isIsomorphic(String s, String t) {
        if (s == null || s.length() <= 1) {
            return true;
        }

        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (map.containsKey(a)) {
                if (!map.get(a).equals(b)) {
                    return false;
                }
            } else {
                if (map.containsValue(b)) {
                    return false;
                } else {
                    map.put(a, b);
                }

            }
        }
        return true;
    }

    @Test
    public void test() {
        Assert.assertFalse(isIsomorphic("bbbaaaba", "aaabbbba"));
    }

    @Test
    public void test2() {
        Assert.assertTrue(isIsomorphic("egg", "add"));
    }

    @Test
    public void test3() {
        Assert.assertTrue(isIsomorphic("paper", "title"));
    }

    @Test
    public void test4() {
        Assert.assertFalse(isIsomorphic("foo", "bar"));
    }
}
