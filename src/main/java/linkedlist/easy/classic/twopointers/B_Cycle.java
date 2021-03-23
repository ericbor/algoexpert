package linkedlist.easy.classic.twopointers;

import linkedlist.design.ListNode;

//https://leetcode.com/problems/linked-list-cycle-ii/
public class B_Cycle {
    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        // If there is a cycle, the fast/slow pointers will intersect at some node.
        // Otherwise, there is no cycle.
        ListNode intersect = getIntersect(head);
        if(intersect == null) {
            return null;
        }

        // To find the entrance to the cycle, we have two pointers traverse at the same speed:
        // one  - from the front of the list,
        // the other -  from the point of intersection.
        ListNode node1 = head;
        ListNode node2 = intersect;
        while (node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
        }

        return node1;
    }

    private ListNode getIntersect(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return slow;
            }
        }

        return null;
    }
}
