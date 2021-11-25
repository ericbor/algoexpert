package leetcode.easy.linkedlist;

import linkedlist.design.ListNode;
import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/intersection-of-two-linked-lists/
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aSize = 0;
        ListNode currA = headA;
        while (currA != null) {
            aSize++;
            currA = currA.next;
        }
        currA = headA;

        int bSize = 0;
        ListNode currB = headB;
        while (currB != null) {
            bSize++;
            currB = currB.next;
        }
        currB = headB;

        if (aSize > bSize) {
            return findIntersection(currA, currB, aSize - bSize);
        }

        return findIntersection(currB, currA, bSize - aSize);
    }

    private ListNode findIntersection(ListNode headA, ListNode headB, int skip) {
        while (skip > 0) {
            headA = headA.next;
            skip--;
        }

        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }

            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
        // Note: In the case lists do not intersect, the pointers for A and B
        // will still line up in the 2nd iteration, just that here won't be
        // a common node down the list and both will reach their respective ends
        // at the same time. So pA will be NULL in that case.
    }

    @Test
    public void tets() {
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = new ListNode(8);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = headA.next.next;

        Assert.assertEquals(8, getIntersectionNode(headA, headB).value);
    }

    @Test
    public void tets2() {
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = new ListNode(8);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = headA.next.next;

        Assert.assertEquals(8, getIntersectionNode2(headA, headB).value);
    }
}
