package educative.fastslowpointers.easy;

import linkedlist.design.ListNode;
import org.junit.Assert;
import org.junit.Test;

/*
Given the head of a LinkedList with a cycle, find the length of the cycle.

Solution: Once the fast and slow pointers meet, we can save the slow pointer
and iterate the whole cycle with another pointer until we see the slow pointer again to find the length of the cycle.
 */
public class LinkedListCycleLength {
    public static int findCycleLength(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return calculateLength(slow);
            }
        }

        return 0;
    }

    private static int calculateLength(ListNode slow) {
        ListNode current = slow;
        int cycleLength = 0;
        do {
            current = current.next;
            cycleLength++;
        } while (current != slow);

        return cycleLength;
    }

    @Test
    public void verify() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head.next.next.next.next.next.next = head.next.next;
        Assert.assertEquals(4, findCycleLength(head));

        head.next.next.next.next.next.next = head.next.next.next;
        Assert.assertEquals(3, findCycleLength(head));
    }
}
