package leetcode.linkedlist;

import linkedlist.design.ListNode;
import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/remove-duplicates-from-sorted-list/
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }


    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);

        ListNode resuls = deleteDuplicates(head);
        Assert.assertEquals(1, resuls.val);
        Assert.assertEquals(2, resuls.next.val);
        Assert.assertEquals(3, resuls.next.next.val);
        Assert.assertNull(resuls.next.next.next);
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
        Assert.assertEquals(3, resuls.next.next.val);
        Assert.assertEquals(4, resuls.next.next.next.val);
        Assert.assertEquals(5, resuls.next.next.next.next.val);
        Assert.assertNull(resuls.next.next.next.next.next);
    }
}
