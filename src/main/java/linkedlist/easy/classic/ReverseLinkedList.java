package linkedlist.easy.classic;

import linkedlist.design.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/reverse-linked-list/
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode currentHead = head;
        while (head.next != null) {
            ListNode p = head.next;
            head.next = p.next;
            p.next = currentHead;
            currentHead = p;
        }

        return currentHead;
    }
//current:  [1-2-3-4-5-null][2-3-4-5-null][3-4-5-null][4-5-null]  [5-null]      [null]
//previous: [null]          [null-1]      [null-2-1]  [null-3-2-1][null-4-3-2-1][null-5-4-3-2-1]

    @Test
    public void verify() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = reverseList(head);
        assertEquals(5, result.value);
        assertEquals(4, result.next.value);
        assertEquals(3, result.next.next.value);
        assertEquals(2, result.next.next.next.value);
        assertEquals(1, result.next.next.next.next.value);
    }
}
