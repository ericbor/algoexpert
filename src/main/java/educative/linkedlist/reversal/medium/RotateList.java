package educative.linkedlist.reversal.medium;

import linkedlist.design.ListNode;
import org.junit.Assert;
import org.junit.Test;

//https://www.educative.io/courses/grokking-the-coding-interview/mErolRNQ00R
public class RotateList {
    public static ListNode rotate(ListNode head, int rotations) {
        if (head == null || head.next == null || rotations <= 0) {
            return head;
        }

        // find the length and the last node of the list
        ListNode oldTail = head;
        int listLength = 1;
        while (oldTail.next != null) {
            oldTail = oldTail.next;
            listLength++;
        }

        oldTail.next = head;// connect the last node with the head to make it a circular list
        rotations %= listLength;// no need to do rotations more than the length of the list
        int skipLength = listLength - rotations;

        ListNode newTail = head;
        while (skipLength > 1) {
            newTail = newTail.next;
            skipLength--;
        }

        head = newTail.next;
        // break the circle
        newTail.next = null;

        return head;
    }

    @Test
    public void verify() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode result = rotate(head, 3);
        Assert.assertEquals(4, result.val);
        Assert.assertEquals(5, result.next.val);
        Assert.assertEquals(6, result.next.next.val);
        Assert.assertEquals(1, result.next.next.next.val);
        Assert.assertEquals(2, result.next.next.next.next.val);
        Assert.assertEquals(3, result.next.next.next.next.next.val);
        Assert.assertNull(result.next.next.next.next.next.next);
    }

    @Test
    public void verify2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = rotate(head, 8);
        Assert.assertEquals(3, result.val);
        Assert.assertEquals(4, result.next.val);
        Assert.assertEquals(5, result.next.next.val);
        Assert.assertEquals(1, result.next.next.next.val);
        Assert.assertEquals(2, result.next.next.next.next.val);
        Assert.assertNull(result.next.next.next.next.next);
    }
}
