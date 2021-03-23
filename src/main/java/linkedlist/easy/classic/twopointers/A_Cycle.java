package linkedlist.easy.classic.twopointers;

import linkedlist.design.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class A_Cycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
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
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);

        Assert.assertFalse(hasCycle(head));
    }
}
