package educative.fastslowpointers.easy;
/*
Given the head of a Singly LinkedList, write a function to determine if the LinkedList has a cycle in it or not.
 */

import linkedlist.design.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class LinkedListCycle {

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void verify() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        Assert.assertFalse(hasCycle(head));

        head.next.next.next.next.next.next = head.next.next;
        Assert.assertTrue(hasCycle(head));

        head.next.next.next.next.next.next = head.next.next.next;
        Assert.assertTrue(hasCycle(head));
    }
}
