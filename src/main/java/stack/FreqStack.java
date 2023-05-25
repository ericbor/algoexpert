package stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

//https://leetcode.com/problems/maximum-frequency-stack
public class FreqStack {
    Map<Integer, Integer> freq;
    Map<Integer, Deque<Integer>> group;
    int maxfreq;

    public FreqStack() {
        freq = new HashMap();
        group = new HashMap();
        maxfreq = 0;
    }

    public void push(int x) {
        int f = freq.getOrDefault(x, 0) + 1;
        freq.put(x, f);
        if (f > maxfreq) {
            maxfreq = f;
        }

        if(!group.containsKey(f)) {
            group.put(f, new ArrayDeque<>());
        }
        group.get(f).push(x);
    }

    public int pop() {
        int x = group.get(maxfreq).pop();
        freq.put(x, freq.get(x) - 1);
        if (group.get(maxfreq).isEmpty()) {
            maxfreq--;
        }
        return x;
    }

    @Test
    public void test() {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5); // The stack is [5]
        freqStack.push(7); // The stack is [5,7]
        freqStack.push(5); // The stack is [5,7,5]
        freqStack.push(7); // The stack is [5,7,5,7]
        freqStack.push(4); // The stack is [5,7,5,7,4]
        freqStack.push(5); // The stack is [5,7,5,7,4,5]
        Assert.assertEquals(5, freqStack.pop());
        Assert.assertEquals(7, freqStack.pop());
        Assert.assertEquals(5, freqStack.pop());
        Assert.assertEquals(4, freqStack.pop());
    }
}
