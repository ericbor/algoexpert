package leetcode.linkedlist;

import linkedlist.design.ListNode;
import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/odd-even-linked-list/
public class OddEvenLinkedList {
    public ListNode oddEvenList_2(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode evenHead = head.next;
        ListNode even = evenHead;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            // Put odd to the odd list
            odd.next = odd.next.next;

            // Put even to the even list
            even.next = even.next.next;

            // Move the pointer to the next odd/even
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        ListNode sorted = oddEvenList(head);
        Assert.assertEquals(1, sorted.val);
        Assert.assertEquals(3, sorted.next.val);
        Assert.assertEquals(5, sorted.next.next.val);
        Assert.assertEquals(7, sorted.next.next.next.val);
        Assert.assertEquals(2, sorted.next.next.next.next.val);
        Assert.assertEquals(4, sorted.next.next.next.next.next.val);
        Assert.assertEquals(6, sorted.next.next.next.next.next.next.val);
        Assert.assertEquals(8, sorted.next.next.next.next.next.next.next.val);
        Assert.assertNull(sorted.next.next.next.next.next.next.next.next);
    }

    @Test
    public void test3() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode sorted = oddEvenList(head);
        Assert.assertEquals(1, sorted.val);
        Assert.assertEquals(3, sorted.next.val);
        Assert.assertEquals(5, sorted.next.next.val);
        Assert.assertEquals(2, sorted.next.next.next.val);
        Assert.assertEquals(4, sorted.next.next.next.next.val);
        Assert.assertNull(sorted.next.next.next.next.next);
    }

    @Test
    public void test2() {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(7);

        ListNode sorted = oddEvenList(head);
        Assert.assertEquals(2, sorted.val);
        Assert.assertEquals(3, sorted.next.val);
        Assert.assertEquals(6, sorted.next.next.val);
        Assert.assertEquals(7, sorted.next.next.next.val);
        Assert.assertEquals(1, sorted.next.next.next.next.val);
        Assert.assertEquals(5, sorted.next.next.next.next.next.val);
        Assert.assertEquals(4, sorted.next.next.next.next.next.next.val);
        Assert.assertNull(sorted.next.next.next.next.next.next.next);
    }
}
