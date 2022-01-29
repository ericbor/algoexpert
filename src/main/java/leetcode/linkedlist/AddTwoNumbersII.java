package leetcode.linkedlist;

import linkedlist.design.ListNode;
import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/add-two-numbers-ii/
public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode r1 = reverse(l1);
        ListNode r2 = reverse(l2);

        ListNode head = null;

        int carry = 0;
        while(r1 != null || r2 != null) {
            int x = r1 != null ? r1.val : 0;
            int y = r2 != null ? r2.val : 0;

            int sum = carry + x + y;
            carry = sum / 10;
            int val = sum % 10;

            ListNode curr  = new ListNode(val);
            curr.next = head;
            head = curr;

            if(r1 != null) {
                r1 = r1.next;
            }
            if(r2 != null) {
                r2 = r2.next;
            }
        }

        if(carry > 0) {
            ListNode curr  = new ListNode(carry);
            curr.next = head;
            head = curr;
        }

        return head;
    }

    private ListNode reverse(ListNode node) {
        ListNode curr = node;
        ListNode prev = null;

        while(curr != null) {
            ListNode nextTmp = curr.next;
            curr.next = prev;

            prev = curr;
            curr = nextTmp;
        }

        return prev;
    }

    @Test
    public void test() {
        ListNode l1 = new ListNode(5);

        ListNode l2 = new ListNode(5);

        ListNode node = addTwoNumbers(l1, l2);
        Assert.assertEquals(1, node.val);
        Assert.assertEquals(0, node.next.val);
        Assert.assertNull(node.next.next);
    }

    @Test
    public void test2() {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode node = addTwoNumbers(l1, l2);
        Assert.assertEquals(7, node.val);
        Assert.assertEquals(8, node.next.val);
        Assert.assertEquals(0, node.next.next.val);
        Assert.assertEquals(7, node.next.next.next.val);
        Assert.assertNull(node.next.next.next.next);
    }
}
