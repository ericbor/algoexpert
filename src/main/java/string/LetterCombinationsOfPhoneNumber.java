package string;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class LetterCombinationsOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return Collections.emptyList();
        }

        Queue<String> results = new LinkedList<>();
        results.add("");
        String[] map = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

        for (int i = 0; i < digits.length(); i++) {
            int x = (int) digits.charAt(i) - (int) '0';
            String mapping = map[x];

            while (results.peek().length() == i) {
                String t = results.poll();
                for (char c : mapping.toCharArray()) {
                    results.add(t + c);
                }
            }
        }

        return new ArrayList<>(results);
    }

    @Test
    public void test() {
        Assert.assertEquals(List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"), letterCombinations("23"));
    }

    @Test
    public void test2() {
        Assert.assertEquals(List.of("a", "b", "c"), letterCombinations("2"));
    }
}
