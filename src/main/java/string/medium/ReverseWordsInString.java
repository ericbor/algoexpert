package string.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/reverse-words-in-a-string/
public class ReverseWordsInString {

    public String reverseWords(String s) {
        String[] words = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();

        for(int i = words.length - 1; i >= 0; i--) {
            if(!words[i].isEmpty()) {
                sb.append(words[i]).append(" ");
            }
        }

        return sb.toString().trim();
    }

    public String reverseWords2(String s) {
        int start = 0;
        int end = s.length() - 1;

        // remove leading spaces
        while (start <= end && s.charAt(start) == ' ') {
            ++start;
        }

        // remove trailing spaces
        while (start <= end && s.charAt(end) == ' ') {
            --end;
        }

        Deque<String> stack = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();
        // push word by word in front of deque
        while (start <= end) {
            char c = s.charAt(start);

            if (word.length() != 0 && c == ' ') {
                stack.push(word.toString());
                word.setLength(0);
            } else if (c != ' ') {
                word.append(c);
            }
            ++start;
        }
        stack.push(word.toString());

        return String.join(" ", stack);
    }

    @Test
    public void test() {
        Assert.assertEquals("example good a", reverseWords("a good   example"));
        Assert.assertEquals("example good a", reverseWords2("a good   example"));
    }
}
