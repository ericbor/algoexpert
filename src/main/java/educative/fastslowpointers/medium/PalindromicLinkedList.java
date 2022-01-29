package educative.fastslowpointers.medium;

import linkedlist.design.ListNode;
import org.junit.Assert;
import org.junit.Test;

/*
Given the head of a Singly LinkedList, write a method to check if the LinkedList is a palindrome or not.

-Your algorithm should use constant space
-Input LinkedList should be in the original form once the algorithm is finished.
-The algorithm should have O(N) time complexity where ‘N’ is the number of nodes in the LinkedList.

Input: 2 -> 4 -> 6 -> 4 -> 2 -> null ... Output: true
Input: 2 -> 4 -> 6 -> 4 -> 2 -> 2 -> null ...Output: false

Solution:
1. Fast & Slow pointers -  to find the middle node of the LinkedList.
2. Reverse the second half.
3. Compare the first half with the reversed second half.
4. Reverse the second half again to revert and bring the LinkedList back to its original form.
 */
public class PalindromicLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // Find the end of first half and reverse second half.
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd);

        // Check whether or not there is a palindrome.
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // Restore the list and return the result.
        reverseList(secondHalfStart);
        return result;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            // Before changing next of current, store next Node
            ListNode nextTemp = curr.next;
            // Now change next of current. This is where actual reversing happens
            curr.next = prev;
            // Move prev and curr one step forward
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    @Test
    public void verify() {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        Assert.assertTrue(isPalindrome(head));

        head.next.next.next.next.next = new ListNode(2);
        Assert.assertFalse(isPalindrome(head));
    }
}
