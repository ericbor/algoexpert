package linkedlist.easy.classic;

import linkedlist.design.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/remove-linked-list-elements/
public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode previous = dummy;
        ListNode current = head;
        while (current != null) {
            if (current.val == val) {
                previous.next = current.next;
            } else {
                previous = current;
            }
            current = current.next;
        }

        return dummy.next;
    }

    @Test
    public void verify() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);

        ListNode result = removeElements(head, 2);
        assertEquals(1, result.val);
        assertEquals(3, result.next.val);
        assertEquals(5, result.next.next.val);
    }
}
