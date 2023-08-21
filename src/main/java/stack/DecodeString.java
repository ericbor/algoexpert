package stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/decode-string
public class DecodeString {
    public String decodeString(String s) {

        Deque<Character> stack = new ArrayDeque<>();

        for(char c : s.toCharArray())
        {
            if(c != ']') {
                stack.push(c); //push everything but ]
            } else {
                //step 1: if you find a closing ] then retrieve the string it encapsulates
                StringBuilder sb = new StringBuilder();
                while(!stack.isEmpty() && Character.isLetter(stack.peek())) {
                    sb.insert(0, stack.pop());
                }

                String sub = sb.toString(); //this is the string contained in [ ]
                stack.pop(); //Discard the '[';

                //step 2: after that get the number of times it should repeat from stack
                sb.setLength(0);
                while(!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    sb.insert(0, stack.pop());
                }
                int count = Integer.parseInt(sb.toString()); //this is the number


                //step 3: repeat the string within the [ ] count number of times and push it back into stack
                while(count > 0) {
                    for(char ch : sub.toCharArray()) {
                        stack.push(ch);
                    }
                    count--;
                }
            }
        }

        //final fetching and returning the value in stack
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }

        return result.toString();
    }

    @Test
    public void test2() {
        Assert.assertEquals("abcabccdcdcdef", decodeString("2[abc]3[cd]ef"));
    }

    @Test
    public void test() {
        Assert.assertEquals("accaccacc", decodeString("3[a2[c]]"));
    }
}
