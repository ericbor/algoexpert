package leetcode.easy.linkedlist;

import linkedlist.design.ListNode;
import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/middle-of-the-linked-list/
public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        int listSize = 0;

        ListNode headCopy = head;
        while(headCopy != null) {
            headCopy = headCopy.next;
            listSize++;
        }

        for(int i = 1; i <= listSize / 2; i++) {
            head = head.next;
        }

        return head;
    }

    @Test
    public void test() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);

        ListNode middle = middleNode(node);
        Assert.assertEquals(4, middle.val);
    }

    @Test
    public void test2() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        ListNode middle = middleNode(node);
        Assert.assertEquals(3, middle.val);
    }
}
