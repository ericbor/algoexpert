package leetcode.linkedlist;

import linkedlist.design.ListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/sort-list/
public class SortList {
    public ListNode sortList(ListNode head) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        ListNode node = head;
        while(node != null) {
            minHeap.add(node.val);
            node = node.next;
        }

        ListNode sentinel = new ListNode(Integer.MIN_VALUE);
        ListNode pointer = sentinel;
        while(!minHeap.isEmpty()) {
            int val = minHeap.poll();
            ListNode curr = head;
            while(curr.val != val) {
                curr = curr.next;
            }
            pointer.next = curr;
            pointer = pointer.next;
        }
        pointer.next = null;

        return sentinel.next;
    }

    @Test
    public void test() {
        ListNode head= new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        ListNode sorted = sortList(head);
        Assert.assertEquals(1, sorted.val);
        Assert.assertEquals(2, sorted.next.val);
        Assert.assertEquals(3, sorted.next.next.val);
        Assert.assertEquals(4, sorted.next.next.next.val);
        Assert.assertNull(sorted.next.next.next.next);
    }
}
