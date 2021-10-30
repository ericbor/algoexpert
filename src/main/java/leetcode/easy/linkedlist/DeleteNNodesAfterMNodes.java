package leetcode.easy.linkedlist;

import linkedlist.design.ListNode;
import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/delete-n-nodes-after-m-nodes-of-a-linked-list/
public class DeleteNNodesAfterMNodes {
    public ListNode deleteNodes(ListNode head, int m, int n) {

        ListNode lastMNode = head;

        while (lastMNode != null && lastMNode.next != null) {
            //move
            int moves = m - 1;
            while (lastMNode != null && moves > 0) {
                lastMNode = lastMNode.next;
                moves--;
            }

            if (lastMNode == null || lastMNode.next == null) {
                break;
            }

            //delete
            ListNode curr = lastMNode.next;
            int deletes = n;
            while (curr != null && deletes > 0) {
                curr = curr.next;
                deletes--;
            }

            lastMNode.next = curr;
            lastMNode = lastMNode.next;
        }

        return head;
    }

    public ListNode deleteNodes2(ListNode head, int m, int n) {
        ListNode curr = head;
        ListNode lastMNode = head;
        while (curr != null) {
            // initialize mCount to m and nCount to n
            int mCount = m;
            // traverse m nodes
            while (curr != null && mCount > 0) {
                lastMNode = curr;
                curr = curr.next;
                mCount--;
            }

            // traverse n nodes
            int nCount = n;
            while (curr != null && nCount > 0) {
                curr = curr.next;
                nCount--;
            }
            // delete n nodes
            lastMNode.next = curr;
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

    @Test
    public void test3() {
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

        ListNode result = deleteNodes(head, 3, 1);
        Assert.assertEquals(1, result.value);
        Assert.assertEquals(2, result.next.value);
        Assert.assertEquals(3, result.next.next.value);
        Assert.assertEquals(5, result.next.next.next.value);
        Assert.assertEquals(6, result.next.next.next.next.value);
        Assert.assertEquals(7, result.next.next.next.next.next.value);
        Assert.assertEquals(9, result.next.next.next.next.next.next.value);
        Assert.assertEquals(10, result.next.next.next.next.next.next.next.value);
        Assert.assertEquals(11, result.next.next.next.next.next.next.next.next.value);
        Assert.assertNull(result.next.next.next.next.next.next.next.next.next);
    }

    @Test
    public void test4() {
        ListNode head = new ListNode(9);
        head.next = new ListNode(3);
        head.next.next = new ListNode(7);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next = new ListNode(2);

        ListNode result = deleteNodes(head, 1, 2);
        Assert.assertEquals(9, result.value);
        Assert.assertEquals(7, result.next.value);
        Assert.assertEquals(8, result.next.next.value);
        Assert.assertNull(result.next.next.next);
    }

    @Test
    public void test5() {
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

        ListNode result = deleteNodes(head, 2, 1);
        Assert.assertEquals(1, result.value);
        Assert.assertEquals(2, result.next.value);
        Assert.assertEquals(4, result.next.next.value);
        Assert.assertEquals(5, result.next.next.next.value);
        Assert.assertEquals(7, result.next.next.next.next.value);
        Assert.assertEquals(8, result.next.next.next.next.next.value);
        Assert.assertEquals(10, result.next.next.next.next.next.next.value);
        Assert.assertNull(result.next.next.next.next.next.next.next);
    }

    @Test
    public void test6() {
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

        ListNode result = deleteNodes(head, 3, 5);
        Assert.assertEquals(1, result.value);
        Assert.assertEquals(2, result.next.value);
        Assert.assertEquals(3, result.next.next.value);
        Assert.assertEquals(9, result.next.next.next.value);
        Assert.assertEquals(10, result.next.next.next.next.value);
        Assert.assertNull(result.next.next.next.next.next);
    }

    @Test
    public void test7() {
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

        ListNode result = deleteNodes2(head, 3, 5);
        Assert.assertEquals(1, result.value);
        Assert.assertEquals(2, result.next.value);
        Assert.assertEquals(3, result.next.next.value);
        Assert.assertEquals(9, result.next.next.next.value);
        Assert.assertEquals(10, result.next.next.next.next.value);
        Assert.assertNull(result.next.next.next.next.next);
    }

    @Test
    public void test8() {
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

        ListNode result = deleteNodes2(head, 2, 3);
        Assert.assertEquals(1, result.value);
        Assert.assertEquals(2, result.next.value);
        Assert.assertEquals(6, result.next.next.value);
        Assert.assertEquals(7, result.next.next.next.value);
        Assert.assertEquals(11, result.next.next.next.next.value);
        Assert.assertEquals(12, result.next.next.next.next.next.value);
        Assert.assertNull(result.next.next.next.next.next.next);
    }
}
