package educative.linkedlist.reversal.medium;

import linkedlist.design.ListNode;
import org.junit.Assert;
import org.junit.Test;

//https://www.educative.io/courses/grokking-the-coding-interview/q2lZKgLm980
public class ReverseAlternatingKElements {

    public static ListNode reverse(ListNode head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }

        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {// break if we've reached the end of the list
            ListNode con = prev;
            ListNode tail = curr;
            int j = k;
            while (j > 0 && curr != null) {
                ListNode nextTmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextTmp;
                j--;
            }

            // connect with the previous part
            if (con != null) {
                con.next = prev;
            } else {
                head = prev;
            }
            // connect with the next part
            tail.next = curr;

            int i = k;
            while (i > 0 && curr != null) {
                prev = curr;
                curr = curr.next;
                i--;
            }
        }

        return head;
    }

    @Test
    public void verify() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        ListNode result = reverse(head, 2);
        Assert.assertEquals(2, result.value);
        Assert.assertEquals(1, result.next.value);
        Assert.assertEquals(3, result.next.next.value);
        Assert.assertEquals(4, result.next.next.next.value);
        Assert.assertEquals(6, result.next.next.next.next.value);
        Assert.assertEquals(5, result.next.next.next.next.next.value);
        Assert.assertEquals(7, result.next.next.next.next.next.next.value);
        Assert.assertEquals(8, result.next.next.next.next.next.next.next.value);
        Assert.assertNull(result.next.next.next.next.next.next.next.next);
    }
}
