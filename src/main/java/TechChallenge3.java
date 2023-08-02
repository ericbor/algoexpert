import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
public class TechChallenge3 {
    public String solution(String S) {
        Deque<Character> stack = new ArrayDeque<>();

        for(char c: S.toCharArray()) {
            if(!stack.isEmpty() && canCombine(stack.peek(), c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }

    private boolean canCombine(char a, char b) {
        return (a == 'A' && b == 'B' || a == 'B' && b == 'A') || (a == 'C' && b == 'D' || a == 'D' && b == 'C');
    }

    @Test
    public void test3() {
        Assert.assertEquals("C", solution("CBACD"));
    }

    @Test
    public void test() {
        Assert.assertEquals("", solution("CABABD"));
    }

    @Test
    public void test2() {
        Assert.assertEquals("ACBDACBD", solution("ACBDACBD"));
    }
}
