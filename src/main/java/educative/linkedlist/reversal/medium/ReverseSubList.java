package educative.linkedlist.reversal.medium;

import linkedlist.design.ListNode;
import org.junit.Assert;
import org.junit.Test;

//https://www.educative.io/courses/grokking-the-coding-interview/qVANqMonoB2
public class ReverseSubList {
    public static ListNode reverse(ListNode head, int p, int q) {
        if (p == q) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        // after skipping 'p-1' nodes, current will point to 'p'th node
        for (int i = 0; i < p - 1 && curr != null; i++) {
            prev = curr;
            curr = curr.next;
        }
        // we are interested in three parts of the LinkedList:
        // part before index 'p',
        // part between 'p' and 'q'
        // part after index 'q'
        ListNode lastNodeOfFirstPart = prev; // points to the node at index 'p-1'
        ListNode lastNodeOfSubList = curr; // after reversing the LinkedList 'current' will become the last node of the sub-list

        // reverse nodes between 'p' and 'q'
        for (int i = 0; i < q - p + 1 && curr != null; i++) {
            ListNode nextTmp = curr.next;
            curr.next = prev;
            //move
            prev = curr;
            curr = nextTmp;
        }

        // connect with the first part
        if (lastNodeOfFirstPart != null) {
            lastNodeOfFirstPart.next = prev;
        } else {
            head = prev;
        }

        // connect with the last part
        lastNodeOfSubList.next = curr;

        return head;
    }

    public static ListNode reverse2(ListNode head, int start, int end) {
        // Empty list
        if (head == null) {
            return null;
        }

        // Move the two pointers until they reach the proper starting point in the list.
        ListNode cur = head;
        ListNode prev = null;
        while (start > 1) {
            prev = cur;
            cur = cur.next;
            start--;
            end--;
        }

        // The two pointers that will fix the final connections.
        ListNode con = prev; // 1(con)-> 2 -> 3 -> 4 -> 5 -> null
        ListNode tail = cur;// 1 -> 2(tail) -> 3 -> 4 -> 5 -> null

        // Iteratively reverse the nodes until n becomes 0.
        while (end > 0) {
            ListNode nextTmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextTmp;
            end--;
        }

        // connect with the previous part
        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }
        // connect with the next part
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

        ListNode result = reverse2(head, 2, 4);
        Assert.assertEquals(1, result.val);
        Assert.assertEquals(4, result.next.val);
        Assert.assertEquals(3, result.next.next.val);
        Assert.assertEquals(2, result.next.next.next.val);
        Assert.assertEquals(5, result.next.next.next.next.val);
        Assert.assertNull(result.next.next.next.next.next);
    }
}
