package linkedlist.easy.classic;

import linkedlist.design.ListNode;

//https://leetcode.com/problems/odd-even-linked-list/
public class OddEven {
    public ListNode oddEvenList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while(even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }
}
