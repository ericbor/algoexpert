package leetcode.easy.linkedlist;

import linkedlist.design.ListNode;
import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/delete-n-nodes-after-m-nodes-of-a-linked-list/
public class DeleteNNodesAfterMNodes {
    public ListNode deleteNodes(ListNode head, int m, int n) {

        ListNode prev = head;

        while (prev != null) {
            //move
            int moves = m - 1;
            while (prev != null && moves > 0) {
                prev = prev.next;
                moves--;
            }

            //delete
            ListNode nextTmp = prev;
            int deletes = n;
            while (nextTmp != null && deletes > 0) {
                nextTmp = nextTmp.next;
                deletes--;
            }

            prev.next = nextTmp.next;
            prev = prev.next;
        }

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
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next.next.next.next.next.next = new ListNode(11);
        head.next.next.next.next.next.next.next.next.next.next.next = new ListNode(12);
        head.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(13);

        ListNode result = deleteNodes(head, 2, 3);
        Assert.assertEquals(1, result.value);
        Assert.assertEquals(2, result.next.value);
        Assert.assertEquals(6, result.next.next.value);
        Assert.assertEquals(7, result.next.next.next.value);
        Assert.assertEquals(11, result.next.next.next.next.value);
        Assert.assertEquals(12, result.next.next.next.next.next.value);
        Assert.assertNull(result.next.next.next.next.next.next);
    }

    @Test
    public void test2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next.next.next.next.next.next = new ListNode(11);

        ListNode result = deleteNodes(head, 1, 3);
        Assert.assertEquals(1, result.value);
        Assert.assertEquals(5, result.next.value);
        Assert.assertEquals(9, result.next.next.value);
        Assert.assertNull(result.next.next.next);
    }
}
