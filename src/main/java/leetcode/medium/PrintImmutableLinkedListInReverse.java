package leetcode.medium;

import linkedlist.design.ListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/print-immutable-linked-list-in-reverse/
public class PrintImmutableLinkedListInReverse {
    public List<Integer> printLinkedListInReverse(ListNode head) {
        Stack<ListNode> stack = new Stack<>();

        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        List<Integer> results = new ArrayList<>();
        while (!stack.isEmpty()) {
            results.add(stack.pop().value);
        }

        return results;
    }

    public List<Integer> printLinkedListInReverse2(ListNode head) {
        List<Integer> results = new ArrayList<>();
        helper(head, results);

        return results;
    }

    private void helper(ListNode node, List<Integer> results) {
        if (node == null) {
            return;
        }

        helper(node.next, results);
        results.add(node.value);
    }


    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        Assert.assertEquals(List.of(4, 3, 2, 1), printLinkedListInReverse(head));
    }

    @Test
    public void test2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        Assert.assertEquals(List.of(4, 3, 2, 1), printLinkedListInReverse2(head));
    }
}

