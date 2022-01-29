package linkedlist.easy.classic.twopointers;

import linkedlist.design.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class D_RemoveFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = head;
        int listLength = 0;

        //calculate list length
        while (first != null) {
            listLength++;
            first = first.next;
        }

        //(L - n)
        int deleteIndex = listLength - n;
        //First is currently at the end of list, start over
        first = dummy;
        for (int i = 0; i < deleteIndex; i++) {
            first = first.next;
        }
        //delete node - reassign to (L - n + 2)
        first.next = first.next.next;

        //instead of returning `head` - in case when deleting single element, e.g. [1]
        return dummy.next;
    }

    public ListNode removeNthFromEnd_OnePass(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return dummy.next;
    }

    @Test
    public void verify() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = removeNthFromEnd(head, 2);
        assertEquals(1, result.val);
        assertEquals(2, result.next.val);
        assertEquals(3, result.next.next.val);
        assertEquals(5, result.next.next.next.val);
    }

    @Test
    public void verifyOnePass() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode resultOnePass = removeNthFromEnd_OnePass(head, 2);
        assertEquals(1, resultOnePass.val);
        assertEquals(2, resultOnePass.next.val);
        assertEquals(3, resultOnePass.next.next.val);
        assertEquals(5, resultOnePass.next.next.next.val);
    }
}
