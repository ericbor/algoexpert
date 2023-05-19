package linkedlist.easy.classic;

import linkedlist.design.ListNode;
import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/reverse-linked-list/
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode before = null;
        ListNode curr = head;
        ListNode after = curr.next;

        while (curr != null) { // (b)null  (c)1 -> (a)2 -> 3  --- null<-(b)1  (a)(c)2 -> 3
            after = curr.next; // (b)null  (c)1 -> (a)2 -> 3 --- null<-(b)1  (c)2 -> (a)3
            curr.next = before; // (b)null<-(c)1  (a)2 -> 3  --- null<-(b)1<-(c)2 (a)3
            before = curr; // null<-(c)(b)1  (a)2 -> 3       --- null<-1<-(c)(b)2 (a)3
            curr = after; // null<-(b)1  (a)(c)2 -> 3        --- null<-1<-(b)2 (a)(c)3
        }

        return before;
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
        Assert.assertEquals(5, result.val);
        Assert.assertEquals(4, result.next.val);
        Assert.assertEquals(3, result.next.next.val);
        Assert.assertEquals(2, result.next.next.next.val);
        Assert.assertEquals(1, result.next.next.next.next.val);
    }
}
