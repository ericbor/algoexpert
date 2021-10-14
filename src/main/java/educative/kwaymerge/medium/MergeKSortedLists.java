package educative.kwaymerge.medium;

import linkedlist.design.ListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Queue;

/*
Given an array of ‘K’ sorted LinkedLists, merge them into one sorted list.

Input: L1=[2, 6, 8], L2=[3, 6, 7], L3=[1, 3, 4]
Output: [1, 2, 3, 3, 4, 6, 6, 7, 8]

Input: L1=[5, 8, 9], L2=[1, 7]
Output: [1, 5, 7, 8, 9]
 */
public class MergeKSortedLists {
    public static ListNode merge(ListNode[] lists) {
        Queue<ListNode> minHeap = new PriorityQueue<>((n1, n2) -> n1.value - n2.value);

        // put the root of each list in the min heap
        for (ListNode root : lists) {
            if (root != null) {
                minHeap.add(root);
            }
        }

        // take the smallest (top) element form the min-heap and add it to the result;
        // if the top element has a next element add it to the heap
        ListNode resultHead = null;
        ListNode resultTail = null;
        while (!minHeap.isEmpty()) {
            ListNode curr = minHeap.poll();
            if (resultHead == null) {
                resultHead = curr;
                resultTail = curr;
            } else {
                resultTail.next = curr;
                resultTail = resultTail.next;
            }

            if (curr.next != null) {
                minHeap.add(curr.next);
            }
        }

        return resultHead;
    }

    @Test
    public void main() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(6);
        l1.next.next = new ListNode(8);

        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(7);

        ListNode l3 = new ListNode(1);
        l3.next = new ListNode(3);
        l3.next.next = new ListNode(4);

        ListNode result = merge(new ListNode[] { l1, l2, l3 });
        Assert.assertEquals(1, result.value);
        Assert.assertEquals(2, result.next.value);
        Assert.assertEquals(3, result.next.next.value);
        Assert.assertEquals(3, result.next.next.next.value);
        Assert.assertEquals(4, result.next.next.next.next.value);
        Assert.assertEquals(6, result.next.next.next.next.next.value);
        Assert.assertEquals(6, result.next.next.next.next.next.next.value);
        Assert.assertEquals(7, result.next.next.next.next.next.next.next.value);
        Assert.assertEquals(8, result.next.next.next.next.next.next.next.next.value);
        Assert.assertNull(result.next.next.next.next.next.next.next.next.next);
    }
}
