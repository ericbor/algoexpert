package leetcode.easy.design;

import org.junit.Assert;

import java.util.Stack;

//https://leetcode.com/problems/implement-queue-using-stacks
public class MyQueue {
    private final Stack<Integer> s1 = new Stack<>();
    private final Stack<Integer> s2 = new Stack<>();
    private int front;

    public MyQueue() {
    }

    public void push(int x) {
        if (s1.empty()) {
            front = x;
        }
        s1.push(x);
    }

    public int pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        return s2.pop();
    }

    public int peek() {
        if (!s2.isEmpty()) {
            return s2.peek();
        }
        return front;
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        Assert.assertEquals(1, myQueue.peek());
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        Assert.assertEquals(1, myQueue.peek());
        Assert.assertEquals(1, myQueue.pop()); // return 1, queue is [2]
        Assert.assertEquals(2, myQueue.peek());

        myQueue.push(3); // queue is: [2,3]
        Assert.assertEquals(2, myQueue.peek());
        myQueue.push(4); // queue is: [2,3,4] (leftmost is front of the queue)
        Assert.assertEquals(2, myQueue.peek());
        Assert.assertEquals(2, myQueue.pop()); // return 2, queue is [3,4]
        Assert.assertEquals(3, myQueue.peek());
        Assert.assertFalse(myQueue.empty());
    }
}
