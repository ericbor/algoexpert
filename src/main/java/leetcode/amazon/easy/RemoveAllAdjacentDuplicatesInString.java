package leetcode.amazon.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String s) {
        List<Character> list = new ArrayList<>();
        for (char c : s.toCharArray()) {
            list.add(c);
        }

        int idx = 1;
        while (idx < list.size()) {
            char curr = list.get(idx);
            char prev = list.get(idx - 1);
            if (curr == prev) {
                list.remove(idx);
                list.remove(idx - 1);
                idx = 1;
            } else {
                idx++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(c);
        }

        return sb.toString();
    }

    public String removeDuplicates2(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            if(!stack.isEmpty() && c == stack.peek()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }

    public String removeDuplicates3(String s) {
        StringBuilder sb = new StringBuilder();
        int sbLength = 0;
        for(char character : s.toCharArray()) {
            if (sbLength != 0 && character == sb.charAt(sbLength - 1)) {
                sb.deleteCharAt(sbLength - 1);
                sbLength--;
            } else {
                sb.append(character);
                sbLength++;
            }
        }
        
        return sb.toString();
    }

    @Test
    public void test() {
        Assert.assertEquals("ca", removeDuplicates("abbaca"));
    }

    @Test
    public void test2() {
        Assert.assertEquals("ca", removeDuplicates2("abbaca"));
    }

    @Test
    public void test3() {
        Assert.assertEquals("ay", removeDuplicates2("azxxzy"));
    }

    @Test
    public void test4() {
        Assert.assertEquals("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz", removeDuplicates2("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"));
    }

}
