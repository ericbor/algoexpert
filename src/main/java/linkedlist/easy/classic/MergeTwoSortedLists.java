package linkedlist.easy.classic;

import linkedlist.design.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/merge-two-sorted-lists/solution/
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // maintain an unchanging reference to node ahead of the return node.
        ListNode dummy = new ListNode(-1);

        ListNode current = dummy;
        while (l1 != null && l2 != null) {
            if (l1.value <= l2.value) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // At least one of l1 and l2 can still have nodes at this point, so connect
        // the non-null list to the end of the merged list.
        current.next = l1 == null ? l2 : l1;

        return dummy.next;
    }

    public ListNode mergeTwoListsRecyrsive(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.value < l2.value) {
            l1.next = mergeTwoListsRecyrsive(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsRecyrsive(l1, l2.next);
            return l2;
        }
    }

    @Test
    public void verify() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);

        ListNode result = mergeTwoLists(l1, l2);
        assertEquals(1, result.value);
        assertEquals(2, result.next.value);
        assertEquals(3, result.next.next.value);
        assertEquals(4, result.next.next.next.value);
        assertEquals(5, result.next.next.next.next.value);
        assertEquals(6, result.next.next.next.next.next.value);
    }
}
