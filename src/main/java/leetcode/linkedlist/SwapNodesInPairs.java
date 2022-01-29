package leetcode.linkedlist;

import linkedlist.design.ListNode;
import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/swap-nodes-in-pairs/
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode sentinel = new ListNode(Integer.MIN_VALUE);
        sentinel.next = head;

        ListNode pointer = sentinel;

        while (pointer != null) {
            ListNode node = pointer;
            for (int i = 0; i < 2 && node != null; i++) {
                node = node.next;
            }
            if (node == null) {
                break;
            }

            ListNode prev = null;
            ListNode curr = pointer.next;

            for (int i = 0; i < 2; i++) {
                ListNode nextTmp = curr.next;
                curr.next = prev;

                prev = curr;
                curr = nextTmp;
            }
            //connection
            ListNode tail = pointer.next;
            tail.next = curr;
            pointer.next = prev;
            //move
            pointer = tail;
        }

        return sentinel.next;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode reversed = swapPairs(head);
        Assert.assertEquals(2, reversed.val);
        Assert.assertEquals(1, reversed.next.val);
        Assert.assertEquals(4, reversed.next.next.val);
        Assert.assertEquals(3, reversed.next.next.next.val);
        Assert.assertNull(reversed.next.next.next.next);
    }

    @Test
    public void test2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode reversed = swapPairs(head);
        Assert.assertEquals(2, reversed.val);
        Assert.assertEquals(1, reversed.next.val);
        Assert.assertEquals(4, reversed.next.next.val);
        Assert.assertEquals(3, reversed.next.next.next.val);
        Assert.assertEquals(5, reversed.next.next.next.next.val);
        Assert.assertNull(reversed.next.next.next.next.next);
    }
}
