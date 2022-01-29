package leetcode.linkedlist;

import linkedlist.design.ListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/linked-list-cycle-ii/
public class LinkedListCycleII {
    public ListNode detectCycle_2(ListNode head) {
        if (head == null) {
            return null;
        }

        Set<ListNode> set = new HashSet<>();

        while (head != null && head.next != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }

        return null;
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode intersect = getIntersectionNode(head);
        if(intersect == null) {
            return null;
        }

        ListNode p1 = head;
        ListNode p2 = intersect;
        while(p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }

    private ListNode getIntersectionNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow) {
                return slow;
            }
        }

        return null;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next;

        Assert.assertEquals(head.next, detectCycle(head));
    }
}
