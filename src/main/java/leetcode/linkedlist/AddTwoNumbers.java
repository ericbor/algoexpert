package leetcode.linkedlist;

import linkedlist.design.ListNode;
import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/add-two-numbers/
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(0);
        ListNode curr = sentinel;

        int reminder = 0;
        while(l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;

            int sum = reminder + x + y;
            reminder = sum / 10;
            int val = sum % 10;

            curr.next = new ListNode(val);
            curr = curr.next;

            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }

        if(reminder > 0) {
            curr.next = new ListNode(reminder);
        }

        return sentinel.next;
    }

    @Test
    public void test() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode node = addTwoNumbers(l1, l2);
        Assert.assertEquals(7, node.val);
        Assert.assertEquals(0, node.next.val);
        Assert.assertEquals(8, node.next.next.val);
        Assert.assertNull(node.next.next.next);
    }

    @Test
    public void test2() {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);

        ListNode node = addTwoNumbers(l1, l2);
        Assert.assertEquals(8, node.val);
        Assert.assertEquals(9, node.next.val);
        Assert.assertEquals(9, node.next.next.val);
        Assert.assertEquals(9, node.next.next.next.val);
        Assert.assertEquals(0, node.next.next.next.next.val);
        Assert.assertEquals(0, node.next.next.next.next.next.val);
        Assert.assertEquals(0, node.next.next.next.next.next.next.val);
        Assert.assertEquals(1, node.next.next.next.next.next.next.next.val);
        Assert.assertNull(node.next.next.next.next.next.next.next.next);
    }
}
