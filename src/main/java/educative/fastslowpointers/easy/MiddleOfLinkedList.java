package educative.fastslowpointers.easy;

import linkedlist.design.ListNode;
import org.junit.Assert;
import org.junit.Test;

/*
Given the head of a Singly LinkedList, write a method to return the middle node of the LinkedList.
If the total number of nodes in the LinkedList is even, return the second middle node.

Input: 1 -> 2 -> 3 -> 4 -> 5 -> null ... Output: 3
Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null ... Output: 4
 */
public class MiddleOfLinkedList {

    //brute force
    public static ListNode findMiddle(ListNode head) {

        int listLength = 0;
        ListNode pointer = head;
        while (pointer != null) {
            pointer = pointer.next;
            listLength++;
        }

        int middle = listLength / 2;
        ListNode anotherPointer = head;
        while (middle > 0) {
            anotherPointer = anotherPointer.next;
            middle--;
        }

        return anotherPointer;
    }

    public static ListNode findMiddle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    @Test
    public void verify() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        Assert.assertEquals(3, findMiddle(head).value);
        Assert.assertEquals(3, findMiddle2(head).value);

        head.next.next.next.next.next = new ListNode(6);
        Assert.assertEquals(4, findMiddle(head).value);
        Assert.assertEquals(4, findMiddle2(head).value);

        head.next.next.next.next.next.next = new ListNode(7);
        Assert.assertEquals(4, findMiddle(head).value);
        Assert.assertEquals(4, findMiddle2(head).value);
    }
}
