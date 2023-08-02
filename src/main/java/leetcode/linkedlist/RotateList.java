package leetcode.linkedlist;

import linkedlist.design.ListNode;
import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/rotate-list/
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) {
            return null;
        }
        if(head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        int size = 0;
        while (fast.next != null) {   // fast REACH tail && Count size
            fast = fast.next;
            size++;
        }

        int rotates = k % size;
        for (int i = 0; i < size - rotates; i++) {
            // slow REACH before the rotated point
            slow = slow.next;
        }

        // CONNECT
        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;

        return dummy.next;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);

        ListNode rotated = rotateRight(head, 2000000000);
        Assert.assertEquals(1, rotated.val);
        Assert.assertEquals(2, rotated.next.val);
        Assert.assertEquals(0, rotated.next.next.val);
        Assert.assertNull(rotated.next.next.next);
    }

    @Test
    public void test3() {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);

        ListNode rotated = rotateRight(head, 4);
        Assert.assertEquals(2, rotated.val);
        Assert.assertEquals(0, rotated.next.val);
        Assert.assertEquals(1, rotated.next.next.val);
        Assert.assertNull(rotated.next.next.next);
    }

    @Test
    public void test2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode rotated = rotateRight(head, 2);
        Assert.assertEquals(4, rotated.val);
        Assert.assertEquals(5, rotated.next.val);
        Assert.assertEquals(1, rotated.next.next.val);
        Assert.assertEquals(2, rotated.next.next.next.val);
        Assert.assertEquals(3, rotated.next.next.next.next.val);
        Assert.assertNull(rotated.next.next.next.next.next);
    }
}
