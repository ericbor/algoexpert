package educative.linkedlist;

import linkedlist.design.ListNode;
import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/delete-node-in-a-linked-list/
public class DeleteNode {
    public void deleteNode(ListNode node) {
        if(node != null && node.next != null){
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        deleteNode(head.next.next);

        Assert.assertEquals(1, head.val);
        Assert.assertEquals(2, head.next.val);
        Assert.assertEquals(4, head.next.next.val);
        Assert.assertEquals(5, head.next.next.next.val);
        Assert.assertNull(head.next.next.next.next);
    }
}
