package educative.fastslowpointers.medium;

import linkedlist.design.ListNode;
import org.junit.Assert;
import org.junit.Test;

/*
Mmodify the LinkedList such that the nodes from the second half of the LinkedList are inserted alternately to the nodes from the first half in reverse order.
-should not use any extra space
-the input LinkedList should be modified in-place.

Input: 2 -> 4 -> 6 -> 8 -> 10 -> 12 -> null
Output: 2 -> 12 -> 4 -> 10 -> 6 -> 8 -> null

Input: 2 -> 4 -> 6 -> 8 -> 10 -> null
Output: 2 -> 10 -> 4 -> 8 -> 6 -> null
 */
public class RearrangeList {
    public static void reorder(ListNode head) {
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode headSecondHalf = reverseList(firstHalfEnd);

        ListNode headFirstHalf = head;
        while (headSecondHalf.next != null) {
            ListNode firstTmp = headFirstHalf.next;
            headFirstHalf.next = headSecondHalf;
            headFirstHalf = firstTmp;

            ListNode secondTmp = headSecondHalf.next;
            headSecondHalf.next = headFirstHalf;
            headSecondHalf = secondTmp;
        }
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTmp;
        }

        return prev;
    }

    private static ListNode endOfFirstHalf(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    @Test
    public void verify() {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(12);

        reorder(head);
        Assert.assertEquals(2, head.val);
        Assert.assertEquals(12, head.next.val);
        Assert.assertEquals(4, head.next.next.val);
        Assert.assertEquals(10, head.next.next.next.val);
        Assert.assertEquals(6, head.next.next.next.next.val);
        Assert.assertEquals(8, head.next.next.next.next.next.val);
    }
}
