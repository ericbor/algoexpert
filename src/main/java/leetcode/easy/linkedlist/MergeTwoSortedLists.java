package leetcode.easy.linkedlist;

import linkedlist.design.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode prev = new ListNode(Integer.MIN_VALUE);
        // maintain an unchanging reference to node ahead of the return node.
        ListNode curr = prev;

        while (l2 != null && l1 != null) {
            if(l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // At least one of l1 and l2 can still have nodes at this point, so connect the non-null list to the end of the merged list.
        prev.next = l1 != null ? l1 : l2;

        return curr.next;
    }

    @Test
    public void test() {
        ListNode l1 = new ListNode(-9);
        l1.next = new ListNode(-7);
        l1.next.next = new ListNode(-3);
        l1.next.next.next = new ListNode(-3);
        l1.next.next.next.next = new ListNode(-1);
        l1.next.next.next.next.next = new ListNode(2);
        l1.next.next.next.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(-7);
        l2.next = new ListNode(-7);
        l2.next.next = new ListNode(-6);
        l2.next.next.next = new ListNode(-6);
        l2.next.next.next.next = new ListNode(-5);
        l2.next.next.next.next.next = new ListNode(-3);
        l2.next.next.next.next.next.next = new ListNode(2);
        l2.next.next.next.next.next.next.next = new ListNode(4);

        ListNode result = mergeTwoLists(l1, l2);
        Assert.assertEquals(-9, result.val);
        Assert.assertEquals(-7, result.next.val);
        Assert.assertEquals(-7, result.next.next.val);
        Assert.assertEquals(-7, result.next.next.next.val);
        Assert.assertEquals(-6, result.next.next.next.next.val);
        Assert.assertEquals(-6, result.next.next.next.next.next.val);
        Assert.assertEquals(-5, result.next.next.next.next.next.next.val);
        Assert.assertEquals(-3, result.next.next.next.next.next.next.next.val);
        Assert.assertEquals(-3, result.next.next.next.next.next.next.next.next.val);
        Assert.assertEquals(-3, result.next.next.next.next.next.next.next.next.next.val);
        Assert.assertEquals(-1, result.next.next.next.next.next.next.next.next.next.next.val);
        Assert.assertEquals(2, result.next.next.next.next.next.next.next.next.next.next.next.val);
        Assert.assertEquals(2, result.next.next.next.next.next.next.next.next.next.next.next.next.val);
        Assert.assertEquals(3, result.next.next.next.next.next.next.next.next.next.next.next.next.next.val);
        Assert.assertEquals(4, result.next.next.next.next.next.next.next.next.next.next.next.next.next.next.val);
        Assert.assertNull(result.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next);
    }

    @Test
    public void test2() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode result = mergeTwoLists(l1, l2);
        Assert.assertEquals(1, result.val);
        Assert.assertEquals(1, result.next.val);
        Assert.assertEquals(2, result.next.next.val);
        Assert.assertEquals(3, result.next.next.next.val);
        Assert.assertEquals(4, result.next.next.next.next.val);
        Assert.assertEquals(4, result.next.next.next.next.next.val);
    }

    @Test
    public void test3() {
        ListNode l1 = null;
        ListNode l2 = new ListNode(0);

        ListNode result = mergeTwoLists(l1, l2);
        Assert.assertEquals(0, result.val);
        Assert.assertNull(result.next);
    }

    @Test
    public void test4() {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(4);

        ListNode result = mergeTwoLists(l1, l2);
        Assert.assertEquals(1, result.val);
        Assert.assertEquals(2, result.next.val);
        Assert.assertEquals(4, result.next.next.val);
        Assert.assertEquals(5, result.next.next.next.val);
        Assert.assertNull(result.next.next.next.next);
    }

    @Test
    public void test5() {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(1);

        ListNode result = mergeTwoLists(l1, l2);
        Assert.assertEquals(1, result.val);
        Assert.assertEquals(2, result.next.val);
        Assert.assertNull(result.next.next);
    }
}
