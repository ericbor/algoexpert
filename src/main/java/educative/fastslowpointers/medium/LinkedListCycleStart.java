package educative.fastslowpointers.medium;

import linkedlist.design.ListNode;
import org.junit.Assert;
import org.junit.Test;

/*
Given the head of a Singly LinkedList that contains a cycle, write a function to find the STARTING node of the cycle.

If we know the length of the LinkedList cycle, we can find the start of the cycle:

1. Find the length of the LinkedList cycle
2. Take two pointers (pointer1 and pointer2).
3. Initialize both pointers to point to the start of the LinkedList.
4. Let’s assume that the length of the cycle is ‘K’ nodes. Move pointer2 ahead by ‘K’ nodes.
5. Now, keep incrementing pointer1 and pointer2 until they both meet.

As pointer2 is ‘K’ nodes ahead of pointer1, which means,
pointer2 must have completed one loop in the cycle when both pointers meet.
Their meeting point will be the start of the cycle.
 */
public class LinkedListCycleStart {
    public static ListNode findCycleStart(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                int cycleLength = getCycleLength(slow);

                ListNode pointer1 = head;
                ListNode pointer2 = head;
                while (cycleLength > 0) {
                    pointer2 = pointer2.next;
                    cycleLength--;
                }

                while (pointer1 != pointer2) {
                    pointer1 = pointer1.next;
                    pointer2 = pointer2.next;
                }

                return pointer1;//or node2
            }
        }
        return head;
    }

    private static int getCycleLength(ListNode slow) {
        ListNode current = slow;
        int length = 0;
        do {
            current = current.next;
            length++;
        } while (current != slow);

        return length;
    }

    @Test
    public void verify() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head.next.next.next.next.next.next = head.next.next;
        Assert.assertEquals(3, findCycleStart(head).val);

        head.next.next.next.next.next.next = head.next.next.next;
        Assert.assertEquals(4, findCycleStart(head).val);

        head.next.next.next.next.next.next = head;
        Assert.assertEquals(1, findCycleStart(head).val);
    }
}
