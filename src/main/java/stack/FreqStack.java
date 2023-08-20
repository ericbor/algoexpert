package stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

//https://leetcode.com/problems/maximum-frequency-stack
public class FreqStack {
    private final Map<Integer, Integer> valToFreq;
    private final Map<Integer, Deque<Integer>> freqToVal;
    int maxfreq;

    public FreqStack() {
        valToFreq = new HashMap<>();
        freqToVal = new HashMap<>();
        maxfreq = 0;
    }

    public void push(int val) {
        int freq = valToFreq.getOrDefault(val, 0) + 1;
        valToFreq.put(val, freq);
        if (freq > maxfreq) {
            maxfreq = freq;
        }

        if(!freqToVal.containsKey(freq)) {
            freqToVal.put(freq, new ArrayDeque<>());
        }
        freqToVal.get(freq).push(val);
    }

    public int pop() {
        int val = freqToVal.get(maxfreq).pop();
        valToFreq.put(val, valToFreq.get(val) - 1);
        if (freqToVal.get(maxfreq).isEmpty()) {
            maxfreq--;
        }

        return val;
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
