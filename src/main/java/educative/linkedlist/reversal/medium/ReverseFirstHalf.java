package educative.linkedlist.reversal.medium;

import linkedlist.design.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class ReverseFirstHalf {

    public static ListNode reverse(ListNode head, int end) {
        // Empty list
        if (head == null) {
            return null;
        }

        // Move the two pointers until they reach the proper starting point in the list.
        ListNode cur = head;
        ListNode prev = null;

        // The two pointers that will fix the final connections.
        //ListNode con = prev; //
        ListNode tail = cur;// 1(tail) -> 2 -> 3 -> 4 -> 5 -> null

        // Iteratively reverse the nodes until n becomes 0.
        while (end > 0) {
            ListNode nextTmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextTmp;
            end--;
        }

        // con is always null
        /*if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }*/
        head = prev;
        tail.next = cur;
        return head;
    }

    @Test
    public void verify() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = reverse(head,  3);
        Assert.assertEquals(3, result.value);
        Assert.assertEquals(2, result.next.value);
        Assert.assertEquals(1, result.next.next.value);
        Assert.assertEquals(4, result.next.next.next.value);
        Assert.assertEquals(5, result.next.next.next.next.value);
        Assert.assertNull(result.next.next.next.next.next);
    }
}
