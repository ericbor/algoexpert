package leetcode.linkedlist;

import linkedlist.design.ListNode;
import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = getSize(head);
        int moves = size - n;
        if(moves == 0) {
            head = head.next;
            return head;
        }

        ListNode curr = head;
        for(int i = 1; i < moves; i++) {
            curr = curr.next;
        }

        curr.next = curr.next.next;

        return head;
    }

    private int getSize(ListNode head) {
        ListNode curr = head;
        int size = 0;
        while(curr != null) {
            size++;
            curr = curr.next;
        }

        return size;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        ListNode removed = removeNthFromEnd(head, 2);
        Assert.assertEquals(2, removed.val);
        Assert.assertNull(removed.next);
    }

    @Test
    public void test2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode removed = removeNthFromEnd(head, 2);
        Assert.assertEquals(1, removed.val);
        Assert.assertEquals(2, removed.next.val);
        Assert.assertEquals(3, removed.next.next.val);
        Assert.assertEquals(5, removed.next.next.next.val);
        Assert.assertNull(removed.next.next.next.next);
    }
}
