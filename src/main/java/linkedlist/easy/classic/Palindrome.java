package linkedlist.easy.classic;

import linkedlist.design.ListNode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/palindrome-linked-list/
public class Palindrome {
    //Time: O(n), Space: O(n)
    public boolean isPalindrome(ListNode head) {
        List<Integer> headArray = new ArrayList<>();

        while (head != null) {
            headArray.add(head.val);
            head = head.next;
        }

        int right = 0;
        int left = headArray.size() - 1;
        while (right < left) {
            if (!headArray.get(right).equals(headArray.get(left))) {
                return false;
            }
            right++;
            left--;
        }

        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        if (head == null) {
            return true;
        }

        // Find the end of first half and reverse second half
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

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
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    // Taken from https://leetcode.com/problems/reverse-linked-list/solution/
    private ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextTmp = current.next;
            current.next = previous;
            previous = current;
            current = nextTmp;
        }

        return previous;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
