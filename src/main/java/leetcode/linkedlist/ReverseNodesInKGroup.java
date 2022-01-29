package leetcode.linkedlist;

import linkedlist.design.ListNode;
import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/reverse-nodes-in-k-group/
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode sentinel = new ListNode(Integer.MIN_VALUE);
        sentinel.next = head;

        ListNode pointer = sentinel;
        while (pointer != null) {
            ListNode node = pointer;
            // first check whether there are k nodes to reverse
            for (int i = 0; i < k && node != null; i++) {
                node = node.next;
            }
            if (node == null) {
                break;
            }

            // now we know that we have k nodes, we will start from the first node
            ListNode prev = null;
            ListNode curr = pointer.next;

            for (int i = 0; i < k; i++) {
                ListNode nextTmp = curr.next;
                curr.next = prev;

                prev = curr;
                curr = nextTmp;
            }
            //connection
            ListNode tail = pointer.next;
            tail.next = curr;
            //move
            pointer.next = prev;//so, sentinel now has a correct order
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
        head.next.next.next.next = new ListNode(5);

        ListNode reversed = reverseKGroup(head, 2);
        Assert.assertEquals(2, reversed.val);
        Assert.assertEquals(1, reversed.next.val);
        Assert.assertEquals(4, reversed.next.next.val);
        Assert.assertEquals(3, reversed.next.next.next.val);
        Assert.assertEquals(5, reversed.next.next.next.next.val);
    }

    @Test
    public void test2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode reversed = reverseKGroup(head, 3);
        Assert.assertEquals(3, reversed.val);
        Assert.assertEquals(2, reversed.next.val);
        Assert.assertEquals(1, reversed.next.next.val);
        Assert.assertEquals(4, reversed.next.next.next.val);
        Assert.assertEquals(5, reversed.next.next.next.next.val);
    }
}
