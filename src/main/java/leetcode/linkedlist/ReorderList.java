package leetcode.linkedlist;

import linkedlist.design.ListNode;
import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/reorder-list/
public class ReorderList {
    public void reorderList2(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode secondHalfStart = getMiddle(head);
        ListNode reversed = reverse(secondHalfStart.next);

        ListNode p1 = head;
        ListNode p2 = reversed;
        //ListNode prev = new ListNode(Integer.MIN_VALUE);

        while (p2.next != null) {
            ListNode nextTmp = p1.next;
            p1.next = p2;
            p1 = nextTmp;

            nextTmp = p2.next;
            p2.next = p1;
            p2 = nextTmp;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode nextTmp = curr.next;
            curr.next = prev;

            prev = curr;
            curr = nextTmp;
        }

        return prev;
    }

    private ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode secondHalfStart = getMiddle(head);
        ListNode reversed = reverse(secondHalfStart);

        ListNode p1 = head;
        ListNode p2 = reversed;
        while (p2.next != null) {
            ListNode tmp = p1.next;
            p1.next = p2;
            p1 = tmp;

            tmp = p2.next;
            p2.next = p1;
            p2 = tmp;
        }
    }

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        reorderList(head);

        Assert.assertEquals(1, head.val);
        Assert.assertEquals(4, head.next.val);
        Assert.assertEquals(2, head.next.next.val);
        Assert.assertEquals(3, head.next.next.next.val);
        Assert.assertNull(head.next.next.next.next);
    }

    @Test
    public void test2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        reorderList(head);

        Assert.assertEquals(1, head.val);
        Assert.assertEquals(5, head.next.val);
        Assert.assertEquals(2, head.next.next.val);
        Assert.assertEquals(4, head.next.next.next.val);
        Assert.assertEquals(3, head.next.next.next.next.val);
        Assert.assertNull(head.next.next.next.next.next);
    }
}
