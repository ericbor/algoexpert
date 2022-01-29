package educative.linkedlist.reversal.medium;

import linkedlist.design.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class ReverseEveryKElements {
    public static ListNode reverse(ListNode head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }

        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {// break if we've reached the end of the list
            ListNode connection = prev;
            // after reversing the LinkedList 'current' will become the last node of the sub-list
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
            if (connection != null) {
                connection.next = prev; // 'previous' is now the first node of the sub-list
            } else { // this means we are changing the first node (head) of the LinkedList
                head = prev;
            }
            // connect with the next part
            tail.next = curr;

            // prepare for the next sub-list
            prev = tail;
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

        ListNode result = reverse(head, 3);
        Assert.assertEquals(3, result.val);
        Assert.assertEquals(2, result.next.val);
        Assert.assertEquals(1, result.next.next.val);
        Assert.assertEquals(6, result.next.next.next.val);
        Assert.assertEquals(5, result.next.next.next.next.val);
        Assert.assertEquals(4, result.next.next.next.next.next.val);
        Assert.assertEquals(8, result.next.next.next.next.next.next.val);
        Assert.assertEquals(7, result.next.next.next.next.next.next.next.val);
        Assert.assertNull(result.next.next.next.next.next.next.next.next);
    }
}
