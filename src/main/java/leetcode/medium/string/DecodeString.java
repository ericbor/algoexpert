package leetcode.medium.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/decode-string/
public class DecodeString {
    public String decodeString(String s) {
        Deque<Integer> count = new ArrayDeque<>();
        Deque<String> result = new ArrayDeque<>();
        int i = 0;
        result.push("");

        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                int start = i;
                while (s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
                    i++;
                }
                count.push(Integer.parseInt(s.substring(start, i + 1)));
            } else if (ch == '[') {
                result.push("");
            } else if (ch == ']') {
                String str = result.pop();
                StringBuilder sb = new StringBuilder();
                int times = count.pop();
                for (int j = 0; j < times; j += 1) {
                    sb.append(str);
                }
                result.push(result.pop() + sb);
            } else {
                result.push(result.pop() + ch);
            }
            i++;
        }

        return result.pop();
    }

    @Test
    public void test() {
        Assert.assertEquals("accaccacc", decodeString("3[a2[c]]"));
    }

    @Test
    public void test2() {
        Assert.assertEquals("abcabccdcdcdef", decodeString("2[abc]3[cd]ef"));
    }

    @Test
    public void test3() {
        Assert.assertEquals("aaabcbc", decodeString("3[a]2[bc]"));
    }
}
