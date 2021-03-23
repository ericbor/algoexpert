package linkedlist.easy.classic.twopointers;

import linkedlist.design.ListNode;

//https://leetcode.com/problems/intersection-of-two-linked-lists/
public class C_Intersection {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;

        while(p1 != p2){
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }

        return p1;
    }
}
