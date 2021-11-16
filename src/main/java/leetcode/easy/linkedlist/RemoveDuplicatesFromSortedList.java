package leetcode.easy.linkedlist;

import linkedlist.design.ListNode;
import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/remove-duplicates-from-sorted-list/
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {

            if (prev != null && prev.value == curr.value) {
                ListNode nextTmp = curr.next;
                curr = prev;
                curr.next = nextTmp;
            }

            prev = curr;
            curr = curr.next;
        }

        return head;
    }

    @Test
    public void test() {
        ListNode head= new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        ListNode result = deleteDuplicates(head);
        Assert.assertEquals(1, result.value);
        Assert.assertEquals(2, result.next.value);
        Assert.assertEquals(3, result.next.next.value);
        Assert.assertNull(result.next.next.next);
    }
}
