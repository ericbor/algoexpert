package educative.linkedlist.reversal.easy;

import linkedlist.design.ListNode;
import org.junit.Assert;
import org.junit.Test;

/*
Given the head of a Singly LinkedList, reverse the LinkedList.
Write a function to return the new head of the reversed LinkedList.
 */
public class ReverseLinkedList {
    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            //stash pointer to next
            ListNode nextTmp = curr.next;
            //reverse
            curr.next = prev;
            //move
            prev = curr;
            curr = nextTmp;
        }
        return prev; //new head to end
    }

    @Test
    public void verify() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = reverse(head);
        Assert.assertEquals(5, result.value);
        Assert.assertEquals(4, result.next.value);
        Assert.assertEquals(3, result.next.next.value);
        Assert.assertEquals(2, result.next.next.next.value);
        Assert.assertEquals(1, result.next.next.next.next.value);
        Assert.assertNull(result.next.next.next.next.next);
    }
}
