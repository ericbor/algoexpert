package leetcode.linkedlist;

import linkedlist.design.ListNode;
import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/reverse-linked-list-ii/
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // Empty list
        if (head == null) {
            return null;
        }

        // Move the two pointers until they reach the proper starting point in the list.
        ListNode curr = head;
        ListNode before = null;
        while (left > 1) {
            before = curr;
            curr = curr.next;

            left--;
            right--;
        }

        // The two pointers that will fix the final connections.
        ListNode con = before;
        ListNode tail = curr;

        // Iteratively reverse the nodes until n becomes 0.
        while (right > 0) {
            ListNode after = curr.next;
            curr.next = before;

            before = curr;
            curr = after;

            right--;
        }

        // Adjust the final connections as explained in the algorithm
        if (con != null) {
            con.next = before;
        } else {
            head = before;//when right = 1
        }

        tail.next = curr;
        return head;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode reversed = reverseBetween(head, 4, 5);
        Assert.assertEquals(1, reversed.val);
        Assert.assertEquals(2, reversed.next.val);
        Assert.assertEquals(3, reversed.next.next.val);
        Assert.assertEquals(5, reversed.next.next.next.val);
        Assert.assertEquals(4, reversed.next.next.next.next.val);
        Assert.assertNull(reversed.next.next.next.next.next);
    }

    @Test
    public void test4() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode reversed = reverseBetween(head, 2, 4);
        Assert.assertEquals(1, reversed.val);
        Assert.assertEquals(4, reversed.next.val);
        Assert.assertEquals(3, reversed.next.next.val);
        Assert.assertEquals(2, reversed.next.next.next.val);
        Assert.assertEquals(5, reversed.next.next.next.next.val);
        Assert.assertNull(reversed.next.next.next.next.next);
    }

    @Test
    public void test2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        ListNode reversed = reverseBetween(head, 1, 1);
        Assert.assertEquals(1, reversed.val);
        Assert.assertEquals(2, reversed.next.val);
        Assert.assertNull(reversed.next.next);
    }

    @Test
    public void test3() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        ListNode reversed = reverseBetween(head, 1, 2);
        Assert.assertEquals(2, reversed.val);
        Assert.assertEquals(1, reversed.next.val);
        Assert.assertNull(reversed.next.next);
    }
}
