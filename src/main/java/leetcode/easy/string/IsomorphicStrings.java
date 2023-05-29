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

        int[] sHash = new int[256];

        int[] tHash = new int[256];

        for (int i = 0; i < s.length(); ++i) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            // Case 1: No mapping exists in either of the dictionaries
            if (sHash[sChar] == 0 && tHash[tChar] == 0) {
                sHash[sChar] = tChar;
                tHash[tChar] = sChar;
            }

            // Case 2: Ether mapping doesn't exist in one of the dictionaries or Mapping exists and
            // it doesn't match in either of the dictionaries or both
            else if (!(sHash[sChar] == tChar && tHash[tChar] == sChar)) {
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
        Assert.assertFalse(isIsomorphic2("bbbaaaba", "aaabbbba"));
    }

    @Test
    public void test2() {
        Assert.assertTrue(isIsomorphic("egg", "add"));
        Assert.assertTrue(isIsomorphic2("egg", "add"));
    }

    @Test
    public void test3() {
        Assert.assertTrue(isIsomorphic("paper", "title"));
        Assert.assertTrue(isIsomorphic2("paper", "title"));
    }

    @Test
    public void test4() {
        Assert.assertFalse(isIsomorphic("foo", "bar"));
        Assert.assertFalse(isIsomorphic2("foo", "bar"));
    }
}
