package leetcode.linkedlist;

import linkedlist.design.ListNode;
import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/partition-list
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);

        ListNode leftTail = left;
        ListNode rightTail = right;

        while (head != null) {
            if (head.val < x) {
                leftTail.next = head;
                leftTail = leftTail.next;
            } else {
                rightTail.next = head;
                rightTail = rightTail.next;
            }
            head = head.next;
        }

        leftTail.next = right.next;
        rightTail.next = null;

        return left.next;
    }

    @Test
    public void test2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        ListNode rotated = partition(head, 3);
        Assert.assertEquals(1, rotated.val);
        Assert.assertEquals(2, rotated.next.val);
        Assert.assertEquals(2, rotated.next.next.val);
        Assert.assertEquals(4, rotated.next.next.next.val);
        Assert.assertEquals(3, rotated.next.next.next.next.val);
        Assert.assertEquals(5, rotated.next.next.next.next.next.val);
        Assert.assertNull(rotated.next.next.next.next.next.next);
    }
}
