package leetcode.linkedlist;

import linkedlist.design.ListNode;
import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        // sentinel
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        // predecessor = the last node before the sublist of duplicates
        ListNode pred = sentinel;

        while (head != null) {
            // if it's a beginning of duplicates sublist skip all duplicates
            if (head.next != null && head.val == head.next.val) {
                // move till the end of duplicates sublist
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }

                // skip all duplicates
                pred.next = head.next;
            } else {
                // otherwise, move predecessor
                pred = pred.next;
            }

            // move forward
            head = head.next;
        }

        return sentinel.next;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);

        ListNode resuls = deleteDuplicates(head);
        Assert.assertEquals(2, resuls.val);
        Assert.assertEquals(3, resuls.next.val);
        Assert.assertNull(resuls.next.next);
    }

    @Test
    public void test2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        ListNode resuls = deleteDuplicates(head);
        Assert.assertEquals(1, resuls.val);
        Assert.assertEquals(2, resuls.next.val);
        Assert.assertEquals(5, resuls.next.next.val);
        Assert.assertNull(resuls.next.next.next);
    }
}
