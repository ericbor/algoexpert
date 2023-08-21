package other;

import linkedlist.design.ListNode;
import org.junit.Assert;


//https://leetcode.com/problems/design-circular-queue
public class CircularQueue {
    private final int size;
    private int currSize;
    private ListNode head;
    private ListNode tail;

    public CircularQueue(int k) {
        this.size = k;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        currSize++;
        ListNode node = new ListNode(value);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = tail.next;
        }

        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (tail == head) {
            head = head.next;
            tail = tail.next;
        } else {
            head = head.next;
        }

        currSize--;
        return true;
    }

    public int front() {
        return head != null ? head.val : -1;
    }

    public int rear() {
        return tail != null ? tail.val : -1;
    }

    public boolean isEmpty() {
        return currSize == 0;
    }

    public boolean isFull() {
        return size == currSize;
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(3);
        Assert.assertTrue(queue.enQueue(1));
        Assert.assertTrue(queue.enQueue(2));
        Assert.assertTrue(queue.enQueue(3));
        Assert.assertFalse(queue.enQueue(4));

        Assert.assertEquals(3, queue.rear());
        Assert.assertEquals(1, queue.front());
        Assert.assertTrue(queue.isFull());
        Assert.assertTrue(queue.deQueue());
        Assert.assertEquals(3, queue.rear());
        Assert.assertEquals(2, queue.front());
        Assert.assertFalse(queue.isFull());

        Assert.assertTrue(queue.deQueue());
        Assert.assertEquals(3, queue.rear());
        Assert.assertEquals(3, queue.front());
        Assert.assertFalse(queue.isEmpty());

        Assert.assertTrue(queue.deQueue());
        Assert.assertEquals(-1, queue.rear());
        Assert.assertEquals(-1, queue.front());
        Assert.assertTrue(queue.isEmpty());
    }
}
