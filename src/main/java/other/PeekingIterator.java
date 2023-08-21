package other;

import linkedlist.design.ListNode;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {
    private ListNode head;
    private ListNode tail;

    public PeekingIterator(Iterator<Integer> iterator) {
        while (iterator.hasNext()) {
            ListNode node = new ListNode(iterator.next());
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = tail.next;
            }
        }
    }

    public Integer peek() {
        return head == null ? null : head.val;
    }

    @Override
    public Integer next() {
        int val = head.val;
        head = head.next;

        return val;
    }

    @Override
    public boolean hasNext() {
        return head != null;
    }
}
