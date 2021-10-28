package leetcode.easy.linkedlist;

import linkedlist.design.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode result = new ListNode();
        ListNode curr = result;

        while (l2 != null || l1 != null) {

            if (l1 != null && l2 != null) {
                if (l1.value <= l2.value) {
                    result.next = new ListNode(l1.value);
                    l1 = l1.next;
                } else if (l2 != null) {
                    result.next = new ListNode(l2.value);
                    l2 = l2.next;
                }
            } else if (l1 == null && l2 != null) {
                result.next = new ListNode(l2.value);
                l2 = l2.next;
            } else if (l1 != null && l2 == null) {
                result.next = new ListNode(l1.value);
                l1 = l1.next;
            }

            result = result.next;
        }

        return curr.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {

        ListNode prev = new ListNode();
        // maintain an unchanging reference to node ahead of the return node.
        ListNode curr = prev;

        while (l2 != null && l1 != null) {
            if(l1.value <= l2.value) {
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
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(1);

        ListNode result = mergeTwoLists(l1, l2);
        Assert.assertEquals(1, result.value);
        Assert.assertEquals(2, result.next.value);
        Assert.assertNull(result.next.next);
    }

    @Test
    public void test_2() {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(1);

        ListNode result = mergeTwoLists2(l1, l2);
        Assert.assertEquals(1, result.value);
        Assert.assertEquals(2, result.next.value);
        Assert.assertNull(result.next.next);
    }

    @Test
    public void test3() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode result = mergeTwoLists(l1, l2);
        Assert.assertEquals(1, result.value);
        Assert.assertEquals(1, result.next.value);
        Assert.assertEquals(2, result.next.next.value);
        Assert.assertEquals(3, result.next.next.next.value);
        Assert.assertEquals(4, result.next.next.next.next.value);
        Assert.assertEquals(4, result.next.next.next.next.next.value);
    }

    @Test
    public void test3_2() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode result = mergeTwoLists2(l1, l2);
        Assert.assertEquals(1, result.value);
        Assert.assertEquals(1, result.next.value);
        Assert.assertEquals(2, result.next.next.value);
        Assert.assertEquals(3, result.next.next.next.value);
        Assert.assertEquals(4, result.next.next.next.next.value);
        Assert.assertEquals(4, result.next.next.next.next.next.value);
    }

    @Test
    public void test2() {
        ListNode l1 = null;
        ListNode l2 = new ListNode(0);

        ListNode result = mergeTwoLists(l1, l2);
        Assert.assertEquals(0, result.value);
        Assert.assertNull(result.next);
    }

    @Test
    public void test2_2() {
        ListNode l1 = null;
        ListNode l2 = new ListNode(0);

        ListNode result = mergeTwoLists2(l1, l2);
        Assert.assertEquals(0, result.value);
        Assert.assertNull(result.next);
    }

    @Test
    public void test4() {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(4);

        ListNode result = mergeTwoLists(l1, l2);
        Assert.assertEquals(1, result.value);
        Assert.assertEquals(2, result.next.value);
        Assert.assertEquals(4, result.next.next.value);
        Assert.assertEquals(5, result.next.next.next.value);
        Assert.assertNull(result.next.next.next.next);
    }

    @Test
    public void test4_2() {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(4);

        ListNode result = mergeTwoLists2(l1, l2);
        Assert.assertEquals(1, result.value);
        Assert.assertEquals(2, result.next.value);
        Assert.assertEquals(4, result.next.next.value);
        Assert.assertEquals(5, result.next.next.next.value);
        Assert.assertNull(result.next.next.next.next);
    }
}
