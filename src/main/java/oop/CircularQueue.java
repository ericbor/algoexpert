package oop;

import org.junit.Test;

public class CircularQueue {
    private final int[] queue;
    private int index;
    private int readIndex;
    public CircularQueue(int k) {
        this.queue = new int[k];
        this.index = 0;
        this.readIndex = 0;
    }

    public int front() {
        int val = queue[index];
        index = (index + 1) & queue.length;

        return val;
    }

    public int rear() {
        return queue[0];
    }

    public void enqueue(int val) {
        queue[index] = val;
        index = (index + 1) % queue.length;
    }


    //@Test
    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(5);
        cq.enqueue(1);
        cq.enqueue(2);
        cq.enqueue(3);
        cq.enqueue(4);
        cq.enqueue(5);
        cq.enqueue(6);
    }
}
